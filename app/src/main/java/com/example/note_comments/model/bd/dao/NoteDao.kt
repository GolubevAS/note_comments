package com.example.note_comments.model.bd.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.note_comments.domain.NoteModel



// ТУТ МЫ УКАЗЫВАЕМ КАКОЙ МЕТОД БУДЕТ ЧТО ВЫПОЛНЯТЬ
// тут важны именно аннотации, реализации еще нет
// ЭТО ОПИСАНИЕ ИМЕННО ДЛЯ ROOMa, а Репозиторий - это описание для нас - людей

@Dao
interface NoteDao  {

                        //   что делать если в момент вставки что то произойдет
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert (noteModel: NoteModel) // сам room пока еще не знает что это такое будет
                                              // мы должны сказать ему что это и ставим @Insert

    @Delete
    suspend fun delete (noteModel: NoteModel)


    // показать все SQL
    @Query("SELECT * FROM note_table")
    fun getAllNotes () : LiveData<List<NoteModel>>

}

// надо обьединить Репозиторий и ДАО
// когда мы вызываем например метод delete -  то он должен потянуть за собой
// аналогичный метод в ДАО