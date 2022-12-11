package com.belajar.noteappbyfigma

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.belajar.noteappbyfigma.navigation.NavigationAdapter
import com.belajar.noteappbyfigma.scene.NoteScreen
import com.belajar.noteappbyfigma.scene.NoteViewModel
import com.belajar.noteappbyfigma.ui.theme.NoteAppbyFigmaTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoteApps {

                val noteVm:NoteViewModel by viewModels()
                val state = noteVm.noteList.collectAsState().value
                val detailState = noteVm.noteList.collectAsState().value


                val search = remember {
                    mutableStateOf("")
                }





                Log.d("SEARCH PESAN: ",search.value)

                NavigationAdapter(
                    noteList = state,
                    addNote = {
                        noteVm.insertNote(it)

                    },
                    onValueChange = {search.value = it},
                    valueSearch = search.value,
                    noteDetail = detailState,
                    viewModel = noteVm,
                    updateNote = {
                        noteVm.updateNote(it)
                    },
                    homeVM = noteVm
                )
            }
        }
    }
}

@Composable
fun NoteApps(content:@Composable()()->Unit) {
    NoteAppbyFigmaTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            content.invoke()
        }
    }
}