package com.alessandro.notesApp.service;

import com.alessandro.notesApp.model.Note;

import com.alessandro.notesApp.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;


    public  List<Note> findAll() {
        Iterable<Note> notes = noteRepository.findAll();
        return StreamSupport.stream(notes.spliterator(), false)
                .collect(Collectors.toList());
    }


    public void save(Note note) {
        noteRepository.save(note);
    }


    public Note getById(Long id) {
        if(noteRepository.findById(id).isPresent()){
            return noteRepository.findById(id).get();
        }
        return null;
    }


    public void deleteById(Long id) {
        noteRepository.deleteById(id);
    }


    public boolean existsById(Long id) {
        return noteRepository.existsById(id);
    }

    public Optional<Note> findById(Long id) {
        return  noteRepository.findById(id);
    }
}
