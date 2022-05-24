package com.example.adedas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import java.util.regex.Pattern

class LoginActivity : AppCompatActivity() {
    lateinit var email: EditText
    lateinit var password : EditText
    val EMAIL : Pattern = Pattern.compile(
        "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val button : Button = findViewById(R.id.login_btn)

        email = findViewById(R.id.email)
        password = findViewById(R.id.password)

        button.setOnClickListener {
            sighIn()

        }


    }
    fun sighIn() {
        if(email.text.toString().isNotEmpty() && password.text.toString().isNotEmpty()
            && EMAIL.matcher(email.text.toString()).matches()) {
            val intent = Intent(this@LoginActivity, ScrollActivity::class.java)
            startActivity(intent)
            finish()
        }
        else {
            alert("Ошибка ввода пароля или email'a")
        }
    }

    fun alert(message : String) {
        val alert = AlertDialog.Builder(this)
            .setTitle("Error")
            .setMessage(message)
            .setPositiveButton("Ok", null)
            .create()
            .show()

    }
}