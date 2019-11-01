package com.secretapp

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.gift_item.view.*
import kotlin.random.Random

class GiftRecyclerAdapter(var onClickGift: OnClickGift) :
    BaseRecyclerAdapter<GiftItem, GiftRecyclerAdapter.ViewHolder>() {

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var timeTitle: TextView = v.gift_time_title
        var timeCounter: TextView = v.gift_time_counter
        var main: LinearLayout = v.gift_main_layout
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.gift_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.main.setOnClickListener { onClickGift.onClick(item) }
        holder.timeTitle.text = item.timeAccessStr

        val r = Random.nextInt(256)
        val g = Random.nextInt(256)
        val b = Random.nextInt(256)
        val color = Color.argb(60, r, g, b)
        holder.main.setBackgroundColor(color)

        if(AppUtils.accessDate(item.timeAccess)){
            holder.timeCounter.visibility = GONE
        } else {
            holder.timeCounter.visibility = VISIBLE
            holder.timeCounter.text = AppUtils.timeBefore(item.timeAccess)
        }

    }
}