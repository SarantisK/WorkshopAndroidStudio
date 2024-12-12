# To-Do-Liste App!

Willkommen bei unserem To-Do-Liste App-Projekt! 🎉 Diese App wurde im Rahmen eines **Workshops zur Einführung in Android-Entwicklung** erstellt und ist perfekt geeignet, um die Grundlagen der App-Entwicklung mit **Kotlin** und **Android Studio** zu erlernen.


# Workshop Android Studio

Bitte öffnen sie das Master Branch in Android Studio für das zu bearbeitende Projekt

Für Lösungen: Die gibt es im Branch ToDoApp-Final (Mit Kommentaren im Code Hinterlegt)

### **1. Löschfunktion hinzufügen**
Ziel: Ermögliche es Nutzern, eine Aufgabe zu löschen, indem sie lange auf den Eintrag drücken.

        Hinweise:
            Füge im Adapter einen setOnLongClickListener für die Aufgabe hinzu.
            Entferne den Eintrag aus der Liste und aktualisiere mit notifyItemRemoved.
            Zeige eine Bestätigung über eine Toast-Nachricht an.

### **2. Sortierfunktion hinzufügen**

Ziel: Sortiere die Aufgabenliste nach Status oder alphabetisch. 
Wenn du willst kannst du gerne auch einen Button hinzufügen für das Sortieren



### **3. Zähler für offene und erledigte Aufgaben** 

Ziel: Zeige die Anzahl der offenen und erledigten Aufgaben in der Main Activity an.
   
        Hinweise:
            Es müssen zwei TextView-Elemente erstellt werden 
            findViewByID um die Textview Elemente zu finden.


### **4. Für die Richtig Krassen!!! Aufgaben dauerhaft speichern (Persistenz hinzufügen)**
Ziel: Erweitere die App so, dass Aufgaben gespeichert und nach einem Neustart der App wiederhergestellt werden.

       Aufgabenstellung
           Nutze SharedPreferences, um die Aufgabenliste zu speichern
           Lade die gespeicherten Aufgaben, wenn die App gestartet wird, und aktualisiere die Anzeige.
           Speichere am besten jedes mal, wenn sich die Ansicht ändert.

       Hinweise:
           Erstelle eine Instanz von SharedPreferences in der MainActivity
           Füge eine Methode hinzu, die die aktuelle Aufgabenliste speichert (saveTasks)
           Füge eine Methode hinzu, die die gespeicherten Aufgaben lädt (loadTasks)

           

### **5. Teste doch mal deine APP auf deinem richtigen Smartphone**
(Falls iPhone: Geht nicht Womp Womp)

      Hinweise:
            DU musst den Entwicklermodus auf deinem Smartphone aktivieren.
            Einfaches USB einstecken reicht idR nicht aus.
  
### 6. Fällt dir noch was ein? 
