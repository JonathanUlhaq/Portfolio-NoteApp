package com.belajar.noteappbyfigma.components

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Box
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.belajar.noteappbyfigma.R
import com.belajar.noteappbyfigma.models.NoteModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NoteItem(
    noteModel: NoteModel,
    show:Boolean,
    onLongClick:() -> Unit,
    reverseOnLongClick:()->Unit,
    deleteClick:(NoteModel) -> Unit,
    onClick:() -> Unit
) {
    val color = listOf(
        R.color.color_1,
        R.color.color_2,
        R.color.color_3,
        R.color.color_4,
        R.color.color_5,
        R.color.color_6,
    )

Box {

    AnimatedVisibility(visible = show,
        enter = expandHorizontally(tween(700), expandFrom = Alignment.Start),
        exit = shrinkHorizontally(tween(700), shrinkTowards = Alignment.Start)
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
                .combinedClickable(
                    onLongClick = {
                        reverseOnLongClick.invoke()
                    },
                    onClick = {
                        deleteClick.invoke(noteModel)
                    }
                ),
            shape = RoundedCornerShape(20.dp),
            color = Color.Red
        ) {
            Surface(
                Modifier.padding(14.dp),
                color  = Color.Transparent
            ) {
                Text(text = "DELETE",
                    style = MaterialTheme.typography.h6,
                    color = Color.White)
            }
        }
    }

    AnimatedVisibility(visible = !show,
        enter = expandHorizontally(tween(700), expandFrom = Alignment.Start),
        exit = shrinkHorizontally(tween(700), shrinkTowards = Alignment.Start)
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
                .combinedClickable(
                    onLongClick = {
                        onLongClick.invoke()
                    },
                    onClick = {
                        onClick.invoke()
                    }
                ),
            shape = RoundedCornerShape(20.dp),
            color = Color.White
        ) {
            Surface(
                Modifier.padding(14.dp),
                color  = Color.Transparent
            ) {
                Text(text = noteModel.title,
                    style = MaterialTheme.typography.h6)
            }
        }
    }
}
}