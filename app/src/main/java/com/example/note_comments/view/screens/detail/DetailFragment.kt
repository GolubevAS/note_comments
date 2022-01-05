package com.example.note_comments.view.screens.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.note_comments.APP
import com.example.note_comments.R
import com.example.note_comments.databinding.FragmentDetailBinding
import com.example.note_comments.domain.NoteModel


// ТУТ МЫ БУДЕМ ПРИНИМАТЬ НАШ ОБЬЕКТ  Bundle И СМОТРЕТЬ НА НЕГО
//



class DetailFragment : Fragment() {

   lateinit var binding : FragmentDetailBinding
   lateinit var currentNote : NoteModel

   // инициализируем все что будет на Детальном экране
   fun init() {
       //обращаемся к ВьюМодели
        val viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
       //теперь мы можем обратиться к ВьюМодели по нажатии на кнопку


       //детейл-фрагмент                        //класс-сущность
       binding.tvTitleDetail.text = currentNote.title
       binding.tvDescDetail.text = currentNote.description


       binding.butBack.setOnClickListener{
           APP.navController.navigate(R.id.action_detailFragment_to_startFragment)
       }

       binding.butDelete.setOnClickListener{
           viewModel.delete(currentNote){}
           APP.navController.navigate(R.id.action_detailFragment_to_startFragment)
       }

   }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(layoutInflater, container, false)

        // вытаскиваем из Bundle нашу заметку на которую мы тыкнули
        currentNote = arguments?.getSerializable("NOTE") as NoteModel
        //
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }
}