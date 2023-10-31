package com.example.vocabulario.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.ui.Modifier
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vocabulario.R
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.vocabulario.ui.GameModelView
import com.example.vocabulario.ui.components.PracticeCard
import com.example.vocabulario.ui.theme.VocabularioTheme



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddWordScreen(
    addBaseWord: String = "Luz",
    addWordToUserList: () -> Unit = {}
) {
    var baseWordInput by remember { mutableStateOf(addBaseWord) }
    var definitionInput by remember { mutableStateOf("") }
    var exampleInput by remember { mutableStateOf("") }
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ElevatedCard (
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),
            modifier = Modifier
        ) {
            TextField(
                value = baseWordInput,
                onValueChange = { baseWordInput = it },
                placeholder = { Text(stringResource(id = R.string.word_base_word)) }
            )
            TextField(
                value = definitionInput,
                onValueChange = { definitionInput = it },
                placeholder = { Text(stringResource(id = R.string.word_definition)) }
            )
            TextField(value = exampleInput, onValueChange = { exampleInput = it },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent
                ),
                placeholder = { Text(stringResource(id = R.string.word_example)) }
            )
        }
        Spacer(modifier = Modifier.height(36.dp))
        FloatingActionButton(
            onClick = { addWordToUserList() },
        ) {
            Icon(Icons.Filled.Add, "Floating action button.")
        }
    }
}
@Preview(showBackground = true)
@Composable
fun AddWordScreenPreview() {
    VocabularioTheme {
        AddWordScreen()
    }
}