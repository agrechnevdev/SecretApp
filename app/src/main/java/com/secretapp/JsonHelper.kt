package com.secretapp

import android.content.Intent
import android.os.Bundle

import com.google.gson.Gson

/**
 * Created by grechnev-av on 28.09.2017.
 */

class JsonHelper<T> {


    fun getObjectFromIntent(intent: Intent, key: String, tClass: Class<T>): T {
        val data = intent.extras?.getString(key)
        return Gson().fromJson(data, tClass)
    }


    fun getObjectFromBundle(bundle: Bundle?, key: String, tClass: Class<T>): T {
        val data = bundle?.getString(key)
        return Gson().fromJson(data, tClass)
    }

    companion object {

        /**
         * Кладем объект в интент
         *
         * @param intent    интент
         * @param key       ключ в Bundle
         * @param object    объект
         * @param className класс объекта
         */
        fun putObjectInIntent(intent: Intent, key: String, `object`: Any, className: Class<*>) {
            val bundle = intent.extras ?: Bundle()
            val json = Gson().toJson(className.cast(`object`))
            bundle.putString(key, json)
            intent.putExtras(bundle)
        }

        /**
         * Кладем объект в Bundle
         */
        fun putObjectInBundle(bundle: Bundle, key: String, `object`: Any, className: Class<*>) {
            val json = Gson().toJson(className.cast(`object`))
            bundle.putString(key, json)
        }
    }
}
