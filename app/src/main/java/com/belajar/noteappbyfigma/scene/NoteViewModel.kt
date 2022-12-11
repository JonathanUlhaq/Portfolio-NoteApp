package com.belajar.noteappbyfigma.scene

import android.provider.ContactsContract.CommonDataKinds.Note
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.belajar.noteappbyfigma.models.NoteModel
import com.belajar.noteappbyfigma.repositories.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(private val repo:NoteRepository):ViewModel() {
    private val _noteList = MutableStateFlow<List<NoteModel>>(emptyList())
    val noteList = _noteList.asStateFlow()

        fun getAllData() =
       viewModelScope.launch(Dispatchers.IO) {
           repo.getAllNote().distinctUntilChanged().collect {
                   list ->
               if (!list.isNullOrEmpty())
                   _noteList.value = list
           }
       }

    fun getById(id:String) =
        viewModelScope.launch(Dispatchers.IO) {
            repo.getById(id).distinctUntilChanged().collect {
                    list ->
                if (!list.isNullOrEmpty())
                    _noteList.value = list
            }
        }

    fun searchNote(search:String) =
        viewModelScope.launch(Dispatchers.IO) {
            repo.searchNote(search).distinctUntilChanged().collect { searches ->
                if (!searches.isNullOrEmpty())
                    _noteList.value = searches
            }
        }

    fun insertNote(note:NoteModel) =
        viewModelScope.launch {
            repo.insertNote(note)
        }

    fun updateNote(note:NoteModel) =
        viewModelScope.launch {
            repo.updateNote(note)
        }

    fun deleteNote(note:NoteModel) =
        viewModelScope.launch {
            repo.deleteNote(note)
        }
}