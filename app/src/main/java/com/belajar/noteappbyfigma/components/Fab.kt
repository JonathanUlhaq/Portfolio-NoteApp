package com.belajar.noteappbyfigma.components

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Fab(
    onClick:() -> Unit
) {
    FloatingActionButton(onClick = { onClick.invoke() },
        shape = CircleShape,
        backgroundColor = Color.DarkGray
    ) {
           Icon(imageVector = Icons.Default.Add,
               contentDescription = "Add",
                tint = Color.White)
    }
}