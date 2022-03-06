package com.xsims.stepper_compose

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

object Const {
  /************* COLORS ***************/
  val Purple500 = Color(0xFF6200EE)
  val Purple700 = Color(0xFF3700B3)
  val Teal200 = Color(0xFF03DAC5)
  val Grey400 = Color(0xFFBDBDBD)
  val Blue500 = Color(0xFF2196F3)
  val Black87 = Color(0xDE000000)
  val Black38 = Color(0x61000000)
  val Black54 = Color(0x8A000000)
  val RedError = Color(0xFFF44336)

  /************** SIZE ****************/
  val ACTIVE_STEPPER_CIRCLE_SIZE = 24.dp

  /************ DURATION **************/
  const val EXPAND_ANIMATION_DURATION = 300
  const val COLLAPSE_ANIMATION_DURATION = 300
  const val FADE_IN_ANIMATION_DURATION = 350
  const val FADE_OUT_ANIMATION_DURATION = 300

  /************** TYPO ***************/
  val stepIndicatorStyle = TextStyle(
    fontWeight = FontWeight.Normal,
    fontSize = 12.sp,
    letterSpacing = 0.1.sp
  )
  val activeStepTitleStyle = TextStyle(
    fontWeight = FontWeight.Medium,
    fontSize = 14.sp,
    letterSpacing = 0.1.sp
  )
  val inactiveStepTitleStyle = TextStyle(
    fontWeight = FontWeight.Normal,
    fontSize = 14.sp,
    letterSpacing = 0.1.sp
  )
  val stepSubtitleStyle = TextStyle(
    fontWeight = FontWeight.Normal,
    fontSize = 12.sp,
    letterSpacing = 0.1.sp
  )
}