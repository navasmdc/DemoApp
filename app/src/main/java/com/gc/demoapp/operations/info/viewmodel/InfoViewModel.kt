package com.gc.demoapp.operations.info.viewmodel

import android.view.View
import com.gc.demoapp.R
import com.gc.navigationinjector.BaseViewModel
import android.support.v4.content.ContextCompat.startActivity
import android.content.Intent
import android.net.Uri


class InfoViewModel : BaseViewModel() {


    override fun getLayout() : Int = R.layout.info_state


    fun openLink(v : View?){
        viewManager.launchActivity(Intent(Intent.ACTION_VIEW, Uri.parse(viewManager.getString(R.string.tv_github_url))))
    }





}