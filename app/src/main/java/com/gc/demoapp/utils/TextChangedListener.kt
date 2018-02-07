package com.gc.demoapp.utils

import android.text.*

/**
 * Created by 674756 on 07/02/2018.
 */
class TextChangedListener( var textChanged : (String) -> Unit) : TextWatcher{

    override fun afterTextChanged(p0 : Editable?){textChanged(p0!!.toString())}

    override fun beforeTextChanged(p0 : CharSequence?,
                                   p1 : Int,
                                   p2 : Int,
                                   p3 : Int
    ){}

    override fun onTextChanged(p0 : CharSequence?,
                               p1 : Int,
                               p2 : Int,
                               p3 : Int
    ) {}



}