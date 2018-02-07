package com.gc.demoapp.utils

import com.gc.demoapp.repository.model.Amount
import java.text.*
import java.util.*
import java.util.regex.Pattern

fun Amount.format() : String{
    val formatter = (NumberFormat.getInstance(Locale.getDefault())as DecimalFormat)
    formatter.applyPattern("##0.00")
    val number = formatter.format(value)
    when(currency){
        "EUR" -> return "$number €"
        "USD" -> return "$number $"
        else -> return number
    }
}

fun Double.isNegative() : Boolean = this < 0

fun String.isUserValid() : Boolean = Pattern.compile("[0-9]{8}[A-Z]{1}").matcher(this).matches()

fun String.isPasswordValid() : Boolean = Pattern.compile("[0-9]{4}").matcher(this).matches()