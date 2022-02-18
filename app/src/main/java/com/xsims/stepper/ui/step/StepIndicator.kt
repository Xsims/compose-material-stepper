package com.xsims.stepper.ui.step

import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons.Rounded
import androidx.compose.material.icons.rounded.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import com.xsims.stepper.ui.theme.ACTIVE_STEPPER_CIRCLE_SIZE
import com.xsims.stepper.ui.theme.Black38
import com.xsims.stepper.ui.theme.stepIndicatorStyle

@Composable
fun StepNumberIndicator(
  modifier: Modifier = Modifier,
  index: Int,
  isActive: Boolean,
) {
  StepIndicator(modifier = modifier, isActive = isActive) {
    Text(
      "$index",
      textAlign = TextAlign.Center,
      color = Color.White,
      style = stepIndicatorStyle,
    )
  }
}

@Composable
fun StepIconIndicator(
  modifier: Modifier = Modifier,
  icon: ImageVector,
  isActive: Boolean,
) {
  StepIndicator(modifier = modifier, isActive = isActive) {
    Icon(
      icon,
      tint = Color.White,
      contentDescription = "Step icon"
    )
  }
}

@Composable
fun StepIndicator(
  modifier: Modifier = Modifier,
  isActive: Boolean,
  activeColor: Color = MaterialTheme.colors.primary,
  inactiveColor: Color = Black38,
  composable: @Composable () -> Unit,
) {
  Box(
    contentAlignment = Alignment.Center,
    modifier = modifier
      .width(ACTIVE_STEPPER_CIRCLE_SIZE)
      .height(ACTIVE_STEPPER_CIRCLE_SIZE)
      .background(
        color = if (isActive) activeColor else inactiveColor,
        shape = CircleShape
      )
  ) {
    composable()
  }
}