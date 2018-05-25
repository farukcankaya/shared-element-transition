package com.farukcankaya.transitionassignment

import android.support.v4.view.ViewCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.squareup.picasso.Picasso
import java.util.ArrayList

/**
 * Created by farukcankaya on 25/05/2018.
 */
class Adapter(private val items: ArrayList<String>, private val itemClickListener: ItemClickListener) : RecyclerView.Adapter<Adapter.ImageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ImageViewHolder {
        return ImageViewHolder(LayoutInflater.from(parent?.getContext())
                .inflate(R.layout.adapter_item, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val item: String = items.get(position)

        Picasso.with(holder.itemView.context)
                .load("https://picsum.photos/240/240/?image="+item)
                .into(holder.imageView)

        ViewCompat.setTransitionName(holder.imageView, item)

        holder.itemView.setOnClickListener { itemClickListener.onItemClick(holder.getAdapterPosition(), item, holder.imageView) }
    }


    class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val imageView: ImageView

        init {
            imageView = itemView.findViewById<View>(R.id.image) as ImageView
        }
    }

    interface ItemClickListener {
        fun onItemClick(pos: Int, item: String, shareImageView: ImageView)
    }
}