package com.xsims.stepper

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize.Max
import androidx.compose.foundation.layout.IntrinsicSize.Min
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.xsims.stepper.ui.step.Step
import com.xsims.stepper.ui.theme.Black38
import com.xsims.stepper.ui.theme.StepperTheme

class MainActivity : ComponentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      MainActivityPreview()
    }
  }

  @Preview(showSystemUi = true)
  @Composable
  fun MainActivityPreview() {
    val currentStep = remember { mutableStateOf(0) }
    StepperTheme {
      Stepper(
        currentStep = currentStep,
        steps = steps
      )
    }
  }

  private val steps = listOf(
    Step(title = "Name of step 1") {
      Box(modifier = Modifier
        .height(250.dp)
        .fillMaxWidth()
        .background(color = Black38))
    },
    Step(title = "Name of step 2") {
      Text(
        "title 1",
        color = MaterialTheme.colors.secondaryVariant,
        style = MaterialTheme.typography.subtitle2
      )
    },
    Step("Name of step 3") {
      Text(
        "title 1",
        color = MaterialTheme.colors.secondaryVariant,
        style = MaterialTheme.typography.subtitle2
      )
    },
    Step("Name of step 4") {
      Text(
        "title 1",
        color = MaterialTheme.colors.secondaryVariant,
        style = MaterialTheme.typography.subtitle2
      )
    }
  )
}




