package com.example.assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import com.example.assignment.ui.main.Fragment

class FragmentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_activity)
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