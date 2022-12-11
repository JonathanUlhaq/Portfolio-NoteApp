package com.belajar.noteappbyfigma.repositories

import com.belajar.noteappbyfigma.data.DAO
import com.belajar.noteappbyfigma.models.NoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn

import javax.inject.Inject

class NoteRepository @Inject constructor(val dao:DAO) {
    fun getAllNote(): Flow<List<NoteModel>> = dao.getAllNote().flowOn(Dispatchers.IO).conflate()
    fun getById(id:String): Flow<List<NoteModel>> = dao.getById(id).flowOn(Dispatchers.IO).conflate()
    fun searchNote(desc:String):Flow<List<NoteModel>> = dao.searchNote(desc).flowOn(Dispatchers.IO).conflate()
    suspend fun insertNote(note:NoteModel) = dao.insertNote(note)
    suspend fun deleteNote(note:NoteModel) = dao.deleteNote(note)
    suspend fun updateNote(note:NoteModel) = dao.updateNote(note)

}