package com.example.note_comments.model.bd.reposytory

import androidx.lifecycle.LiveData
import com.example.note_comments.domain.NoteModel


//ПРОСТО БУДЕТ ПЕРЕЧИСЛЯТЬ МЕТОДЫ РАБОТЫ С БД

interface NoteRepository {

    //все заметки будут передаваться через ЛайфДата (allNotes это переменная именно для ЛайфДата)
    val allNotes : LiveData<List<NoteModel>>

    //вставить Заметку                            // если будет все ОК - то нам об этом скажут
    suspend fun insertNote (noteModel: NoteModel, onSuccess :() -> Unit)
    suspend fun  deleteNote (noteModel: NoteModel, onSuccess :() -> Unit)


}

// надо обьединить Репозиторий и ДАО
// когда мы вызываем например метод delete -  то он должен потянуть за собой
// аналогичный метод в ДАО