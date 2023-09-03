package com.stslex93.notes.feature.edit.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.stslex93.notes.core.ui.theme.AppDimens
import com.stslex93.notes.feature.edit.R
import com.stslex93.notes.feature.edit.ui.store.EditStore

@Composable
fun EditScreen(
    state: EditStore.State,
    onInputTitle: (String) -> Unit,
    onInputContent: (String) -> Unit,
    onBackButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .systemBarsPadding()
    ) {
        TextField(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .padding(horizontal = AppDimens.Padding.normal),
            value = state.note.title,
            onValueChange = onInputTitle,
            singleLine = true,
            label = {
                Text(text = stringResource(id = R.string.title_hint))
            }
        )

        TextField(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(AppDimens.Padding.normal),
            value = state.note.content,
            onValueChange = onInputContent,
            label = {
                Text(text = stringResource(id = R.string.content_hint))
            }
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = stringResource(id = R.string.label_edit) + ":${state.timeString}",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onBackground,
            )

            FloatingActionButton(
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(AppDimens.Padding.normal),
                onClick = onBackButtonClicked
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "return"
                )
            }
        }
    }
}