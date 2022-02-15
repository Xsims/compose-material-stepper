package com.xsims.stepper.ui.step

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import com.xsims.stepper.ui.theme.Black38
import com.xsims.stepper.ui.theme.Black87
import com.xsims.stepper.ui.theme.activeStepTitleStyle
import com.xsims.stepper.ui.theme.inactiveStepTitleStyle

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
  text: String,
  active: Boolean
) {
  Text(
    modifier = modifier,
    text = text,
    maxLines = 1,
    overflow = TextOverflow.Ellipsis,
    color = if(active) Black87 else Black38,
    style = if(active) activeStepTitleStyle else inactiveStepTitleStyle
  )
}