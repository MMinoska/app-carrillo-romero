package com.example.app_carrillo_romero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class NivelUnoActivity : AppCompatActivity() {
    var sustantivo: List<String> = listOf("lunes")
    var prep: List<String> = listOf("lunes")
    var adjet: List<String> = listOf("lunes")
    var verbo: List<String> = listOf("lunes")
    var prep_art_sus: List<String> = listOf("lunes")
    var prep_sus: List<String> = listOf("lunes")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nivel_uno)
    }
}