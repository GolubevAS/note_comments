package com.example.note_comments.view.screens.start

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.note_comments.APP
import com.example.note_comments.R
import com.example.note_comments.databinding.FragmentStartBinding
import com.example.note_comments.domain.NoteModel
import com.example.note_comments.model.adapter.NoteAdapter


//ТУТ БУДЕТ НАШ ГЛАВНЫЙ ЭКРАН СО СПИСКОМ ЗАМЕТОК



class StartFragment : Fragment() {

    lateinit var binding: FragmentStartBinding
    lateinit var recyclerView: RecyclerView
   lateinit var adapter: NoteAdapter


    //  связываем наш Фрагмент и ВьюМодель
    fun init () {

        // обращаемся к ВьюМодели
        val viewModel = ViewModelProvider(this).get(StartViewModel::class.java)
        //теперь мы можем обратиться к ВьюМодели по нажатии на кнопку

        viewModel.initDataBase()
        recyclerView = binding.rvNotes
        adapter = NoteAdapter()
        recyclerView.adapter = adapter

        // из вьюмодели просим показыват нам список наших заметок
        viewModel.getAllNotes().observe(viewLifecycleOwner, {listNote ->
            adapter.setList(listNote.asReversed())
        })


        // слушатель на кнопку
        binding.butNext.setOnClickListener {
            APP.navController.navigate(R.id.action_startFragment_to_addNoteFragment)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStartBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }


    // как мы будем кликать по Заметке
    companion object {

        fun clickNote(noteModel: NoteModel) {

            // bundle - позволяет передавать нам целый объект
            // не по кусочкам (отдельно title, отдельно description), а весь целиком
            val bundle = Bundle()

            // мы в bundle засунем нашу Заметку с ключем "NOTE"
            bundle.putSerializable("NOTE", noteModel)
            APP.navController.navigate(R.id.action_startFragment_to_detailFragment, bundle)
        }
    }

}