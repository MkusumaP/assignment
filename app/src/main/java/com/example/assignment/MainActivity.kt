package com.example.assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_one)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val data = arrayListOf<String>()
        for (i in 1..20){
            data.add("Item $i")
        }

        val adapter = CustomAdapter(this, data)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
      //  val username = intent.extras?.getString("KEY_USERNAME")
      //  val loginTextView = findViewById<TextView>(R.id.tv_activity_view)
      //  loginTextView.text = username.toString()
    }
}