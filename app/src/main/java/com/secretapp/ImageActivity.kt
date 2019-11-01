package com.secretapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_image.*
import kotlin.random.Random

class ImageActivity : AppCompatActivity() {

    companion object {
        const val GIFT = "Gift"
        fun callingIntent(context: Context, giftItem: GiftItem): Intent {
            val intent = Intent(context, ImageActivity::class.java)
            JsonHelper.putObjectInIntent(intent, GIFT, giftItem, giftItem::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_image)

        val giftItem = JsonHelper<GiftItem>().getObjectFromIntent(intent, GIFT, GiftItem::class.java)

        image.setImageResource(giftItem.photo)

        val listVariants = mutableListOf(
            "Еще рано!",
            "Ну-ка не подглядывай!",
            "Я тебе ата-та!",
            "Еще раз раньше времени залезешь и подарка не будет!\n\n\n Ну ладно, будет"
        )
        if (giftItem.photo == R.drawable.no) {
            imageText.visibility = VISIBLE
            imageText.text = listVariants[Random.nextInt(4)]
        } else {
            imageText.visibility = VISIBLE
            imageText.text = giftItem.description
            imageText.setTextColor(resources.getColor(R.color.colorPinkStrong))
        }
    }
}