package com.gc.demoapp.repository.model

import com.gc.demoapp.utils.format

data class Account(
        var alias : String,
        var IBAN : String,
        var balance : Amount) : Product{

    override fun getName() : String = alias

    override fun getNumber() : String = IBAN

    override fun getAmount() : String = balance.format()
}