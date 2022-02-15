package com.xsims.stepper.ui.step

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.xsims.stepper.ui.theme.ACTIVE_STEPPER_CIRCLE_SIZE
import com.xsims.stepper.ui.theme.Black38
import com.xsims.stepper.ui.theme.stepIndicatorStyle

@Composable
fun StepNumberIndicator(
  modifier: Modifier = Modifier,
  index: Int,
  active: Boolean,
) {
  StepIndicator(modifier = modifier, active = active) {
    Text(
      "$index",
      textAlign = TextAlign.Center,
      color = Color.White,
      style = stepIndicatorStyle,
    )
  }
}

//@Composable
//fun StepImageIndicator(
//  @DrawableRes id: Int
//) {
//  Image(
//    painter = painterResource(drawable.ic_launcher_foreground),
//    contentDescription = null,
//    modifier = Modifier
//      .size(40.dp)
//      .clip(CircleShape)
//      .border(1.5.dp, MaterialTheme.colors.secondaryVariant, CircleShape)
//  )
//}

@Composable
fun StepIndicator(
  modifier: Modifier = Modifier,
  active: Boolean,
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
        color = if (active) activeColor else inactiveColor,
        shape = CircleShape
      )
  ) {
    composable()
  }
}