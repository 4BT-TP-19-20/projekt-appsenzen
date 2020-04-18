## Beschreibung Oberfläche
<details><summary>Home.fxml</summary>

 - Diese Datei enthält den Entwurf der Dashboard
 - Wird beim Starten der App angezeigt
 - Zeigt den aktuellen Datum und Uhrzeit an
 - Zeigt, in wie viel Zeit die nächste Unterrichtsstunde anfängt
 - Zeigt die Schüler der aktuellen Klasse an, wenn man auf einen Schüler clickt, kommt man auf seiner Detailansicht  
 * muss Dynamisch erzeugt werden, da die Anzahl der Schüler von Klasse zu Klasse unterschiedlich ist
</details>

<details><summary>Klassen.fxml</summary>
  
  - In diesem Fenster kann eine Klasse ausgewählt werden und alle Schüler werden aufgelistet
  - Wird durch das Drücken eines Knopfes auf der unteren Leiste angezeigt  
  - Durch das Drücken des Schülernamens kommt man auf die Detailansicht, wo die Schülerinformationen angezeigt werden 
  * muss Dynamisch erzeugt werden, da die Anzahl der Schüler von Klasse zu Klasse unterschiedlich ist
</details>

<details><summary>Stundenplan.fxml</summary>
  
  - In diesem Fenster kann der Stundenplan angezeigt werden 
  - Wird durch das Drücken eines Knopfes auf der unteren Leiste angezeigt
  * Kann statisch erzeugt werden, da sich der Stundenplan nicht so schnell ändert 
</details>

<details><summary>Schueleransicht.fxml</summary>
  
  - Zeigt die Detailansicht des Schülers an (Name, Klasse, alte Absenzen) 
  - Enthält ein Knopf zum Eintragen ob der Schüler abwesend ist oder nicht
  - Wird durch das Drücken des Knopfes auf der Dashboard oder durch das Drücken des Knopfes in der Klassenansicht aufgerufen.
  * Kann statisch erzeugt werden, da sich nur der Absenzenlog ändert (Als String abgespeichert und mit label.setText geändert) 
</details>

<details><summary>Einstellungen.fxml</summary>
  - Enthält die Einstellungen der App 
  - Wird durch einen Knopf auf der oberen Leiste aufgerufen 
  * Kann statisch erzeugt werden, da bei den Einstellungen wenig geändert werden muss
</details>
