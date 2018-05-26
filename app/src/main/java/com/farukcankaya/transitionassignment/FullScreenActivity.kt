package com.farukcankaya.transitionassignment

import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

/**
 * Created by farukcankaya on 25/05/2018.
 */
class FullScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_screen)
        supportPostponeEnterTransition()

        val extras = intent.extras
        val item = extras.getString(MainActivity.EXTRA_ITEM)

        val imageView = findViewById(R.id.full_screen_image) as ImageView

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val imageTransitionName = extras.getString(MainActivity.EXTRA_IMAGE_TRANSITION_NAME)
            imageView.transitionName = imageTransitionName
        }

        Picasso.with(this)
                .load("https://picsum.photos/600/600/?image=" + item)
                .noFade()
                .into(imageView, object : Callback {
                    override fun onSuccess() {
                        supportStartPostponedEnterTransition()
                    }

                    override fun onError() {
                        supportStartPostponedEnterTransition()
                    }
                })

        imageView.setOnClickListener { super.onBackPressed() }
    }
}

