package com.belajar.noteappbyfigma.data

import androidx.room.*
import com.belajar.noteappbyfigma.models.NoteModel
import kotlinx.coroutines.flow.Flow

@Dao
interface DAO {
    @Query("SELECT * FROM note_tbl")
    fun getAllNote():Flow<List<NoteModel>>

    @Query("SELECT * FROM note_tbl WHERE id = :id")
    fun getById(id:String):Flow<List<NoteModel>>

    @Query("SELECT * FROM note_tbl WHERE note_title LIKE '%'|| :title || '%'")
    fun searchNote(title:String):Flow<List<NoteModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note:NoteModel)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateNote(note:NoteModel)

    @Delete
    suspend fun deleteNote(note:NoteModel)
}
