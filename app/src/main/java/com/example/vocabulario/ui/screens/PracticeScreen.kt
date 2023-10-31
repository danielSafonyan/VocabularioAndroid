package com.example.vocabulario.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.vocabulario.ui.PracticeModelView
import com.example.vocabulario.ui.components.PracticeCard
import com.example.vocabulario.ui.theme.VocabularioTheme

@Composable
fun PracticeScreen(
    practiceViewModel: PracticeModelView = viewModel()
) {
    val gameUiState by practiceViewModel.uiState.collectAsState()
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        PracticeCard(
            word = gameUiState.currentWord,
            userInput = practiceViewModel.userWordInput,
            onInputChanged =  { practiceViewModel.updateUserInput(it) },
            onDoneClicked = { practiceViewModel.checkUserInput() }
        )
        Row (
            horizontalArrangement = Arrangement.Center
        ) {
            OutlinedButton(
                onClick = { practiceViewModel.skipWord() },
                enabled = !gameUiState.isGameOver
            ) {
                Text(text = "Skip")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(
                onClick = { practiceViewModel.checkUserInput() },
                enabled = !gameUiState.isGameOver
            ) {
                Text(text = "Submit")
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    VocabularioTheme {
        PracticeScreen()
    }
}