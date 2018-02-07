package com.gc.demoapp.repository.model

/**
 * Created by 674756 on 06/02/2018.
 */
interface Product {

    fun getName() : String

    fun setName(name : String)

    fun getNumber() : String

    fun getAmount() : Double

    fun getAmountFormat() : String

    fun isAmountNegative() : Boolean

}