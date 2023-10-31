package com.example.vocabulario.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
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
import com.example.vocabulario.ui.GameModelView
import com.example.vocabulario.ui.components.PracticeCard
import com.example.vocabulario.ui.theme.VocabularioTheme



@Composable
fun PracticeScreen(
    gameViewModel: GameModelView = viewModel()
) {
    val gameUiState by gameViewModel.uiState.collectAsState()
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        PracticeCard(
            word = gameUiState.curentWord,
            userInput = gameViewModel.userWordInput,
            onInputChanged =  { gameViewModel.updateUserInput(it) },
            onDoneClicked = { gameViewModel.checkUserInput() }
        )
        Row (
            horizontalArrangement = Arrangement.Center
        ) {
            OutlinedButton(
                onClick = { gameViewModel.skipWord() },
                enabled = !gameUiState.isGameOver
            ) {
                Text(text = "Skip")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(
                onClick = { gameViewModel.checkUserInput() },
                enabled = !gameUiState.isGameOver
            ) {
                Text(text = "Submit")
            }
        }
    }

}

@Composable
fun ScreenTitle(title: String, modifier: Modifier = Modifier) {
    Text(
        text = title,
        modifier = modifier
            .fillMaxWidth()
            .wrapContentWidth(Alignment.CenterHorizontally)
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    VocabularioTheme {
        PracticeScreen()
    }
}