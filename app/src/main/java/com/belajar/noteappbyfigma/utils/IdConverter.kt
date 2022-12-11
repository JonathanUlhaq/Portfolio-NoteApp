package com.belajar.noteappbyfigma.utils

import androidx.room.TypeConverter
import java.util.UUID

class IdConverter {

    @TypeConverter
    fun fromUUID(uuid: UUID):String = uuid.toString()

    @TypeConverter
    fun fromString(string:String) = UUID.fromString(string)
}