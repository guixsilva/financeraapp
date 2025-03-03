package com.example.financera.model

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context, databaseName: String, databaseVersion: Int) :
    SQLiteOpenHelper(context, databaseName, null, databaseVersion) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(
            """
            CREATE TABLE transactions (
                id_transaction INTEGER PRIMARY KEY,
                transaction_amount REAL,
                transaction_title TEXT,
                transaction_description TEXT,
                transaction_date DATE,
                id_expense INTEGER,
                id_income INTEGER,
                id_reserve INTEGER,
                FOREIGN KEY (id_expense) REFERENCES expenses (id_expense),
                FOREIGN KEY (id_income) REFERENCES incomes (id_income),
                FOREIGN KEY (id_reserve) REFERENCES reserves (id_reserve)
            );
            """
        )

        db.execSQL(
            """
            CREATE TABLE expenses (
                id_expense INTEGER PRIMARY KEY,
                id_installment INTEGER,
                recurring_expense INTEGER,
                FOREIGN KEY (id_installment) REFERENCES installments (id_installment)
            );
            """
        )

        db.execSQL(
            """
            CREATE TABLE incomes (
                id_income INTEGER PRIMARY KEY,
                recurring_income INTEGER
            );
            """
        )

        db.execSQL(
            """
            CREATE TABLE tags (
                id_tag INTEGER PRIMARY KEY,
                tag_name TEXT UNIQUE,
                tag_type TEXT
            );
            """
        )

        db.execSQL(
            """
            CREATE TABLE reserves (
                id_reserve INTEGER PRIMARY KEY,
                reserve_title TEXT UNIQUE,
                reserve_description TEXT,
                current_reserve_amount REAL,
                max_reserve_amount REAL
            );
            """
        )

        db.execSQL(
            """
            CREATE TABLE installments (
                id_installment INTEGER PRIMARY KEY,
                installment_number INTEGER,
                installment_amount REAL,
                installment_due_date DATE
            );
            """
        )

        db.execSQL(
            """
            CREATE TABLE tags_transactions (
                id_transaction INTEGER,
                id_tag INTEGER,
                PRIMARY KEY (id_tag, id_transaction),
                FOREIGN KEY (id_tag) REFERENCES tags (id_tag),
                FOREIGN KEY (id_transaction) REFERENCES transactions (id_transaction)
            );
            """
        )
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        if (oldVersion < newVersion) {
        }
    }
}