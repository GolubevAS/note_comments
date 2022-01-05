package com.example.note_comments.view.screens.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.note_comments.REPOSITORY
import com.example.note_comments.domain.NoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


// ТУТ ИМЕННО КОНКРЕТНЫЕ МЕТОДЫ КОТОРЫЕ БУДУТ ИСПОЛЬЗОВАТЬСЯ ВО ФРАГМЕНТЕ
// НАПРИМЕР, ЧТО БУДЕТ ПРИ НАЖАТИИ НА КНОПКУ



class DetailViewModel : ViewModel()  {

    //  удалим заметку (сам метод, реализация)
    // а вызыват его будет в Детейл - Фрагменте
    fun delete (noteModel: NoteModel, onSuccess : () -> Unit) =

                        // запуск со-программы (замена многопоточки) - это каррутины
                                          // IO -  это значит "на фоне"
        viewModelScope.launch (Dispatchers.IO){
            REPOSITORY.deleteNote(noteModel) {
                onSuccess()
            }
        }


}