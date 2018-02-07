package com.gc.databinidingadapters

import android.content.Context
import android.support.v7.widget.*
import android.util.AttributeSet

class DataBindingRecyclerView(context : Context, attrs : AttributeSet)
    : RecyclerView(context, attrs) {

    private enum class LayoutManager {
        VERTICAL, HORIZONTAL, GRID
    }

    var data : MutableList<*>? = null
        set(value){
            data = value
            if(value != null && itemLayout != -1)
                adapter = DataBindingRecyclerAdapter(context, data as MutableList<*>, itemLayout, onItemClickListener as OnItemClickListener<Any>?)
    }
    var itemLayout = -1
    var onItemClickListener : OnItemClickListener<*>? = null

    init {
        val styleAttributes = context.obtainStyledAttributes(attrs, R.styleable.DataBindingRecyclerView)
        if (styleAttributes != null) {
            itemLayout = styleAttributes.getResourceId(R.styleable.DataBindingRecyclerView_recyclerItemLayout, -1)
            val layoutManager = styleAttributes.getInteger(R.styleable.DataBindingRecyclerView_type, -1)
            if (layoutManager != -1) {
                when (LayoutManager.values()[layoutManager]) {
                    DataBindingRecyclerView.LayoutManager.VERTICAL -> setLayoutManager(LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false))
                    DataBindingRecyclerView.LayoutManager.HORIZONTAL -> setLayoutManager(LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false))
                    DataBindingRecyclerView.LayoutManager.GRID -> {
                        val colums = styleAttributes.getInteger(R.styleable.DataBindingRecyclerView_columns, 1)
                        setLayoutManager(GridLayoutManager(getContext(), colums))
                    }
                }
            } else setLayoutManager(LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false))
            styleAttributes.recycle()
        }
    }

//    fun setData(data : MutableList<*>) {
//        this.data = data
//        if (itemLayout != -1) {
//            adapter = DataBindingRecyclerAdapter(data, context, itemLayout, onItemClickListener)
//        }
//    }

}