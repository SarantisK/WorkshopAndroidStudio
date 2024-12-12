package com.example.myapplication

// Importiert die notwendigen Klassen und Pakete
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

// Die MainActivity ist der Einstiegspunkt der App
class MainActivity : AppCompatActivity() {
    //Für Aufgabe 4 || erstellt sog. Preferences welche in der APP gespeichert werden.
    private lateinit var sharedPreferences: SharedPreferences

    // Eine Liste, die alle Aufgaben speichert
    private val items = mutableListOf<ToDoItem>()

    // Adapter für die RecyclerView, der die Daten anzeigt
    private lateinit var adapter: ToDoAdapter

    // Wird aufgerufen, wenn die App gestartet wird
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Setzt/Bindet das Layout für die Activity

        //Aufgabe 4 || Hier wird die Liste geladen und Shared Preferences werden erstellt.
        sharedPreferences = getSharedPreferences("ToDoPrefs", MODE_PRIVATE)
        loadTasks() // Aufgabe 4 || Hier wird die Liste geladen

        // Verknüpft die RecyclerView aus dem Layout mit einer Variablen
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        // Verknüpft den Floating Action Button (FAB) aus dem Layout
        val fab: FloatingActionButton = findViewById(R.id.fab)

        //Aufgabe 2|| Sortierung von Liste || Buttons für die Sortierfunktionen Binden
        val btnSortByStatus: Button = findViewById(R.id.btn_sort_by_status)
        val btnSortAlphabetically: Button = findViewById(R.id.btn_sort_alphabetically)

        // Erstellt einen Adapter und übergibt die Aufgabenliste
        adapter = ToDoAdapter(items) { position, isChecked ->
            // Aktualisiert den Zustand der Aufgabe (abgehakt oder nicht)
            items[position].isChecked = isChecked

            //AUfgabe 3 & 4 ||Update der UI und speicherung der Liste
            saveTasks()
            updateTaskCounters()


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

        btnSortByStatus.setOnClickListener {
            sortItemsByStatus()
        }

        // Button: Alphabetisch sortieren
        btnSortAlphabetically.setOnClickListener {
            sortItemsAlphabetically()
        }
    }

    // Öffnet den Dialog zum Hinzufügen einer neuen Aufgabe
    private fun showAddToDoDialog() {
        val dialog = AddToDoDialog(this) { newItem ->
            // Fügt die neue Aufgabe zur Liste hinzu
            items.add(newItem)
            // Informiert die RecyclerView, dass ein neuer Eintrag hinzugefügt wurde
            adapter.notifyItemInserted(items.size - 1) // Weil wir hier bei 1 starten statt 0
            //Aufgabe 3 || Zählfunktion hinzufügen
            updateTaskCounters() // Wenn eine neue Aufgabe hinzugefügt wird, aktualisiere die Zähler
            saveTasks() // Aufgabe 4 || Hier wird die Liste gespeichert
        }
        dialog.show() // Zeigt den Dialog an
    }

    //Aufgabe 2 || Sortierung von Liste
    private fun sortItemsByStatus() {
        // Sortiere: Offene Aufgaben zuerst, erledigte Aufgaben zuletzt
        items.sortWith(compareBy { it.isChecked })
        adapter.notifyDataSetChanged() // Aktualisiere die Ansicht
    }
    private fun sortItemsAlphabetically() {
        // Sortiere: Nach dem Titel alphabetisch
        items.sortBy { it.title.lowercase() }
        adapter.notifyDataSetChanged() // Aktualisiere die Ansicht
    }

    //Aufgabe 3 || Zähler für offene und erledigte Aufgaben
    public fun updateTaskCounters() {
        // Zähle offene und erledigte Aufgaben
        val openTasks = items.count { !it.isChecked }
        val doneTasks = items.count { it.isChecked }

        // Aktualisiere die TextViews
        findViewById<TextView>(R.id.tv_open_tasks).text = "Offene Aufgaben: $openTasks"
        findViewById<TextView>(R.id.tv_done_tasks).text = "Erledigte Aufgaben: $doneTasks"
    }


    //Aufgabe 4 || Speichern der Liste
    public fun saveTasks() {
        val editor = sharedPreferences.edit()

        // Konvertiere die Liste in einen String
        val taskString = items.joinToString(";") { "${it.title}|${it.isChecked}" }

        // Speichere den String in SharedPreferences
        editor.putString("tasks", taskString)
        editor.apply() // Übernimmt die Änderungen

    }

    public fun loadTasks() {
        val taskString = sharedPreferences.getString("tasks", null) ?: return

        // Konvertiere den gespeicherten String zurück in die Aufgabenliste
        val loadedItems = taskString.split(";").map { task ->
            val parts = task.split("|")
            ToDoItem(title = parts[0], isChecked = parts[1].toBoolean())
        }

        // Füge die geladenen Aufgaben zur Liste hinzu
        items.addAll(loadedItems)
    }


}
