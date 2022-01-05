package com.example.note_comments.model.bd

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.note_comments.domain.NoteModel
import com.example.note_comments.model.bd.dao.NoteDao


// САМОЙ БАЗЫ ДАННЫХ ЕЩЕ НЕТ, ЕСТЬ ТОЛЬКО МЕТОДЫ РАБОТЫ ... РЕПО, ДАО, ИМПЛ И ТД
// ТУТ СКАЖЕМ КАК БУДЕТ СОЗДАВАТЬСЯ ИМЕННО БАЗА ДАННЫХ
// класс д.б. абстрактным


                     //на какой класс-сущность будет создаваться БД)
@Database(entities = [NoteModel::class], version = 1)
abstract class NoteDataBase : RoomDatabase() {

    abstract fun getNoteDao () : NoteDao

    companion object {
        private var dataBase : NoteDataBase ?= null

        // create dataBase
        @Synchronized
        fun getInstance (context: Context) : NoteDataBase{

            // если БД еще нет, то мы ее создадим вот ткой записью
            // и потом вернем
            return if (dataBase == null) {
                dataBase = Room.databaseBuilder(context, NoteDataBase::class.java, "db")
                    .build()
                dataBase as NoteDataBase

                // если она есть - то мы ее просто вернем
            } else {
                dataBase as NoteDataBase
            }
        }
    }
}