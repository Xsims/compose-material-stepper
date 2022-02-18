package com.xsims.stepper

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.xsims.stepper.StepperType.vertical
import com.xsims.stepper.ui.step.Step
import com.xsims.stepper.ui.step.StepState.ERROR
import com.xsims.stepper.ui.step.StepUi

/**
 * Defines the [Stepper]'s main axis.
 */
enum class StepperType {
  // A vertical layout of the steps with their content in-between the titles.
  vertical,
  // A horizontal layout of the steps with their content below the titles.
  horizontal
}

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
  type: StepperType = vertical,
  currentStep: MutableState<Int> = remember { mutableStateOf(0) },
  enablePositiveButton: Boolean = true,
  enableNegativeButton: Boolean = true,
  onClickPositiveButton: (Step) -> Unit = {
    if(currentStep.value < steps.size) {
      currentStep.value = currentStep.value + 1
    }
  },
  onClickNegativeButton: (Step) -> Unit = {
    if(currentStep.value > 0) {
      currentStep.value = currentStep.value - 1
    }
  },
  steps: List<Step>,
) {
  Column(modifier = Modifier.padding(20.dp)) {
    steps.forEachIndexed { index, step ->
      StepUi(
        stepNumber = index + 1,
        title = step.title,
        subtitle = step.subtitle,
        expanded = index == currentStep.value,
        isLastStep = index == (steps.size - 1),
        enablePositiveButton = enablePositiveButton,
        enableNegativeButton = enableNegativeButton,
        onClickPositiveButton = onClickPositiveButton,
        onClickNegativeButton = onClickNegativeButton,
        onStepComplete = step.onStepComplete,
        content = step.content,
        step = step,
      )
    }
  }
}