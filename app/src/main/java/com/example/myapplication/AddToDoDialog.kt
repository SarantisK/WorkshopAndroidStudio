package com.example.myapplication

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.myapplication.R

class AddToDoDialog(
    context: Context,
    private val onAddItem: (ToDoItem) -> Unit
) : Dialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_add_todo)

        val editText: EditText = findViewById(R.id.editText)
        val addButton: Button = findViewById(R.id.addButton)

        addButton.setOnClickListener {
            val title = editText.text.toString().trim()
            if (title.isNotEmpty()) {
                onAddItem(ToDoItem(title))
                dismiss()
            }
        }
    }
}
