package com.xsims.stepper.ui.step

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.xsims.stepper.ui.theme.ACTIVE_STEPPER_CIRCLE_SIZE
import com.xsims.stepper.ui.theme.Black38
import com.xsims.stepper.ui.theme.RedError
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

@Preview
@Composable
fun StepErrorIconIndicator(
  modifier: Modifier = Modifier,
  errorIcon: ImageVector = Icons.Filled.Warning,
  isActive: Boolean = false,
  tint: Color = RedError,
  backgroundActiveColor: Color = Color.Transparent,
  backgroundInactiveColor: Color = Color.Transparent
) {
  StepIconIndicator(
    modifier = modifier,
    icon = errorIcon,
    isActive = isActive,
    tint = tint,
    backgroundActiveColor = backgroundActiveColor,
    backgroundInactiveColor = backgroundInactiveColor
  )
}

@Composable
fun StepIconIndicator(
  modifier: Modifier = Modifier,
  icon: ImageVector,
  isActive: Boolean = false,
  tint: Color = Color.White,
  backgroundActiveColor: Color = MaterialTheme.colors.primary,
  backgroundInactiveColor: Color = Black38,
) {
    StepIndicator(modifier = modifier,
      isActive = isActive,
      activeColor = backgroundActiveColor,
      inactiveColor = backgroundInactiveColor
    ) {
      Icon(
        icon,
        modifier = Modifier.size(16.dp),
        tint = tint,
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