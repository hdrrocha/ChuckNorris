package com.example.chucknorris.view.categories.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.chucknorris.R
import kotlinx.android.synthetic.main.category_item.view.*


class CategoriesAdapter(val clickListener: ((String) -> Unit)?) : RecyclerView.Adapter<CategoriesAdapter.ViewHolder>() {
    var categories: List<String>

    init {
        categories = listOf()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(categoryItem: String, clickListener: ((String) -> Unit)?) {
            itemView.tv_title.text = categoryItem
            itemView.setOnClickListener { clickListener?.let { it1 -> it1(categoryItem) } }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.category_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = this.categories.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        (holder as ViewHolder).bind(this.categories[position], clickListener)
    }

    fun updateList() {
        notifyDataSetChanged()
    }

    fun update(categories: List<String>) {
        this.categories = emptyList()
        this.categories = categories
        updateList()
    }
}
