package com.xsims.stepper

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.xsims.stepper.ui.screens.MaterialStepperScreen
import com.xsims.stepper.ui.screens.StateStepperScreen

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
    var tabIndex by remember { mutableStateOf(0) }
    val tabTitles = listOf("Material", "State")
    Column {
      TabRow(selectedTabIndex = tabIndex) {
        tabTitles.forEachIndexed { index, title ->
          Tab(selected = tabIndex == index,
            onClick = { tabIndex = index },
            text = { Text(text = title) })
        }
      }
      when (tabIndex) {
        0 -> MaterialStepperScreen()
        1 -> StateStepperScreen()
      }
    }
  }
}




