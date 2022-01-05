package com.example.note_comments.view.screens.addnote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.note_comments.REPOSITORY
import com.example.note_comments.domain.NoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


// ТУТ ИМЕННО КОНКРЕТНЫЕ МЕТОДЫ КОТОРЫЕ БУДУТ ИСПОЛЬЗОВАТЬСЯ ВО ФРАГМЕНТЕ
// НАПРИМЕР, ЧТО БУДЕТ ПРИ НАЖАТИИ НА КНОПКУ


class AddNoteViewModel : ViewModel() {


    // добавим заметку (сам метод, реализация)
    // а вызыват его будет во Фрагменте
    fun insert (noteModel: NoteModel, onSuccess : () -> Unit) =
                       // запуск со-программы (замена многопоточки) - это каррутины
                                         // IO -  это значит "на фоне"
        viewModelScope.launch (Dispatchers.IO){
            REPOSITORY.insertNote(noteModel) {
                onSuccess()
            }
        }

}