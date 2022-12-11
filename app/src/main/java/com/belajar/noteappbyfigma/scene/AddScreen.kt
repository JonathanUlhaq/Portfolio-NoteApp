package com.belajar.noteappbyfigma.scene

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.belajar.noteappbyfigma.components.AddTopBar
import com.belajar.noteappbyfigma.components.InputText
import com.belajar.noteappbyfigma.models.NoteModel

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun AddScreen(
    navController: NavController,
    addNote:(NoteModel) -> Unit
) {

    val title = remember {
        mutableStateOf("")
    }

    val desc = remember {
        mutableStateOf("")
    }

    val keyboardController = LocalSoftwareKeyboardController.current
    val context = LocalContext.current

    Scaffold(
        backgroundColor = Color.Black,
        topBar = {
            AddTopBar(onBack = {
                navController.popBackStack()
            }) {
                if (title.value.isNotEmpty() && desc.value.isNotEmpty())
                    addNote.invoke(NoteModel(desc = desc.value, title = title.value))
                    Toast.makeText(context,"Note berhasil ditambah",Toast.LENGTH_SHORT).show()
                    navController.popBackStack()
            }
        }
    ) {
        Column(
            Modifier
                .padding(it)
                .padding(14.dp)) {

            InputText(inputText = title,
                label = "Title",
                isSingleLine = false,
                style = MaterialTheme.typography.h4,
                fontWeight = FontWeight.Bold) {
                if (title.value.isNotEmpty())
                keyboardController?.hide()
            }

            InputText(inputText = desc,
                label = "Content",
                isSingleLine = false,
                style = MaterialTheme.typography.body1,
                fontWeight = FontWeight.Normal) {
                if (desc.value.isNotEmpty())
                    keyboardController?.hide()
            }

        }
    }
}