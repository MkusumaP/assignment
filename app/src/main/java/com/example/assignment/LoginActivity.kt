package com.example.assignment

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        val loginButton: Button = findViewById(R.id.login_button)

        val firstNameText = intent.extras?.getString("KEY_FIRST_NAME")
        val userNameEditText: EditText = findViewById(R.id.username)
        userNameEditText.setText(firstNameText)

        loginButton.setOnClickListener {
            val username = findViewById<EditText>(R.id.username).text
            val password = findViewById<EditText>(R.id.et_password).text
            if (username == null || username.toString()
                    .isEmpty() || password == null || password.toString().isEmpty()
            ) {
                Toast.makeText(this, "please fill the username and password!", Toast.LENGTH_SHORT)
                    .show()
            } else {
                val bundle = Bundle()
                bundle.putString("KEY_USERNAME", username.toString())
                startActivity(MainActivity::class.java, bundle)
            }
        }
        val registrationButton: Button = findViewById(R.id.register_button)
        registrationButton.setOnClickListener {
            startActivity(RegistrationActivity::class.java)
        }
    }
}