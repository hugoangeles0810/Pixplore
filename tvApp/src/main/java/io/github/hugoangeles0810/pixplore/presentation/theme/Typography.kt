package io.github.hugoangeles0810.pixplore.presentation.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextMotion
import androidx.compose.ui.unit.sp
import androidx.tv.material3.Typography
import io.github.hugoangeles0810.pixplore.R

private val Inter = FontFamily(
    fonts = listOf(
        Font(R.font.inter_black, weight = FontWeight.Black),
        Font(R.font.inter_bold, weight = FontWeight.Bold),
        Font(R.font.inter_extra_bold, weight = FontWeight.ExtraBold),
        Font(R.font.inter_extra_light, weight = FontWeight.ExtraLight),
        Font(R.font.inter_light, weight = FontWeight.Light),
        Font(R.font.inter_medium, weight = FontWeight.Medium),
        Font(R.font.inter_regular, weight = FontWeight.Normal),
        Font(R.font.inter_semi_bold, weight = FontWeight.SemiBold),
        Font(R.font.inter_thin, weight = FontWeight.Thin)
    )
)

val Typography = Typography(
    displayLarge = TextStyle(
        fontSize = 57.sp,
        lineHeight = 64.sp,
        fontWeight = FontWeight.Normal,
        letterSpacing = (-0.25).sp,
        fontFamily = Inter,
        textMotion = TextMotion.Animated
    ),
    displayMedium = TextStyle(
        fontSize = 45.sp,
        lineHeight = 52.sp,
        fontWeight = FontWeight.Normal,
        letterSpacing = 0.sp,
        fontFamily = Inter,
        textMotion = TextMotion.Animated
    ),
    displaySmall = TextStyle(
        fontSize = 36.sp,
        lineHeight = 44.sp,
        fontWeight = FontWeight.Normal,
        letterSpacing = 0.sp,
        fontFamily = Inter,
        textMotion = TextMotion.Animated
    ),
    headlineLarge = TextStyle(
        fontSize = 32.sp,
        lineHeight = 40.sp,
        fontWeight = FontWeight.Normal,
        letterSpacing = 0.sp,
        fontFamily = Inter,
        textMotion = TextMotion.Animated
    ),
    headlineMedium = TextStyle(
        fontSize = 28.sp,
        lineHeight = 36.sp,
        fontWeight = FontWeight.Normal,
        letterSpacing = 0.sp,
        fontFamily = Inter,
        textMotion = TextMotion.Animated
    ),
    headlineSmall = TextStyle(
        fontSize = 24.sp,
        lineHeight = 32.sp,
        fontWeight = FontWeight.Normal,
        letterSpacing = 0.sp,
        fontFamily = Inter,
        textMotion = TextMotion.Animated
    ),
    titleLarge = TextStyle(
        fontSize = 22.sp,
        lineHeight = 28.sp,
        fontWeight = FontWeight.Normal,
        letterSpacing = 0.sp,
        fontFamily = Inter,
        textMotion = TextMotion.Animated
    ),
    titleMedium = TextStyle(
        fontSize = 16.sp,
        lineHeight = 24.sp,
        fontWeight = FontWeight.Medium,
        letterSpacing = 0.15.sp,
        fontFamily = Inter,
        textMotion = TextMotion.Animated
    ),
    titleSmall = TextStyle(
        fontSize = 14.sp,
        lineHeight = 20.sp,
        fontWeight = FontWeight.Medium,
        letterSpacing = 0.1.sp,
        fontFamily = Inter,
        textMotion = TextMotion.Animated
    ),
    labelLarge = TextStyle(
        fontSize = 14.sp,
        lineHeight = 20.sp,
        fontWeight = FontWeight.Medium,
        letterSpacing = 0.1.sp,
        fontFamily = Inter,
        textMotion = TextMotion.Animated
    ),
    labelMedium = TextStyle(
        fontSize = 12.sp,
        lineHeight = 16.sp,
        fontWeight = FontWeight.Medium,
        letterSpacing = 0.25.sp,
        fontFamily = Inter,
        textMotion = TextMotion.Animated
    ),
    labelSmall = TextStyle(
        fontSize = 11.sp,
        lineHeight = 16.sp,
        fontWeight = FontWeight.Medium,
        letterSpacing = 0.1.sp,
        fontFamily = Inter,
        textMotion = TextMotion.Animated
    ),
    bodyLarge = TextStyle(
        fontSize = 16.sp,
        lineHeight = 24.sp,
        fontWeight = FontWeight.Normal,
        letterSpacing = 0.5.sp,
        fontFamily = Inter,
        textMotion = TextMotion.Animated
    ),
    bodyMedium = TextStyle(
        fontSize = 14.sp,
        lineHeight = 20.sp,
        fontWeight = FontWeight.Normal,
        letterSpacing = 0.25.sp,
        fontFamily = Inter,
        textMotion = TextMotion.Animated
    ),
    bodySmall = TextStyle(
        fontSize = 12.sp,
        lineHeight = 16.sp,
        fontWeight = FontWeight.Normal,
        letterSpacing = 0.2.sp,
        fontFamily = Inter,
        textMotion = TextMotion.Animated
    )
)
