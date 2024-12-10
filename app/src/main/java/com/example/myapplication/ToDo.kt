package com.example.myapplication

// Datenklasse für eine Aufgabe
data class ToDoItem(
    val title: String, // Der Titel der Aufgabe
    var isChecked: Boolean = false // Ob die Aufgabe erledigt ist
)

