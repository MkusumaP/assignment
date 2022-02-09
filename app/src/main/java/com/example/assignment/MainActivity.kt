package com.example.assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val username = intent.extras?.getString("KEY_USERNAME")
        val loginTextView = findViewById<TextView>(R.id.tv_activity_view)
        loginTextView.text = username.toString()
    }
}