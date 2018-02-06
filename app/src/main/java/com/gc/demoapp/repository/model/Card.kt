package com.gc.demoapp.repository.model

import com.gc.demoapp.utils.format

data class Card(
    var alias : String,
    var pan : String,
    var avalaible : Amount) : Product{


    override fun getName() : String = alias

    override fun getNumber() : String = pan

    override fun getAmount() : String = avalaible.format()
}