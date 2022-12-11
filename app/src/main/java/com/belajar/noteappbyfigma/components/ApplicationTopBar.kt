package com.belajar.noteappbyfigma.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun ApplicationTopBar(
    valueSearch:String,
    onValueChange:(String) -> Unit
) {
    TopAppBar(
        backgroundColor = Color.Black
    ) {

        val show = remember {
            mutableStateOf(false)
        }

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            AnimatedVisibility(visible = show.value) {
                Surface(
                    modifier = Modifier.padding(start = 12.dp, end = 12.dp),
                    color = Color.Transparent) {
                    TextField(value = valueSearch,
                        onValueChange = onValueChange,
                        singleLine = true,
                        modifier = Modifier
                            .fillMaxWidth(),
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = Color.DarkGray,
                            cursorColor = Color.White,
                            textColor = Color.White,
                            focusedIndicatorColor = Color.Black

                            ),
                        trailingIcon = {
                            IconButton(onClick = { show.value = false }) {
                                Icon(imageVector = Icons.Default.Close,
                                    contentDescription = "Icon",
                                    tint = Color.White)
                            }
                        },
                        shape = RoundedCornerShape(14.dp)
                    )
                }
            }

            AnimatedVisibility(visible = !show.value) {

             Row(
                 modifier = Modifier.padding(start = 12.dp, end = 12.dp)
             ) {
                 Text(text = "Notes",
                     style = MaterialTheme.typography.h6,
                     color = Color.White)
                 Spacer(modifier = Modifier.weight(1F))
                 TopIcon(Icons.Default.Search) {
                     show.value = true
                 }
             }
            }

        }
    }
}
