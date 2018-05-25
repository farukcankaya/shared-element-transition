package com.farukcankaya.transitionassignment

import android.content.Context
import java.util.*

/**
 * Created by farukcankaya on 25/05/2018.
 */
object Utils {

    fun generateRandomPhotos(context: Context): ArrayList<String> {
        val items = ArrayList<String>()

        for (i in 1..100) {
            items.add("" +  (Math.random() * 100.0).toInt())
        }

        return items
    }
}
