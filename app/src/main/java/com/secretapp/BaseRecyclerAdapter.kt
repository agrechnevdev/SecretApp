package com.secretapp

import android.content.Context
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerAdapter<T, VH : RecyclerView.ViewHolder> : RecyclerView.Adapter<VH>() {

    var TAG: String = javaClass.simpleName
    protected open var context: Context? = null
    protected open lateinit var layoutInflater: LayoutInflater
    open var items: MutableList<T> = ArrayList()

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
        layoutInflater = context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        super.onDetachedFromRecyclerView(recyclerView)
        context = null
    }

    open fun notifyItems(items: List<T>) {
        this.items = items.toMutableList()
        notifyDataSetChanged()
    }

    open fun notifyItems() {
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun removeItem(item : T){
        items.remove(item)
        notifyItems()
    }
}