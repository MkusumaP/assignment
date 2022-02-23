package com.example.assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentTransaction
import com.example.assignment.ui.main.Fragment
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.create

class FragmentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_activity)

val quotesApi = RetrofitHelper.getInstance().create(QuotesApi::class.java)

        GlobalScope.launch {
            val response = quotesApi.getQuotes()
            val quotesList = response.body()
            if (quotesList != null)
                Log.d("kusuma: ", quotesList.toString())
        }

        if (savedInstanceState == null) {
            val tag = "Fragment1"
            val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.container, Fragment1.newInstance(), tag)
                transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                transaction.addToBackStack(tag)
                transaction.commit()
        }
    }


    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 1){
            supportFragmentManager.popBackStackImmediate()
        }
        else super.onBackPressed()
    }
}