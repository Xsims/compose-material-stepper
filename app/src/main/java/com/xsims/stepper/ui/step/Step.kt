package com.xsims.stepper.ui.step

import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.IntrinsicSize.Max
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.constraintlayout.compose.Dimension.Companion
import androidx.constraintlayout.compose.atLeast
import com.xsims.stepper.ui.theme.Grey400

/** A material step used in [Stepper]. The step can have a title and subtitle,
 * an icon within its circle, some content and a state that governs its
 * styling.
 *
 * also:
 *
 * @see [Stepper]
 * @see [Guidelines](https://material.io/archive/guidelines/components/steppers.html)
 */
@Immutable
class Step constructor(
  val title: String,
  val subtitle: String? = null,
  val activeIcon: Icon? = null,
  val isActive: Boolean = false,
  val content: @Composable () -> Unit)


@Composable
fun StepUi(
  stepNumber: Int,
  title: String,
  expanded: Boolean,
  isLastStep: Boolean,
  enablePositiveButton: Boolean,
  enableNegativeButton: Boolean,
  onClickPositiveButton: () -> Unit,
  onClickNegativeButton: () -> Unit,
  content: @Composable () -> Unit,
) {
  ConstraintLayout(modifier = Modifier.padding(bottom = 8.dp).fillMaxWidth()) {

    val (stepIndicatorId, dividerId, titleId, contentId) = createRefs()

    StepNumberIndicator(modifier = Modifier.constrainAs(stepIndicatorId) {
      top.linkTo(parent.top)
      start.linkTo(parent.start)
    }, stepNumber, active = expanded)

    StepTitle(
      modifier = Modifier.constrainAs(titleId) {
        top.linkTo(stepIndicatorId.top)
        bottom.linkTo(stepIndicatorId.bottom)
        start.linkTo(stepIndicatorId.end, margin = 16.dp)
      },
      text = title,
      active = expanded
    )

    if(!isLastStep) {
      StepDivider(
        color = Grey400,
        modifier = Modifier
          .constrainAs(dividerId) {
            height = Dimension.fillToConstraints.atLeast(16.dp)
            top.linkTo(stepIndicatorId.bottom, margin = 8.dp)
            start.linkTo(stepIndicatorId.start)
            end.linkTo(stepIndicatorId.end)
            bottom.linkTo(contentId.bottom)
          }
      )
    }

    StepContent(
      modifier = Modifier
        .constrainAs(contentId) {
          width = Companion.fillToConstraints
          top.linkTo(stepIndicatorId.bottom, margin = 8.dp)
          start.linkTo(titleId.start)
          end.linkTo(parent.end)
        },
      visible = expanded,
      enablePositiveButton = enablePositiveButton,
      enableNegativeButton = enableNegativeButton,
      onClickPositiveButton = onClickPositiveButton,
      onClickNegativeButton = onClickNegativeButton,
      content = content
    )
  }
}