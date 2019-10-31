package com.secretapp

import java.text.SimpleDateFormat
import java.util.*

enum class Gifts(var timeAccess: String, var timeAccessStr: String, var description: String, var photo: Int) {

    FLOWERS("17:00 01.11.2019", "1 ноября в 17:00","Цветы", 0),
    RAFAELLO("21:00 01.11.2019", "1 ноября в 21:00","Рафаэлло", 0),
    SERTIFICAT("00:00 02.11.2019", "2 ноября в 00:00", "Сертификат", 0);

    companion object {
        var dateFormat = SimpleDateFormat("HH:mm dd.MM.yyyy", Locale.getDefault())
        fun getTime(time: String): Date? {
            return dateFormat.parse(time)
        }

        fun toList(): List<GiftItem> {
            val list = mutableListOf<GiftItem>()
            for (gift in values()) {
                list.add(GiftItem(gift.timeAccess,gift.timeAccessStr, gift.description, gift.photo))
            }
            return list
        }
    }


}