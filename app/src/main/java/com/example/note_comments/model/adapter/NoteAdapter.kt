package com.example.note_comments.model.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.note_comments.R
import com.example.note_comments.domain.NoteModel
import com.example.note_comments.view.screens.start.StartFragment
import kotlinx.android.synthetic.main.item_layout.view.*


// ЭТО СВЯЗЬ МЕЖДУ НАШИМИ ДАННЫМИ И ЛИСТОМ
// ОН УСТАНАВЛИВАЕТ ПОЛЕ title В ПОЛЕ title
// ОН УСТАНАВЛИВАЕТ ПОЛЕ description В ПОЛЕ description

class NoteAdapter : RecyclerView.Adapter<NoteAdapter.NoteListViewHolder>() {

    // мы работаем с Листом и будем получать в этот адаптер именно Лист
    // это локалья переменная только для адаптера и вьюхолдера
    var listNote = emptyList<NoteModel>()



    // НУЖЕН ДЛЯ ДОСТУПА К ПЕРЕМЕННЫМ ПО ID
    // название viewHolder'a - это куда адаптер будет передавать данные
    class NoteListViewHolder(view: View) : RecyclerView.ViewHolder(view)

    // мы говориим, что использовать надо именно карточку (item_layout) для вставки в RecView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteListViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return NoteListViewHolder(view)
    }

    // мы в нашу переменную (title в карточке) воткнем настоящий title из нашего Листа
    //который будет приходить
    // холдер знает все о нашем списке
    override fun onBindViewHolder(holder: NoteListViewHolder, position: Int) {
        holder.itemView.item_title.text = listNote[position].title


    }

    // он вернет то количество заметок, которое вообще есть
    override fun getItemCount(): Int {
       return listNote.size
    }

    // будет отправлять Лист, который похож на Лист<NoteModel>
    @SuppressLint("NotifyDataSetChanged")
    fun setList (list: List<NoteModel>) {
        listNote = list
        notifyDataSetChanged() //как что то изменится то наш Лист сразу обновится
    }


    // эти два метода необходимы для проваливания в заметку
    override fun onViewAttachedToWindow(holder: NoteListViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.itemView.setOnClickListener{
            StartFragment.clickNote(listNote[holder.adapterPosition])
        }
    }

    override fun onViewDetachedFromWindow(holder: NoteListViewHolder) {
       holder.itemView.setOnClickListener(null)
    }
}