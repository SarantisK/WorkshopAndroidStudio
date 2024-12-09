package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private val items = mutableListOf<ToDoItem>()
    private lateinit var adapter: ToDoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val fab: FloatingActionButton = findViewById(R.id.fab)

        adapter = ToDoAdapter(items) { position, isChecked ->
            items[position].isChecked = isChecked
            Toast.makeText(this, "${items[position].title} is ${if (isChecked) "done" else "not done"}", Toast.LENGTH_SHORT).show()
        }

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        fab.setOnClickListener {
            showAddToDoDialog()
        }
    }

    private fun showAddToDoDialog() {
        val dialog = AddToDoDialog(this) { newItem ->
            items.add(newItem)
            adapter.notifyItemInserted(items.size - 1)
        }
        dialog.show()
    }
}
