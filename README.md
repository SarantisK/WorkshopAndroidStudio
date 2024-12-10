# WorkshopAndroidStudio

### **1. Löschfunktion hinzufügen**

   Ziel:
   Ermögliche es Nutzern, eine Aufgabe zu löschen, indem sie lange auf den Eintrag drücken.

        Hinweise:
            Füge im Adapter einen setOnLongClickListener für die Aufgabe hinzu.
            Entferne den Eintrag aus der Liste und aktualisiere den RecyclerView mit notifyItemRemoved.
            Zeige eine Bestätigung über eine Toast-Nachricht an.

### **2. Sortierfunktion hinzufügen**

   Ziel:
   Sortiere die Aufgabenliste nach Status oder alphabetisch. 
   Wenn du willst kannst du gerne auch einen Button hinzufügen für das Sortieren



### **3. Zähler für offene und erledigte Aufgaben** 

####    Ziel:Zeige die Anzahl der offenen und erledigten Aufgaben in der Main Activity an.
   
        Hinweise:
            Es müssen zwei TextView-Elemente erstellt werden, nur wo? 
            Vergiss das Binding nicht :)


### **4. Für die Richtig Krassen!!! Aufgaben dauerhaft speichern (Persistenz hinzufügen)**
   Ziel:Erweitere die App so, dass Aufgaben gespeichert und nach einem Neustart der App wiederhergestellt werden.

       Aufgabenstellung
           Nutze SharedPreferences, um die Aufgabenliste zu speichern.
           Konvertiere die Liste der Aufgaben (items) in ein JSON-Format, bevor sie gespeichert wird.
           Lade die gespeicherten Aufgaben, wenn die App gestartet wird, und aktualisiere die Anzeige.
           Speichere am besten jedes mal, wenn sich die Ansicht ändert.
       Hinweise:
           Erstelle eine Instanz von SharedPreferences in der MainActivity
           Füge eine Methode hinzu, die die aktuelle Aufgabenliste speichert (saveTasks)
           Füge eine Methode hinzu, die die gespeicherten Aufgaben lädt (loadTasks)
           Verwende am besten Gson für das Konvertieren zu JSON

### **5. Teste doch mal deine APP auf deinem richtigen Smartphone**

   (Falls iPhone: Geht nicht Womp Womp)

  ` Hinweise:
        DU musst den Entwicklermodus aktivieren.
        Einfaches USB einstecken reicht idR nicht aus.`
  
### 6. Fällt dir noch was ein? 