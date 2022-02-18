package com.xsims.stepper.ui.step

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize.Max
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.xsims.stepper.ui.theme.COLLAPSE_ANIMATION_DURATION
import com.xsims.stepper.ui.theme.EXPAND_ANIMATION_DURATION
import com.xsims.stepper.ui.theme.FADE_IN_ANIMATION_DURATION
import com.xsims.stepper.ui.theme.FADE_OUT_ANIMATION_DURATION

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun StepContent(
  modifier: Modifier,
  visible: Boolean = true,
  enablePositiveButton: Boolean,
  enableNegativeButton: Boolean,
  onClickPositiveButton: (Step) -> Unit = { },
  onClickNegativeButton: (Step) -> Unit = { },
  content: @Composable () -> Unit,
  step: Step,
) {
  val enterFadeIn = remember {
    fadeIn(
      animationSpec = TweenSpec(
        durationMillis = FADE_IN_ANIMATION_DURATION,
        easing = FastOutLinearInEasing
      )
    )
  }
  val enterExpand = remember {
    expandVertically(animationSpec = tween(EXPAND_ANIMATION_DURATION))
  }
  val exitFadeOut = remember {
    fadeOut(
      animationSpec = TweenSpec(
        durationMillis = FADE_OUT_ANIMATION_DURATION,
        easing = LinearOutSlowInEasing
      )
    )
  }
  val exitCollapse = remember {
    shrinkVertically(animationSpec = tween(COLLAPSE_ANIMATION_DURATION))
  }
  AnimatedVisibility(
    modifier = modifier,
    visible = visible,
    enter = enterExpand + enterFadeIn,
    exit = exitCollapse + exitFadeOut
  ) {
    Column {
      Spacer(modifier = Modifier.height(4.dp))
      content()
      Spacer(modifier = Modifier.height(16.dp))

      Row {
        if (enablePositiveButton)
          Button(
            modifier = Modifier.padding(end = 16.dp),
            onClick = { onClickPositiveButton(step) }) {
            Text("Continue".uppercase())
          }
        if (enableNegativeButton)
          TextButton(
            onClick = { onClickNegativeButton(step) }) {
            Text(
              "Cancel".uppercase(),
              color = Color.Gray,
            )
          }
      }

      Spacer(modifier = Modifier.height(40.dp))
    }
  }
}