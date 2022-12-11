package com.belajar.noteappbyfigma.models

import androidx.compose.ui.graphics.Color
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.belajar.noteappbyfigma.R
import java.util.UUID

val color = listOf<Int>(
    R.color.color_1,
    R.color.color_2,
    R.color.color_3,
    R.color.color_4,
    R.color.color_5,
    R.color.color_6,
)

fun colorList():List<Int> = color

@Entity(tableName = "note_tbl")
data class NoteModel(
    @PrimaryKey
    val id:UUID = UUID.randomUUID(),
    @ColumnInfo(name = "note_color")
    val color:Int = colorList().random(),
    @ColumnInfo(name = "note_title")
    val title:String,
    @ColumnInfo(name = "note_desc")
    val desc:String
)
