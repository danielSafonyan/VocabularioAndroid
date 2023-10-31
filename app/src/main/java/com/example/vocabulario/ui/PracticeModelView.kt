package com.example.vocabulario.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.vocabulario.VocabularioData
import com.example.vocabulario.ui.models.PracticeWordModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class PracticeModelView: ViewModel() {
    private val _uiState = MutableStateFlow(PracticeUiState())
    val uiState: StateFlow<PracticeUiState> = _uiState.asStateFlow()
    var userWordInput by mutableStateOf("")
        private set

    private val allWords = VocabularioData.getData()

    private val usedWords = mutableSetOf<PracticeWordModel>()

    init {
        resetGame()
    }

    fun updateUserInput(userInput: String) { userWordInput = userInput }

    fun setNextWord(){
        usedWords.add(uiState.value.currentWord)
        if (usedWords.size == allWords.size) {
            _uiState.update {
                it.copy(
                    isGameOver = true
                )
            }
        } else {
            _uiState.update {
                val newIndex = it.currentWordIndex + 1
                val newWord = allWords[newIndex]
                it.copy(
                    currentWordIndex = newIndex,
                    currentWord = newWord
                )
            }
        }

    }

    fun checkUserInput() {
        println("uiState.value.currentWord.baseWord: ${uiState.value.currentWord.baseWord}")
        println("userWordInput: ${userWordInput}")
        if (uiState.value.currentWord.baseWord == userWordInput) {
            updateUserInput("")
            setNextWord()
        }
    }

    fun skipWord() {
        setNextWord()
        updateUserInput("")
    }

    fun resetGame() {
        usedWords.clear()
        _uiState.value = PracticeUiState(currentWord = allWords[0])
        updateUserInput("")
    }
}