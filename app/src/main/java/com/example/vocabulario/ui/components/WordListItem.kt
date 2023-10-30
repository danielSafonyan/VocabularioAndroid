package com.example.vocabulario.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.vocabulario.R
import com.example.vocabulario.VocabularioData
import com.example.vocabulario.ui.models.PracticeWordModel
import com.example.vocabulario.ui.screens.ProfileScreen
import com.example.vocabulario.ui.theme.VocabularioTheme

@Composable
fun WordListItem(wordListItem: PracticeWordModel = VocabularioData.getData().first()) {
    Card {
        Row (
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(onClick = {  }) {
                Icon(
                    imageVector = Icons.Filled.Delete,
                    contentDescription = stringResource(R.string.delete_word_btn)
                )
            }
            Text(wordListItem.baseWord)
            IconButton(onClick = {  }) {
                Icon(
                    imageVector = Icons.Filled.Edit,
                    contentDescription = stringResource(R.string.edit_word_btn)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WordListItemPreview() {
    VocabularioTheme {
        WordListItem()
    }
}

