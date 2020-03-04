package com.server.todolist.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity //JPA Entity - Schnittstelle zur Vereinfachung von Datenbankeinträgen, mappt Java Klassen auf DB-Tabelleneinträge
public class TodoItem {

    private long id;
    @NotBlank
    private String title;
    private boolean done;

    public TodoItem() {

    }

    public TodoItem(Long id, String title, boolean done) {
    this.id = id;
    this.title = title;
    this.done = done;
    }

    @Id //Primary Key --> JPA soll dies als ID des Objekts erkennen
    @GeneratedValue //zeigt an, dass die ID automatisch generiert werden soll.

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
