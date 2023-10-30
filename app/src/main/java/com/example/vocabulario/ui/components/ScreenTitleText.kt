package com.example.vocabulario.ui.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight

@Composable
fun ScreenTitleText(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.displayMedium,
        fontWeight = FontWeight.Bold
    )
}