package com.examplecom.infoshareacademy.springdemo;

import com.examplecom.infoshareacademy.springdemo.model.Note;
import com.examplecom.infoshareacademy.springdemo.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NoteController {

    @Autowired
    NoteRepository noteRepository;

    @GetMapping("/notes")
    public List<Note> getAllNotes() {
        return noteRepository.findAllByOrderByDateDesc();
    }

    @GetMapping("/notes/{id}")
    public Note getNoteById(@PathVariable(value = "id") Long noteId) {
        return noteRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException());
    }

    @PostMapping("/add")
    public Note createNote(@RequestBody Note note) {
        return noteRepository.save(note);
    }

    @DeleteMapping("/remove/{id}")
    public void removeNote(@PathVariable(value = "id") Long noteID) {
        noteRepository.deleteById(noteID);
    }



}
