package com.farukcankaya.transitionassignment

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.view.ViewCompat
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.ImageView

class MainActivity : AppCompatActivity(), Adapter.ItemClickListener {

    val EXTRA_ITEM = "image_url"
    val EXTRA_IMAGE_TRANSITION_NAME = "image_transition_name"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val adapter = Adapter(Utils.generateRandomPhotos(this), this)
        val recyclerView = findViewById(R.id.recycler_view) as RecyclerView
        val gridLayoutManager = GridLayoutManager(this, 3)
        recyclerView.layoutManager = gridLayoutManager
        recyclerView.adapter = adapter
    }

    override fun onItemClick(pos: Int, item: String, shareImageView: ImageView) {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra(EXTRA_ITEM, item)
        intent.putExtra(EXTRA_IMAGE_TRANSITION_NAME, ViewCompat.getTransitionName(shareImageView))

        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                this,
                shareImageView,
                ViewCompat.getTransitionName(shareImageView))
        startActivity(intent, options.toBundle())
    }
}
