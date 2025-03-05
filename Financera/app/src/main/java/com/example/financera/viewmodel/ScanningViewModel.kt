package com.example.financera.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.io.File
import java.text.DecimalFormat

class ScanningViewModel:ViewModel(){

    private val _databases = MutableStateFlow<List<File>>(emptyList())
    val databaseFiles: StateFlow<List<File>> = _databases

    fun scanDatabases(context: Context){
        val diretory = context.filesDir.parentFile
        val databasesDir = File(diretory, "databases")

        val files = databasesDir.listFiles{
            file -> file.isFile && file.name.endsWith(".db")
        }?.toList() ?: emptyList()

        _databases.value = files
    }

    fun databaseFileSize(size: Long):String{
        val units = arrayOf("B", "KB", "MB", "GB", "TB")
        val digitGroups = (Math.log10(size.toDouble()) / Math.log10(1024.0)).toInt()
        if(size <= 0){
            return "0 B"
        }

        return DecimalFormat("#,##0.#").format(size / Math.pow(1024.0, digitGroups.toDouble())) + " " + units[digitGroups]
    }
}