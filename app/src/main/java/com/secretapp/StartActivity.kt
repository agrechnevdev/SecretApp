package com.secretapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.secretapp.AppUtils.accessDate
import kotlinx.android.synthetic.main.activity_start.*

class StartActivity : AppCompatActivity(), OnClickGift{


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_start)

        val llm = LinearLayoutManager(this)
        gift_recycler.layoutManager = llm

        val adapter = GiftRecyclerAdapter(this)
        adapter.notifyItems(Gifts.toList())
        gift_recycler.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        gift_recycler?.adapter?.let { it.notifyDataSetChanged() }
    }
    override fun onClick(giftItem: GiftItem) {

        if(accessDate(giftItem.timeAccess)) {
            startActivity(ImageActivity.callingIntent(this, giftItem))
        } else {
            startActivity(ImageActivity.callingIntent(this, GiftItem("", "", "", R.drawable.no)))
        }
    }
}