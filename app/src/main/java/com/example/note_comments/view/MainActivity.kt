package com.example.note_comments.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.note_comments.APP
import com.example.note_comments.R
import com.example.note_comments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // крепим Биндинг
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // крепим константу
        APP = this
        // крепим Навигатор
        navController = Navigation.findNavController(this, R.id.nav_fragment)

    }
}