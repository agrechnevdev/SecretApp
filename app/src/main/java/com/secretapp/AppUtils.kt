package com.secretapp

import java.text.SimpleDateFormat
import java.util.*

object AppUtils {

    fun accessDate(dateStr: String): Boolean {
        val dateFormat = SimpleDateFormat("HH:mm dd.MM.yyyy", Locale.getDefault())
        val date = dateFormat.parse(dateStr)
        return date.before(Date())
    }

    fun timeBefore(dateStr: String): String {
        val dateFormat = SimpleDateFormat("HH:mm dd.MM.yyyy", Locale.getDefault())
        val date = dateFormat.parse(dateStr)
        val calendarNow = Calendar.getInstance()
        val calendar = Calendar.getInstance()
        calendar.time = date
        val diffInMillis = calendar.timeInMillis - calendarNow.timeInMillis
        val calDiff = Calendar.getInstance()
        calDiff.time = Date(diffInMillis)
        val addHours = (calDiff.get(Calendar.DAY_OF_YEAR)-1)*24
        println(addHours)
        return (calDiff.get(Calendar.HOUR_OF_DAY)+ addHours ).toString() + " ч. "  + calDiff.get(Calendar.MINUTE).toString() + " мин. "
    }
}