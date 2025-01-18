package com.alessandro.notesApp.model;

import jakarta.persistence.*;



@Entity
@Table(name = "note")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "note_generator")
    private int id;

    @Column(length = 512)
    private String note;



    public Note() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNote(String note) {
        this.note = note;
    }



    public String getNote() {
        return note;
    }

    public Note(String note) {
        this.note = note;
    }
}
