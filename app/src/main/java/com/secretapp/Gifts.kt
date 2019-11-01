package com.secretapp

import java.text.SimpleDateFormat
import java.util.*

enum class Gifts(var timeAccess: String, var timeAccessStr: String, var description: String, var photo: Int) {

    KISS("17:30 01.11.2019", "1 ноября в 17:30", "Воздушный поцелуйчик (позже будет не воздушный)", R.drawable.kiss),
    RAFAELLO("20:30 01.11.2019", "1 ноября в 18:30", "Дома уже ждет сладенькое", R.drawable.raf),
    TICKET("21:05 01.11.2019", "1 ноября в 21:00", "Твоя любимая игрушка", R.drawable.ticket),
    SERTIFICAT("21:05 01.11.2019", "1 ноября в 21:05", "Для тебя (подарок от Гречневых)", R.drawable.sertificat);

    companion object {

        fun getTime(time: String): Date? {
            val dateFormat = SimpleDateFormat("HH:mm dd.MM.yyyy", Locale.getDefault())
            return dateFormat.parse(time)
        }

        fun toList(): List<GiftItem> {
            val list = mutableListOf<GiftItem>()
            for (gift in values()) {
                list.add(GiftItem(gift.timeAccess, gift.timeAccessStr, gift.description, gift.photo))
            }
            return list
        }
    }
}