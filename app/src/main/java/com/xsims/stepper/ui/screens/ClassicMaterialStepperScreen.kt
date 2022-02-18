package com.xsims.stepper.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.xsims.stepper.Stepper
import com.xsims.stepper.ui.step.Step
import com.xsims.stepper.ui.theme.Black38
import com.xsims.stepper.ui.theme.StepperTheme

@Preview
@Composable
fun ClassicMaterialStepperScreen() {
  val currentStep = remember { mutableStateOf(0) }

  StepperTheme {
    Stepper(
      currentStep = currentStep,
      steps = listOf(
        Step(title = "Name of step 1", subtitle = "Subtitle of step 1") {
          Box(
            modifier = Modifier
              .height(250.dp)
              .fillMaxWidth()
              .background(color = Black38)
          )
        },
        Step(title = "Name of step 2") { Text("Content of step 2") },
        Step(title = "Name of step 3") { Text("Content of step 3") },
        Step(title = "Name of step 4") { Text("Content of step 4") }
      )
    )
  }
}