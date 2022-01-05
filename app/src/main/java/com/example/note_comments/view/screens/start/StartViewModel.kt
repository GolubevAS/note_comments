package com.example.note_comments.view.screens.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.note_comments.REPOSITORY
import com.example.note_comments.domain.NoteModel
import com.example.note_comments.model.bd.NoteDataBase
import com.example.note_comments.model.bd.reposytory.NoteRepositoryImpl


// ТУТ МЫ СВЯЗЫВАЕМСЯ С БД И ПРОСИМ ЕЕ ПОКАЗЫВАТЬ НАМ СПИСОК ЗАМЕТОК


class StartViewModel(application: Application) : AndroidViewModel(application)  {

    val context = application

    // метод который инициализирует нашу БД
    fun  initDataBase () {
        val daoNote = NoteDataBase.getInstance(context).getNoteDao()
        REPOSITORY = NoteRepositoryImpl(daoNote)

    }

    //  покажем все заметки
    fun getAllNotes () : LiveData<List<NoteModel>> {
        return REPOSITORY.allNotes
    }

}