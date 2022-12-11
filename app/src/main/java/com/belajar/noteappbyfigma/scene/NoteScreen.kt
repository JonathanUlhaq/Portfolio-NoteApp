package com.belajar.noteappbyfigma.scene

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.material.Surface
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import com.belajar.noteappbyfigma.R
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.belajar.noteappbyfigma.components.ApplicationTopBar
import com.belajar.noteappbyfigma.components.Fab
import com.belajar.noteappbyfigma.components.NoteItem
import com.belajar.noteappbyfigma.models.NoteModel
import com.belajar.noteappbyfigma.route.ADD
import com.belajar.noteappbyfigma.route.DETAIL

@Composable
fun NoteScreen(
    noteList:List<NoteModel>,
    navController:NavController,
    valueSearch:String,
    noteVm:NoteViewModel,
    onValueChange:(String) -> Unit,
) {

    if (valueSearch.isNotEmpty()) {
        noteVm.searchNote(valueSearch)
    } else {
        noteVm.getAllData()
    }

    val hidden = remember {
        mutableStateOf(false)
    }

    val show = remember {
        mutableStateOf(false)
    }

   val current = remember {
       mutableStateOf(-1)
   }

    hidden.value = noteList.isNullOrEmpty()

    Scaffold(
        backgroundColor = Color.Black,
        topBar = {
            ApplicationTopBar(valueSearch = valueSearch) {
                onValueChange.invoke(it)
            }
        },
        floatingActionButton = {
            Fab {
                navController.navigate(ADD.route)
            }
        }
    ) {

        Column(
            Modifier
                .padding(it)
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            AnimatedVisibility(visible = hidden.value) {
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .wrapContentWidth(CenterHorizontally)
                        .wrapContentHeight(CenterVertically),
                    color = Color.Transparent
                ) {
                    Image(painter = painterResource(id = R.drawable.empty_list),
                        contentDescription = null )
                }
            }
            val context = LocalContext.current

            AnimatedVisibility(visible = !hidden.value) {
                LazyColumn(content = {
                    itemsIndexed(noteList) { index, itemList->
                        show.value = index == current.value
                        NoteItem(noteModel = itemList,
                            show = show.value,
                            onClick = {
                                navController.navigate(DETAIL.route + "/${itemList.id}")
                            },
                            onLongClick = {
                                current.value = index
                            },
                            reverseOnLongClick = {
                                current.value = -1
                            },
                            deleteClick = {
                                noteVm.deleteNote(it)
                                current.value = -1
                                Toast.makeText(context,"Note berhasil dihapus", Toast.LENGTH_SHORT).show()


                            })
                    }
                })

            }


        }

    }
}