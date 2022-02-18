package com.xsims.stepper

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.xsims.stepper.ui.step.Step
import com.xsims.stepper.ui.step.StepState.COMPLETE
import com.xsims.stepper.ui.step.StepState.ERROR
import com.xsims.stepper.ui.step.StepState.TODO
import com.xsims.stepper.ui.theme.Black38
import com.xsims.stepper.ui.theme.StepperTheme

class MainActivity : ComponentActivity() {

  private lateinit var currentStep: MutableState<Int>

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent { MainActivityPreview() }
  }

  private val statePrintAppStep = mutableStateOf(TODO)

  private val printAppStep = Step(
    title = "Printing App",
    subtitle = "Print Connect App must be installed",
    state = statePrintAppStep,
  ) {
    when (statePrintAppStep.value) {
      ERROR -> Button(onClick = { statePrintAppStep.value = COMPLETE }) {
        Text("RETRY")
      }
      TODO -> Button(onClick = { statePrintAppStep.value = ERROR }) {
        Text("click")
      }
      COMPLETE -> {
        Text("Complete")
        nextStep()
      }
    }
  }

  private val steps = listOf(
    printAppStep,
    Step(title = "Printing App", subtitle = "Print Connect App must be installed") {
      Column(
        modifier = Modifier.padding(top = 8.dp, end = 24.dp)
      ) {
        Text(
          text = "L’application print connect n’est pas détecté sur votre PDA.",
          style = MaterialTheme.typography.caption
        )
        Box(
          modifier = Modifier.fillMaxWidth(),
          contentAlignment = Alignment.Center,
        ) {
          Icon(
            Icons.Rounded.Close,
            modifier = Modifier
              .size(48.dp),
            tint = Color.Red,
            contentDescription = "Application non installée"
          )
        }
        Text(
          text = "Celle-ci est necessaire pour imprimer depuis l’application DLC Memo .\n\n" +
              "Si votre PDA autorise le téléchargement de nouvelles applications cliquer sur :",
          style = MaterialTheme.typography.caption
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { /*TODO*/ }) {
          Text("Télécharger Print Connect".uppercase())
        }
      }
    },
    Step(
      title = "Bluetooth connection",
      subtitle = "Check if Bluetooth is present and enabled"
    ) {
      Box(
        modifier = Modifier
          .height(250.dp)
          .fillMaxWidth()
          .background(color = Black38)
      )
    }
  )

  private fun nextStep() {
    if (currentStep.value < steps.size) {
      currentStep.value = currentStep.value + 1
    }
  }

  private fun previousStep() {
    if(currentStep.value > 0) {
      currentStep.value = currentStep.value - 1
    }
  }

  @Preview(showSystemUi = true)
  @Composable
  fun MainActivityPreview() {
    currentStep = remember { mutableStateOf(0) }
    StepperTheme {
      Stepper(
        currentStep = currentStep,
        enableNegativeButton = false,
        enablePositiveButton = false,
        steps = steps)
    }
  }
}




