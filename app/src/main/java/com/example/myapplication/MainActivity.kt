package com.example.myapplication

// Importiert die notwendigen Klassen und Pakete
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

// Die MainActivity ist der Einstiegspunkt der App
class MainActivity : AppCompatActivity() {

    // Eine Liste, die alle Aufgaben speichert
    private val items = mutableListOf<ToDoItem>()

    // Adapter für die RecyclerView, der die Daten anzeigt
    private lateinit var adapter: ToDoAdapter

    // Wird aufgerufen, wenn die App gestartet wird
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Setzt/Bindet das Layout für die Activity

        // Verknüpft die RecyclerView aus dem Layout mit einer Variablen
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)

        // Verknüpft den Floating Action Button (FAB) aus dem Layout
        val fab: FloatingActionButton = findViewById(R.id.fab)

        // Erstellt einen Adapter und übergibt die Aufgabenliste
        adapter = ToDoAdapter(items) { position, isChecked ->
            // Aktualisiert den Zustand der Aufgabe (abgehakt oder nicht)
            items[position].isChecked = isChecked

            // Zeigt eine kurze Nachricht an, um Feedback zu geben
            Toast.makeText(
                this,
                "${items[position].title} ist ${if (isChecked) "erledigt" else "nicht erledigt"}",
                Toast.LENGTH_SHORT
            ).show()
        }

        // Verknüpft die RecyclerView mit einem LayoutManager, der die Einträge als Liste anordnet
        recyclerView.layoutManager = LinearLayoutManager(this) // Gibt an wie die Liste dargestellt werden soll (Vertikal)
        recyclerView.adapter = adapter // Setzt den Adapter für die RecyclerView. | Wenn Adapter geändert wird ändere auch in der Liste

        // Legt fest, was passiert, wenn der Floating Action Button gedrückt wird
        fab.setOnClickListener {
            // Zeigt einen Dialog (Kleines Fenster) an, um eine neue Aufgabe hinzuzufügen
            showAddToDoDialog()
        }
    }

    // Öffnet den Dialog zum Hinzufügen einer neuen Aufgabe
    private fun showAddToDoDialog() {
        val dialog = AddToDoDialog(this) { newItem ->
            // Fügt die neue Aufgabe zur Liste hinzu
            items.add(newItem)

            // Informiert die RecyclerView, dass ein neuer Eintrag hinzugefügt wurde
            adapter.notifyItemInserted(items.size - 1) // Weil wir hier bei 1 starten statt 0
        }
        dialog.show() // Zeigt den Dialog an
    }
}
