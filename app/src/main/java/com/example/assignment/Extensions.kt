package com.example.assignment

import android.app.Activity
import android.content.Intent
import android.os.Bundle

class Extensions {
}

fun Activity.startActivity(activityClass: Class<*>, bundle: Bundle? = null){
    val intent = Intent(this, activityClass)
    bundle?.let { innerBundle ->
        intent.putExtras(innerBundle)
    }
    startActivity(intent)
}