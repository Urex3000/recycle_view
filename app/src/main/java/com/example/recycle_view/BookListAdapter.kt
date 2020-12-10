package com.example.recycle_view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.element_book.view.*

class BookListAdapter(val context: Context, val categoryItem: List<BookinfoClass>) :
    RecyclerView.Adapter<BookListAdapter.BookHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookHolder {
        return BookHolder(
            LayoutInflater.from(context).inflate(R.layout.element_book, parent, false)
        )

    }

    override fun onBindViewHolder(holder: BookHolder, position: Int) {

        val currentItem = categoryItem[position]

        holder.textView1.text = currentItem.title
        holder.textView2.text = currentItem.author


    }


    override fun getItemCount(): Int {
        return categoryItem.size
    }


    class BookHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.imageBook
        val textView1: TextView = itemView.name
        val textView2: TextView = itemView.janr
    }


}


