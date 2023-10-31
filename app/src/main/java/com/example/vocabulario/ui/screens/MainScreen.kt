package com.example.vocabulario.ui.screens

import androidx.compose.ui.platform.LocalContext
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.vocabulario.ui.PracticeModelView
import com.example.vocabulario.ui.components.PracticeCard
import com.example.vocabulario.ui.theme.VocabularioTheme
import com.example.vocabulario.R
import com.example.vocabulario.ui.MainModelView
import com.example.vocabulario.ui.components.ScreenTitleText


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    userNickName: String = "Daniel",
    addNewWordInput: String = "",
    changedAddNewWordInput: (String) -> Unit = {},
    onPracticeClick: () -> Unit = {},
    onWordListClick: () -> Unit = {},
    onAddWordSubmit: () -> Unit = {}
) {
    val context = LocalContext.current
    val helloString = context.resources.getString(R.string.main_screen, userNickName)
    Column (
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically)
    ) {
        ScreenTitleText(helloString)
        OutlinedTextField(
            value = addNewWordInput,
            placeholder = { Text(text = stringResource(id = R.string.add_word_input_placeholder)) },
            singleLine = true,
            shape = MaterialTheme.shapes.large,
            modifier = Modifier.fillMaxWidth(),
            onValueChange = changedAddNewWordInput,
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = { onAddWordSubmit() }
            )
        )
        Column {
            Button(
                onClick = onPracticeClick,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = stringResource(id = R.string.practice_btn))
            }
            FilledTonalButton(
                onClick = onWordListClick,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = stringResource(id = R.string.word_list_btn))
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun Preview() {
    VocabularioTheme {
        MainScreen()
    }
}