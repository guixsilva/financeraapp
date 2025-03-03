package com.example.financera.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.financera.model.DatabaseHelper

class NewDatabaseViewModel : ViewModel() {

    fun createDatabase(context: Context, databaseName: String) {
        val dbHelper = DatabaseHelper(context, databaseName, 1)
        dbHelper.writableDatabase
    }
}