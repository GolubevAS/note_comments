package com.example.note_comments.domain

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


// @Entity  мы понимаем, что из этого класса мы будем делать таблицу
@Entity(tableName = "note_table")
class NoteModel  (

//  КЛАСС - СУЩНОСТЬ
    @PrimaryKey (autoGenerate = true)  // авто-создание ключей для таблицы
    var id : Int = 0,

    @ColumnInfo // это просто столбцы
    var title : String = "",
    @ColumnInfo // это просто столбцы
    var description : String = ""
// БОЛЬШЕ НИЧЕГО НЕ БУДЕТ, РАБОТАЕМ ТОЛЬКО С ЭТИМ
        ) : Serializable  // для того чтобы можно было поместить обьект в bundle