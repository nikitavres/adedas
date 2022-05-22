package com.example.adedas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class HelloActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello)
        val button: Button = findViewById(R.id.btn_login)
        button.setOnClickListener {
            val intent = Intent(this@HelloActivity, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

}


