package com.example.vocabulario.ui.screens

import com.example.vocabulario.VocabularioData
import com.example.vocabulario.ui.models.PracticeWordModel
import androidx.compose.ui.platform.LocalContext
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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