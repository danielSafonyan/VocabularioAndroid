package com.example.vocabulario.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vocabulario.Greeting
import com.example.vocabulario.R
import com.example.vocabulario.ui.theme.VocabularioTheme
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.input.ImeAction
import com.example.vocabulario.ui.models.PracticeWordModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PracticeCard(
    word: PracticeWordModel,
    userInput: String,
    onInputChanged: (String) -> Unit,
    onDoneClicked: () -> Unit
) {

    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier
            .padding(16.dp)
            .wrapContentHeight()
    ) {
        Column (
            modifier = Modifier.padding(16.dp)
        )
        {
            val styledDefString = buildAnnotatedString {
                val defStringPrefix = stringResource(id = R.string.word_definition) + ": "
                append(defStringPrefix)
                addStyle(SpanStyle(fontWeight = FontWeight.Bold), 0, defStringPrefix.length)
                append(word.definition)
                toAnnotatedString()
            }

            val styledExampleString = buildAnnotatedString {
                val defStringPrefix = stringResource(id = R.string.word_example) + ": "
                append(defStringPrefix)
                addStyle(SpanStyle(fontWeight = FontWeight.Bold), 0, defStringPrefix.length)
                append(word.example)
                toAnnotatedString()
            }
            Text(styledDefString)
            Text(styledExampleString)
            Text(
                text = word.baseWord,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.CenterHorizontally)
                    .padding(bottom = 16.dp)
            )
            OutlinedTextField(
                value = userInput,
                singleLine = true,
                shape = MaterialTheme.shapes.large,
                modifier = Modifier.fillMaxWidth(),
                onValueChange = { onInputChanged(it) },
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = { onDoneClicked() }
                )
            )
        }
    }
}
//
//@Preview(
//    showBackground = true,
//    showSystemUi = true
//)
//@Composable
//fun PracticeCardPreview() {
//    VocabularioTheme {
//        PracticeCard()
//    }
//}