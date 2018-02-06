package com.gc.demoapp.utils

import com.gc.demoapp.repository.model.Amount
import java.text.*
import java.util.*

/**
 * Created by 674756 on 06/02/2018.
 */
fun Amount.format() : String{
    val formatter = (NumberFormat.getInstance(Locale.getDefault())as DecimalFormat)
    formatter.applyPattern("###.00")
    val number = formatter.format(value)
    when(currency){
        "EUR" -> return "$number €"
        "USD" -> return "$number $"
        else -> return number
    }
}