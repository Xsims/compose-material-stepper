package com.xsims.stepper.ui.step

import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.Dimension

@Composable
fun StepDivider(
  modifier: Modifier,
  color: Color
) {
  Divider(
    color = color,
    modifier = modifier
      .width(1.dp)
  )
}