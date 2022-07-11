package com.froschprog.my_library.transitions
/*
BEWARE!!!!!
Changing library files changes the files for all applications using
My_Library (con.froschprog.my_library)
*/
import android.app.Activity
import android.content.Context


class Transitions(private val context: Context) {

    fun setAnimation(effects: Array<Int>) {
        (context as Activity).overridePendingTransition(effects[0], effects[1])
    }
}
