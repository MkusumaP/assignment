package com.example.assignment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.signature.ObjectKey
import java.util.ArrayList


class FragmentOneAdapter(
    private val context: Context,
    private val list: ArrayList<String>,
    private val listener: FragmentOneListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvItemLabel: TextView = itemView.findViewById(R.id.tv_item_label)
        var tvItemDescription: TextView = itemView.findViewById(R.id.tv_item_description)
        var imageView: ImageView = itemView.findViewById(R.id.img_view_item_icon)
        fun bind(position: Int) {
            val message = list[position]
            val imageUrl = "https://source.unsplash.com/random"
            tvItemLabel.text = message
            tvItemDescription.text = "Description of the item ${position + 1}"
            tvItemLabel.rootView.setOnClickListener {
                listener.onButtonClicked(tvItemDescription.text.toString())
            }
Glide.with(context)
    .load(imageUrl)
    .apply(RequestOptions().skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE))
    .signature(ObjectKey(position))
    .into(imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.items_list, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).bind(position)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}

// High Order Functions

interface FragmentOneListener {
    fun onButtonClicked(data: String)
}