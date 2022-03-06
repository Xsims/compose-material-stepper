package com.xsims.stepper.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.xsims.stepper.ui.theme.Black38
import com.xsims.stepper.ui.theme.StepperTheme
import com.xsims.stepper_compose.Step
import com.xsims.stepper_compose.Stepper

@Preview(showSystemUi = true)
@Composable
fun MaterialStepperScreen() {
  StepperTheme {
    Stepper(
      steps = List(4) { index ->
        Step(
          title = "Name of step ${index + 1}",
          subtitle = "Subtitle of step ${index + 1}"
        ) {
          Box(
            modifier = Modifier
              .height(250.dp)
              .fillMaxWidth()
              .background(color = Black38)
          )
        }
      }
    )
  }
}