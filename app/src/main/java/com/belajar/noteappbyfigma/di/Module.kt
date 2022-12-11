package com.belajar.noteappbyfigma.di

import android.content.Context
import androidx.room.Room
import com.belajar.noteappbyfigma.data.DAO
import com.belajar.noteappbyfigma.data.NoteDatabase
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@dagger.Module
class Module {

    @Singleton
    @Provides
    fun DAOProvides(data:NoteDatabase):DAO = data.dao()

    @Singleton
    @Provides
    fun databaseProvide(@ApplicationContext context:Context):NoteDatabase =
        Room.databaseBuilder(
            context,
            NoteDatabase::class.java,
            "note_db"
        )
            .build()
}