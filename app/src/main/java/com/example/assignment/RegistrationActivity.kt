package com.example.assignment

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegistrationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registration)

        val registerButton: Button = findViewById(R.id.bt_register_button)
        registerButton.setOnClickListener {
            val etFirstName = findViewById<EditText>(R.id.et_firstname).text
            if (etFirstName == null || etFirstName.toString().isEmpty()) {
                Toast.makeText(this, "Please enter the first name!", Toast.LENGTH_SHORT).show()
            } else {
                val bundle = Bundle()
                bundle.putString("KEY_FIRST_NAME", etFirstName.toString())
                Toast.makeText(this, "Successfully registered", Toast.LENGTH_SHORT).show()
                startActivity(LoginActivity::class.java, bundle)
            }

        }

    }
}