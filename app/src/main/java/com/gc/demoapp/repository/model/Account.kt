package com.gc.demoapp.repository.model

import com.gc.demoapp.utils.*

data class Account(
        var alias : String,
        var IBAN : String,
        var balance : Amount) : Product{

    override fun getName() : String = alias

    override fun setName(name : String){ alias = name}

    override fun getNumber() : String = IBAN

    override fun getAmount() : Double = balance.value

    override fun getAmountFormat() : String = balance.format()

    override fun isAmountNegative() : Boolean = balance.value.isNegative()
}