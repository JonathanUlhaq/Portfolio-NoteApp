package com.belajar.noteappbyfigma.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.belajar.noteappbyfigma.models.NoteModel
import com.belajar.noteappbyfigma.utils.IdConverter

@Database(entities = [NoteModel::class], version = 1)
@TypeConverters(IdConverter::class)
abstract class NoteDatabase: RoomDatabase() {
    abstract fun dao():DAO
}