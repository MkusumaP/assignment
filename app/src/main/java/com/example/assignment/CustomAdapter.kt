package com.example.assignment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList


class CustomAdapter(private val context: Context, private val list: ArrayList<String>) :RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvItemLabel: TextView = itemView.findViewById(R.id.tv_item_label)
        fun bind(position: Int) {
            tvItemLabel.text = list[position]
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