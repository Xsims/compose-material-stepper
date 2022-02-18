package com.xsims.stepper.ui.step

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons.Rounded
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material.icons.rounded.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.constraintlayout.compose.Dimension.Companion
import androidx.constraintlayout.compose.atLeast
import com.xsims.stepper.ui.step.StepState.COMPLETE
import com.xsims.stepper.ui.step.StepState.ERROR
import com.xsims.stepper.ui.step.StepState.TODO
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
class Step(
  val title: String,
  val subtitle: String? = null,
  val activeIcon: Icon? = null,
  val isActive: Boolean = false,
  var state: MutableState<StepState> = mutableStateOf(StepState.TODO),
  val onStepComplete: (Step) -> Unit = { },
  val content: @Composable () -> Unit
)

enum class StepState {
  COMPLETE,
  ERROR,
  TODO
}

@Composable
fun StepUi(
  stepNumber: Int,
  title: String,
  subtitle: String? = null,
  activeIcon: ImageVector? = null,
  expanded: Boolean,
  isLastStep: Boolean,
  enablePositiveButton: Boolean,
  enableNegativeButton: Boolean,
  onClickPositiveButton: (Step) -> Unit,
  onClickNegativeButton: (Step) -> Unit,
  onStepComplete: (Step) -> Unit,
  content: @Composable () -> Unit,
  step: Step,
) {
  ConstraintLayout(
    modifier = Modifier
      .padding(bottom = 8.dp)
      .fillMaxWidth()
  ) {

    val (stepIndicatorId, dividerId, titleId, contentId) = createRefs()

    val stepIndicatorConstraints = Modifier.constrainAs(stepIndicatorId) {
      top.linkTo(parent.top)
      start.linkTo(parent.start)
    }
    when (step.state.value) {
      ERROR -> StepIconIndicator(
        modifier = stepIndicatorConstraints,
        isActive = expanded,
        icon = Rounded.Close
      )
      TODO -> {
        if (activeIcon != null) {
          StepIconIndicator(
            modifier = stepIndicatorConstraints,
            isActive = expanded,
            icon = activeIcon
          )
        } else {
          StepNumberIndicator(
            modifier = stepIndicatorConstraints,
            stepNumber,
            isActive = expanded
          )
        }
      }
      COMPLETE -> {
        StepIconIndicator(
          modifier = stepIndicatorConstraints,
          isActive = expanded,
          icon = Rounded.Check
        )
        onStepComplete(step)
      }
    }

    StepTitle(
      modifier = Modifier.constrainAs(titleId) {
        top.linkTo(stepIndicatorId.top)
        bottom.linkTo(stepIndicatorId.bottom)
        start.linkTo(stepIndicatorId.end, margin = 16.dp)
      },
      title = title,
      subtitle = subtitle,
      active = expanded
    )

    if (!isLastStep) {
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
      step = step,
      content = content
    )
  }
}