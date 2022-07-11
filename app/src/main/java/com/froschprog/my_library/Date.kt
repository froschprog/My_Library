package com.froschprog.my_library
/*
BEWARE!!!!!
Changing library files changes the files for all applications using
My_Library (con.froschprog.my_library)
*/


import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

// outputs today's date in format jj-mm-yyyy as string
fun today(): String {
    val c = Calendar.getInstance()
    val year = c.get(Calendar.YEAR)
    val month = c.get(Calendar.MONTH) + 1
    val monthstr = if (month < 10) "0$month" else "$month"
    val day = c.get(Calendar.DAY_OF_MONTH)
    val daystr = if (day < 10) "0$day" else "$day"
    return daystr + "-" + monthstr + "-$year"
}

//format the date string for the function Date from dd-mm-yyyy to mm/dd/yyyy
/*fun formdate(s: String?): String {
    var fdb=""
    if (s!=null){
        fdb=s.substring(3..4)+"/"+s.substring(0..1)+"/"+s.substring(6)}
    return fdb
}*/

//function to check the format of the date string entered by the user. Converts some errors to the right format
fun CheckDate(s1: String): Pair<Boolean, String>{
    val daysinmonth = arrayOf(31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
    var s = s1.replace("[./]".toRegex(),"-")
    val t = s.split("-")
    if (t.size!=3) return Pair(false, "incorrect format")
    if (t[0].length == 1) s = "0$s"
    if (t[1].length == 1) s = s.substring(0,3) + "0" + s.substring(3)
    if (t[2].length == 2) s = s.substring(0,6) + "20" + s.substring(6)
    if (!s.matches("([0-9]{2})-([0-9]{2})-([0-9]{4})".toRegex()))
        return Pair(false, "incorrect format")
    if (t[1].toInt() >= 13 && t[1].toInt() != 0) return Pair(false,
        "incorrect format")
    if (t[0].toInt() > daysinmonth[t[1].toInt() - 1] && t[0].toInt() !=
        0) return Pair(false, "incorrect format")
    return Pair(true, s)
}

/*// returns the date in string format dd-mm-yyyy : fd+rec=nextdate
fun Next_Date(fd: String, rec: Int): String {
    val nextdate: String
    val fdbis=formdate(fd)
    val date1 = Date(fdbis).time
    var rec_millis: Long = rec.toLong()
    rec_millis *= 24 * 3600 * 1000
    val date2=date1+rec_millis
    nextdate = SimpleDateFormat("dd-MM-yyyy").format(date2)
    return nextdate
}*/

// returns the date in string format dd-mm-yyyy : fd+rec=nextdate
// rec is the number of days
@SuppressLint("SimpleDateFormat")
fun Next_Date(fd: String, rec: Int): String {
    val date1 = myDate(fd).ms+12*3600L*1000L // start at noon to avoid rounding issues when around midnight
    val rec_millis = rec.toLong()*24L* 3600L*1000L
    val date2=date1+rec_millis
    return SimpleDateFormat("dd-MM-yyyy").format(date2)
}

//returns time in milliseconds (since Epoch) from a date formatted dd-mm-yyyy
/*fun Datetime(s:String): Long {
    val df = SimpleDateFormat("dd-MM-yyyy")
    return df.parse(s).time
}*/

//class myDate()
@Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
@SuppressLint("SimpleDateFormat")
class myDate(s:String = today()){
    private val df = SimpleDateFormat("dd-MM-yyyy")
    val ms = df.parse(s).time
    //val y = df.parse(s).year
    val y = s.substring(6).toInt()
    val d = df.parse(s).day
    //val m = df.parse(s).month
    val m = s.substring(3,5).toInt()-1
    init {
        //d("François", " mois : " + s.substring(3,5))
        //d("François", "m : $m  y : $y")
    }
}