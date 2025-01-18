package com.alessandro.notesApp.controller;

import com.alessandro.notesApp.service.NoteService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;
import com.alessandro.notesApp.model.Note;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/notes")
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }


    @PostMapping("/addNote")
    public ResponseEntity<String> add(@RequestBody String note) {
        try {
            noteService.save(new Note(note));
            return ResponseEntity.ok("Note added successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to add note: " + e.getMessage());
        }
    }


    @GetMapping("/getNotes")
    public ResponseEntity<List<Note>> getNotes() {
        try {
            List<Note> notes = noteService.findAll();
            return ResponseEntity.ok(notes);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    // Update an existing note
    @PutMapping("/{id}")
    public ResponseEntity<String> updateNote(@PathVariable Long id, @RequestBody Note updatedNote) {
        if (updatedNote.getNote() == null || updatedNote.getNote().isEmpty()) {
            return ResponseEntity.badRequest().body("Note content cannot be empty");
        }
        try {
            Optional<Note> existingNote = noteService.findById(id);
            if (existingNote.isPresent()) {
                Note note = existingNote.get();
                note.setNote(updatedNote.getNote());
                noteService.save(note);
                return ResponseEntity.ok("Note updated successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Note not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to update note: " + e.getMessage());
        }
    }

    // Delete a note
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteNoteById(@PathVariable Long id) {
        try {
            if (noteService.existsById(id)) {
                noteService.deleteById(id);
                return ResponseEntity.ok("Note deleted successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Note not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to delete note: " + e.getMessage());
        }
    }

}
