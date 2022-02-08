package com.example.assignment

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegistrationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registration)

        val registerButton: Button = findViewById(R.id.bt_register_button)
        registerButton.setOnClickListener {
            Toast.makeText(this, "Successfully registered", Toast.LENGTH_SHORT).show()
            startActivity(LoginActivity::class.java)
        }

    }
}