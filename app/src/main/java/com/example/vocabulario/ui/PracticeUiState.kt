package com.example.vocabulario.ui

import com.example.vocabulario.ui.models.PracticeWordModel

data class PracticeUiState(
    val currentWordIndex: Int = 0,
    val currentWord: PracticeWordModel = PracticeWordModel("","",""),
    val score: Int = 0,
    val isGuessedWordWrong: Boolean = false,
    val isGameOver: Boolean = false
)