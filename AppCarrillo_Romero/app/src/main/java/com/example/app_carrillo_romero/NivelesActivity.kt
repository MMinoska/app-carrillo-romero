package com.example.app_carrillo_romero

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.app_carrillo_romero.databinding.ActivityNivelesBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class NivelesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNivelesBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_niveles)
        auth = Firebase.auth

        val lead: ImageView = findViewById(R.id.leadButton) as ImageView
        lead.setOnClickListener {
            val intent = Intent(this, LeaderboardActivity::class.java)
            this.startActivity(intent)
        }

        val profile: ImageView = findViewById(R.id.profileButton) as ImageView
        profile.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            this.startActivity(intent)
        }

        val atras: ImageView = findViewById(R.id.atrasButton) as ImageView
        atras.setOnClickListener {
            auth.signOut()
            val intent = Intent(this, SignInActivity::class.java)
            this.startActivity(intent)
        }

    }


}