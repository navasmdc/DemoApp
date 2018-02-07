package com.gc.navigationinjector

import android.annotation.SuppressLint
import android.app.*
import android.content.*
import android.support.v7.app.AlertDialog
import android.view.*
import android.widget.FrameLayout
import android.widget.ProgressBar

@SuppressLint("StaticFieldLeak")
object DialogManager {

    const val PROGRESS_ID = 123

    var currentDialog : Dialog? = null
    var currentProgressDialog : ProgressBar? = null

    fun showProgress(activity : Activity
    ) {
        var rootView  = activity.findViewById(android.R.id.content) as FrameLayout
        currentProgressDialog = rootView.findViewById(PROGRESS_ID)
        if(currentProgressDialog != null) currentProgressDialog?.visibility = View.VISIBLE
        else{
            currentProgressDialog = ProgressBar(activity, null, android.R.attr.progressBarStyleHorizontal)
            currentProgressDialog?.max = 100
            currentProgressDialog?.isIndeterminate = true
            currentProgressDialog?.id = PROGRESS_ID
            rootView.addView(currentProgressDialog)
            currentProgressDialog?.y = 20f
        }
        activity.window.setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);


    }

    fun hideProgressDialog(activity : Activity) {
        currentProgressDialog?.visibility = View.GONE
        activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
    }

    fun showDialog(activity : Activity,
                   message : String,
                   title : String? = null,
                   buttonAcceptText : String? = null,
                   buttonAcceptListener : DialogInterface.OnClickListener? = null,
                   buttonCancelText : String? = null,
                   buttonCancelListener : DialogInterface.OnClickListener? = null
    ) {
        hideDialog()
        var builder = AlertDialog.Builder(activity)
                .setMessage(message)
                .setTitle(title ?: "")
                .setPositiveButton(
                        buttonAcceptText ?: activity.getString(R.string.accept), {_, _ ->
                            hideDialog()
                            buttonAcceptListener?.onClick(null,0)
                        }
                )
        if(buttonCancelText != null || buttonCancelText != null)
            builder.setNegativeButton(
                    buttonAcceptText ?: activity.getString(R.string.cancel), {_, _ ->
                        hideDialog()
                        buttonCancelListener?.onClick(null,0)
                    }
            )
        currentDialog = builder.create()
        currentDialog?.show()

    }

    fun hideDialog() = currentDialog?.hide()

}