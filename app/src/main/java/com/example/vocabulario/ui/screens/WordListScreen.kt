package com.example.vocabulario.ui.screens

import com.example.vocabulario.VocabularioData
import com.example.vocabulario.ui.models.PracticeWordModel
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
import androidx.compose.runtime.mutableIntStateOf
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.vocabulario.ui.GameModelView
import com.example.vocabulario.ui.components.PracticeCard
import com.example.vocabulario.ui.theme.VocabularioTheme
import com.example.vocabulario.R
import com.example.vocabulario.ui.components.ScreenTitleText
import com.example.vocabulario.ui.components.WordListItem


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WordListScreen(
    modifier: Modifier = Modifier,
    wordList: List<PracticeWordModel> = VocabularioData.getData()
) {
    Column (
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically)
    ) {
        val context = LocalContext.current
        val wordNumStr = context.resources.getString(R.string.word_list_screen, wordList.size)
        ScreenTitleText(wordNumStr)
        wordList.forEach { WordListItem(it) }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun WordListScreenPreview() {
    VocabularioTheme {
        WordListScreen()
    }
}