package com.froschprog.my_library.transitions

import com.froschprog.my_library.R

/*
BEWARE!!!!!
Changing library files changes the files for all applications using
My_Library (con.froschprog.my_library)
*/
class Fade {
    fun In(): Array<Int>{
        return arrayOf(R.anim.fade_in, R.anim.fade_out)
    }

    fun InUp(): Array<Int>{
        return arrayOf(R.anim.fade_in_up, R.anim.fade_out_up)
    }

    fun InDown(): Array<Int>{
        return arrayOf(R.anim.fade_in_down, R.anim.fade_out_down)
    }

    fun InLeft(): Array<Int>{
        return arrayOf(R.anim.fade_in_left, R.anim.fade_out_right)
    }

    fun InRight(): Array<Int>{
        return arrayOf(R.anim.fade_in_right, R.anim.fade_out_left)
    }
}