package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// Adapter zur Darstellung der Aufgaben in der RecyclerView
class ToDoAdapter(
    // Die Liste der Aufgaben
    private val items: MutableList<ToDoItem>,

    // Callback, das aufgerufen wird, wenn sich der Zustand einer Aufgabe ändert
    private val onItemCheckChanged: (Int, Boolean) -> Unit
) : RecyclerView.Adapter<ToDoAdapter.ToDoViewHolder>() {

    // Der ViewHolder hält die Referenzen auf die UI-Elemente für eine Aufgabe
    inner class ToDoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.title) // Das Textfeld für den Aufgabentitel
        val checkBox: CheckBox = view.findViewById(R.id.checkBox) // Die CheckBox
    }

    // Erstellt neue ViewHolder, wenn sie benötigt werden
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        // Erstellt eine neue Ansicht basierend auf dem Layout der Aufgabe
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.todo_item, parent, false)
        return ToDoViewHolder(view)
    }

    // Verknüpft Daten mit einem ViewHolder
    // d.h. was passiert, wenn der Adapter verbunden wird in der Oberfläche
    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
        val item = items[position] // Holt die Aufgabe aus der Liste
        holder.title.text = item.title // Setzt den Aufgabentitel
        holder.checkBox.isChecked = item.isChecked // Setzt den Zustand der CheckBox

        // Reagiert, wenn die CheckBox geändert wird
        holder.checkBox.setOnCheckedChangeListener { _, isChecked ->
            onItemCheckChanged(position, isChecked)
        }
    }

    // Gibt die Anzahl der Aufgaben zurück
    override fun getItemCount() = items.size
}
