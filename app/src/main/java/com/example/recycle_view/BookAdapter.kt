package com.example.recycle_view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class BookAdapter(
    private val context: Context,

    private val mainItemClass: List<ItemClass>
) :
    RecyclerView.Adapter<BookAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return BookAdapter.Holder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.element_item,
                parent, false
            )
        )


    }

    override fun onBindViewHolder(holder: Holder, position: Int) {


        holder.categoryTitle.text = mainItemClass[position].text1
        setBookListRecycler(holder.bookListRecycler, mainItemClass[position].categoryItem)

    }

    override fun getItemCount(): Int {
        return mainItemClass.size
    }


    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var categoryTitle: TextView
        var bookListRecycler: RecyclerView

        init {
            categoryTitle = itemView.findViewById(R.id.Callname)
            bookListRecycler = itemView.findViewById(R.id.BookList)
        }


    }

    private fun setBookListRecycler(recyclerView: RecyclerView, categoryItem: List<BookinfoClass>) {

        val itemRecyclerAdapter = BookListAdapter(context, categoryItem)
        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        recyclerView.adapter = itemRecyclerAdapter
    }

}