package com.gc.navigationinjector

import android.content.*
import android.databinding.ViewDataBinding
import android.view.View

/**
 * Created by 674756 on 06/02/2018.
 */
interface ViewManager {

    var binding : ViewDataBinding

    fun getContext() : Context

    fun getString(idResource : Int) : String

    fun getView() : View

    fun showProgressDialog(message : String? = null)

    fun hideProgressDialog() : Unit

    fun showDialog(message : String,
                   title : String? = null,
                   buttonAcceptText : String? = null,
                   buttonAcceptListener : DialogInterface.OnClickListener? = null,
                   buttonCancelText : String? = null,
                   buttonCancelListener : DialogInterface.OnClickListener? = null)

    fun hideDialog() : Unit
}