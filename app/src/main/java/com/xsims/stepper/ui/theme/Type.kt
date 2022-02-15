package com.xsims.stepper.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

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

// Set of Material typography styles to start with
val Typography = Typography(
  body1 = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.Normal,
    fontSize = 16.sp
  )
)