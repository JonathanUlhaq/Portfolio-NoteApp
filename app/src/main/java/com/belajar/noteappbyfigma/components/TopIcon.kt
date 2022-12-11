package com.belajar.noteappbyfigma.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp


@Composable
fun TopIcon(
    icon: ImageVector,
    onClick:() ->Unit
) {
    IconButton(onClick = { onClick.invoke() }) {
        Surface(
            color = Color.DarkGray,
            shape = RoundedCornerShape(5.dp)
        ) {
            Icon(imageVector = icon,
                contentDescription = "Search Icon",
                modifier = Modifier
                    .padding(4.dp),
                tint = Color.White)
        }
    }
}