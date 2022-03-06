package com.xsims.stepper_compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

/**
 * The step title is following material [guideline's](https://material.io/archive/guidelines/components/steppers.html#steppers-usage) :
 *
 * Active step title
 * * 14sp Roboto Medium
 * * 87% black
 *
 * Inactive step title
 * * 14sp Roboto Regular
 * * 38% black
 */
@Composable
fun StepTitle(
  modifier: Modifier,
  title: String,
  subtitle: String? = null,
  active: Boolean,
  isError: Boolean = false
) {
  Column( modifier = modifier) {
    Text(
      text = title,
      maxLines = 1,
      overflow = TextOverflow.Ellipsis,
      color = if(isError) Const.RedError else if(active) Const.Black87 else Const.Black38,
      style = if(active) Const.activeStepTitleStyle else Const.inactiveStepTitleStyle
    )
    subtitle?.let {
      Text(
        modifier = Modifier.padding(top = 0.dp),
        text = it,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        color = if(isError) Const.RedError else Const.Black54,
        style = Const.stepSubtitleStyle
      )
    }
  }
}