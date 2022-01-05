package com.example.note_comments.view.screens.addnote

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.note_comments.APP
import com.example.note_comments.R
import com.example.note_comments.databinding.FragmentAddNoteBinding
import com.example.note_comments.domain.NoteModel


class AddNoteFragment : Fragment() {

    lateinit var binding: FragmentAddNoteBinding

    //инициализируем все что будет на экране фрагмента
    private fun init() {

        // обращаемся к нашей ВиьМодели
        val viewModel =  ViewModelProvider(this).get(AddNoteViewModel::class.java)
        //теперь мы можем обратиться к ВьюМодели по нажатии на кнопку

        //кнопка 1
         binding.butBack.setOnClickListener{
             APP.navController.navigate(R.id.action_addNoteFragment_to_startFragment)
         }

        //кнопка 2
        binding.butAddNote.setOnClickListener{
            val title = binding.edTitle.text.toString()
            val description = binding.edDese.text.toString()
            viewModel.insert(NoteModel(title = title, description = description)){}
            APP.navController.navigate(R.id.action_addNoteFragment_to_startFragment)
        }



    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddNoteBinding.inflate(layoutInflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()

    }



}