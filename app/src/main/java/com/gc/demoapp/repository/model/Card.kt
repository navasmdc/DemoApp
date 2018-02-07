package com.gc.demoapp.repository.model

import com.gc.demoapp.utils.*

data class Card(
    var alias : String,
    var pan : String,
    var avalaible : Amount) : Product{


    override fun getName() : String = alias

    override fun setName(name : String){ alias = name}

    override fun getNumber() : String = pan

    override fun getAmount() : Double = avalaible.value

    override fun getAmountFormat() : String = avalaible.format()

    override fun isAmountNegative() : Boolean = avalaible.value.isNegative()
}