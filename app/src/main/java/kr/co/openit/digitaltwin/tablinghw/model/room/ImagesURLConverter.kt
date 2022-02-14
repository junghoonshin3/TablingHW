package kr.co.openit.digitaltwin.tablinghw.model.room

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.TypeConverter
import java.util.stream.Collectors

// Type converters for properly Room database working

class ImagesURLConverter {
    private val delimiter = ", "

    @RequiresApi(Build.VERSION_CODES.N)
    @TypeConverter
    fun fromImages(images: List<String>): String = images.stream().collect(Collectors.joining(delimiter))

    @TypeConverter
    fun fromSavedString(data: String): List<String> = data.split(delimiter)
}