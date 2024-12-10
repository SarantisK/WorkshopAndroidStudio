package com.example.myapplication

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

// Dialog, der es erlaubt, eine neue Aufgabe hinzuzufügen
class AddToDoDialog(
    context: Context,
    private val onAddItem: (ToDoItem) -> Unit // Callback, das aufgerufen wird, wenn eine Aufgabe hinzugefügt wird
) : Dialog(context) {

    //Wie in der Main Acitivity, wird aufgerufen, wenn dieser Dialog gestartet/geöffnet wird
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_add_todo) // Verknüpft den Dialog mit seinem Layout

        val editText: EditText = findViewById(R.id.editText) // Eingabefeld für den Aufgabentitel definieren und binden
        val addButton: Button = findViewById(R.id.addButton) // Button zum Hinzufügen der Aufgabe definieren und binden

        // Legt fest, was passiert, wenn der Button gedrückt wird
        addButton.setOnClickListener {
            val title = editText.text.toString().trim() // Holt den eingegebenen Text
            if (title.isNotEmpty()) { // Prüft, ob der Text nicht leer ist
                onAddItem(ToDoItem(title)) // Fügt die Aufgabe hinzu
                dismiss() // Schließt den Dialog
            }
        }
    }
}

