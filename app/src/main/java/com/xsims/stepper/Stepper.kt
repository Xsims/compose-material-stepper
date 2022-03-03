package com.xsims.stepper

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.xsims.stepper.ui.step.Step
import com.xsims.stepper.ui.step.StepUi

/**
 * Creates a stepper from a list of steps.
 * This composable function is not meant to be rebuilt with a different list of steps
 * unless a key is provided in order to distinguish the old stepper from the
 * new one.
 *
 * The [steps], [type], and [currentStep] arguments must not be null.
 */
@Composable
fun Stepper(
  //type: StepperType = vertical,
  currentStep: MutableState<Int> = remember { mutableStateOf(0) },
  nextButton: @Composable (() -> Unit)? = {
    Button(onClick = {
      if (currentStep.value < steps.size) {
        currentStep.value = currentStep.value + 1
      }
    }) { Text("Next".uppercase()) }
  },
  previousButton: @Composable (() -> Unit)? = {
    TextButton(onClick = {
      if(currentStep.value > 0) {
        currentStep.value = currentStep.value - 1
      }
    }) { Text("Cancel".uppercase(), color = Color.Gray) }
  },
  steps: List<Step>,
) {
  Column(modifier = Modifier.padding(20.dp)) {
    steps.forEachIndexed { index, step ->
      StepUi(
        index = index + 1,
        step = step,
        expanded = index == currentStep.value,
        isLastStep = index == (steps.size - 1),
        nextButton = nextButton,
        previousButton = previousButton,
      )
    }
  }
}

/**
 * Defines the [Stepper]'s main axis.
 */
enum class StepperType {
  // A vertical layout of the steps with their content in-between the titles.
  vertical,

  // A horizontal layout of the steps with their content below the titles.
  horizontal
}