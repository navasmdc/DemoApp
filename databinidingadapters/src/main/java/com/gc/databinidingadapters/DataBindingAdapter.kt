package com.gc.databinidingadapters

import android.content.Context
import android.databinding.*
import android.view.*
import android.widget.BaseAdapter

/**
 * Simple adaptar that implements databinding to bind every item from list with his item view
 */
class DataBindingAdapter<T>(
        var context : Context,
        var list : MutableList<*>,
        var itemLayout : Int,
        var itemClickListener : OnItemClickListener<T>? = null
        ) : BaseAdapter() {

    override fun getView(position : Int,
                         recyclerView : View?,
                         p2 : ViewGroup?
    ) : View {
        var view = recyclerView
        val binding : ViewDataBinding
        if(view != null) binding = view.tag as ViewDataBinding
        else{
            binding = DataBindingUtil.inflate(LayoutInflater.from(context), itemLayout, null, false)
            view = binding.root
            view.tag = binding
        }
        binding.setVariable(BR.viewModel, getItem(position))
        if(itemClickListener != null)
            view?.setOnClickListener { itemClickListener?.onItemClick(getItem(position)) }
        return view!!
    }

    override fun getItem(position : Int) : T = list[position] as T

    override fun getItemId(position : Int) : Long = position.toLong()

    override fun getCount() : Int = list.size
}