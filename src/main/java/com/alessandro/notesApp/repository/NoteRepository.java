package com.alessandro.notesApp.repository;

import com.alessandro.notesApp.model.Note;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends CrudRepository<Note, Long> {

}
