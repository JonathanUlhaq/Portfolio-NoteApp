package com.belajar.noteappbyfigma.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Save
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AddTopBar(
    onBack:() -> Unit,
    onSave:() -> Unit
) {
    TopAppBar(
        backgroundColor = Color.Transparent,
        elevation = 0.dp
    ) {
        TopIcon(icon = Icons.Default.ArrowBack) {
            onBack.invoke()
        }
        Spacer(modifier = Modifier.weight(1F))

        TopIcon(icon = Icons.Default.Save) {
            onSave.invoke()
        }
    }
}