package com.gc.databinidingadapters

import android.content.Context
import android.util.AttributeSet
import android.widget.ListView

class DataBindingListView(context : Context, attrs : AttributeSet)
    : ListView(context, attrs) {

    var data : MutableList<*>? = null
        set(value){
            field = value
            if(value != null && itemLayout != -1)
                adapter = DataBindingAdapter(context, data as MutableList<*>, itemLayout, onItemClickListener as com.gc.databinidingadapters.OnItemClickListener<Any>?)
        }
    var itemLayout : Int = -1

    var onItemClickListener : com.gc.databinidingadapters.OnItemClickListener<*>? = null

    init {
        val styleAttributes = context.obtainStyledAttributes(attrs, R.styleable.DataBindingListView)
        if (styleAttributes != null) {
            itemLayout = styleAttributes.getResourceId(R.styleable.DataBindingListView_itemLayout, -1)
            styleAttributes.recycle()
        }
    }


}