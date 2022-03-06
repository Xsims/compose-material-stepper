package com.xsims.stepper_compose

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
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun StepContent(
  modifier: Modifier,
  visible: Boolean = true,
  nextButton: @Composable (() -> Unit)? = null,
  previousButton: @Composable (() -> Unit)? = null,
  step: Step,
) {
  val enterFadeIn = remember {
    fadeIn(
      animationSpec = TweenSpec(
        durationMillis = Const.FADE_IN_ANIMATION_DURATION,
        easing = FastOutLinearInEasing
      )
    )
  }
  val enterExpand = remember {
    expandVertically(animationSpec = tween(Const.EXPAND_ANIMATION_DURATION))
  }
  val exitFadeOut = remember {
    fadeOut(
      animationSpec = TweenSpec(
        durationMillis = Const.FADE_OUT_ANIMATION_DURATION,
        easing = LinearOutSlowInEasing
      )
    )
  }
  val exitCollapse = remember {
    shrinkVertically(animationSpec = tween(Const.COLLAPSE_ANIMATION_DURATION))
  }
  AnimatedVisibility(
    modifier = modifier,
    visible = visible,
    enter = enterExpand + enterFadeIn,
    exit = exitCollapse + exitFadeOut
  ) {
    Column {
      Spacer(modifier = Modifier.height(4.dp))
      step.content()
      Spacer(modifier = Modifier.height(16.dp))

      Row {
        nextButton?.invoke()
        Spacer(modifier = Modifier.width(16.dp))
        previousButton?.invoke()
      }

      Spacer(modifier = Modifier.height(40.dp))
    }
  }
}