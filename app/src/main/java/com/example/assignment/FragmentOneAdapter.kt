package com.example.assignment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList


class FragmentOneAdapter(
    private val context: Context,
    private val list: ArrayList<String>,
    private val listener: FragmentOneListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvItemLabel: TextView = itemView.findViewById(R.id.tv_item_label)
        var tvItemDescription: TextView = itemView.findViewById(R.id.tv_item_description)
        var viewDataButton: Button = itemView.findViewById(R.id.btn_view_data)
        fun bind(position: Int) {
            val message = list[position]
            tvItemLabel.text = message
            tvItemDescription.text = "Description of the item ${position + 1}"
            viewDataButton.setOnClickListener {
                listener.onButtonClicked(tvItemDescription.text.toString())
            }
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

interface FragmentOneListener {
    fun onButtonClicked(data: String)
}