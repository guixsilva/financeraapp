package com.example.financera.viewmodel

import android.annotation.SuppressLint
import android.content.Context
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.io.File
import java.text.DecimalFormat

class ScanningViewModel : ViewModel() {

    private val _databaseFiles = MutableStateFlow<List<File>>(emptyList()) // lista de arquivos
    val databaseFiles: StateFlow<List<File>> = _databaseFiles  //imutável e público para as outras interfaces

    @SuppressLint("SdCardPath")
    fun scanDatabases(context: Context) {
        val directory = context.filesDir.parentFile // OBTEM DIRETÓRIO DE ARQUIVOS LOCAIS DO APP
        val databasesDir = File(directory, "databases") // entra na pasta databases (criada pelo sql)

        val files = databasesDir.listFiles { file ->
            file.isFile
        }?.toList() ?: emptyList()

        _databaseFiles.value = files
    }

    fun databaseFileSize(size: Long): String {
        if (size <= 0) {
            return "0 B"
        }
        val units = arrayOf("B", "KB", "MB", "GB", "TB") // FORMATA TAMANHO
        val digitGroups = (Math.log10(size.toDouble()) / Math.log10(1024.0)).toInt()
        return DecimalFormat("#,##0.#").format(size / Math.pow(1024.0, digitGroups.toDouble())) + " " + units[digitGroups]
    }

}