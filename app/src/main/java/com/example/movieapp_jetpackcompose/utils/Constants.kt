package com.example.movieapp_jetpackcompose.utils

import android.content.Context
import android.view.Gravity
import android.widget.Toast

object Constants {

    fun showToast(
        context: Context,
        msg: String
    ) {
        val toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT)
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0)
        toast.show()
    }

}