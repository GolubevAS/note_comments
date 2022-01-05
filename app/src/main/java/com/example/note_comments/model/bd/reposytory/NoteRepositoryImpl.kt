package com.example.note_comments.model.bd.reposytory

import androidx.lifecycle.LiveData
import com.example.note_comments.domain.NoteModel
import com.example.note_comments.model.bd.dao.NoteDao

// ИМЕННО ТУТ МЫ БУДЕМ :
// надо обьединить Репозиторий и ДАО
// когда мы вызываем например метод delete -  то он должен потянуть за собой
// аналогичный метод в ДАО


class NoteRepositoryImpl(private val noteDao : NoteDao) : NoteRepository {


    override val allNotes: LiveData<List<NoteModel>>
        get() = noteDao.getAllNotes()

    //вставить Заметку                            // если будет все ОК - то нам об этом скажут
    override suspend fun insertNote(noteModel: NoteModel, onSuccess: () -> Unit) {
        noteDao.insert(noteModel)
        onSuccess()
    }

    //удалить Заметку                            // если будет все ОК - то нам об этом скажут
    override suspend fun deleteNote(noteModel: NoteModel, onSuccess: () -> Unit) {
        noteDao.delete(noteModel)
        onSuccess()
    }




}