package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ToDoAdapter(
    private val items: MutableList<ToDoItem>,
    private val onItemCheckChanged: (Int, Boolean) -> Unit
) : RecyclerView.Adapter<ToDoAdapter.ToDoViewHolder>() {

    inner class ToDoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.title)
        val checkBox: CheckBox = view.findViewById(R.id.checkBox)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.todo_item, parent, false)
        return ToDoViewHolder(view)
    }

    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
        val item = items[position]
        holder.title.text = item.title
        holder.checkBox.isChecked = item.isChecked

        holder.checkBox.setOnCheckedChangeListener { _, isChecked ->
            onItemCheckChanged(position, isChecked)
        }
    }

    override fun getItemCount() = items.size
}
