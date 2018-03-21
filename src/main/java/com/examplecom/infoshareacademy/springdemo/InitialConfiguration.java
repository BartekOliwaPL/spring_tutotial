package com.examplecom.infoshareacademy.springdemo;

import com.examplecom.infoshareacademy.springdemo.model.Note;
import com.examplecom.infoshareacademy.springdemo.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

@Component
public class InitialConfiguration {

    @Autowired
    private NoteRepository noteRepository;

    @PostConstruct
    public void onStartup() {
        noteRepository.save(new Note("Test note 1", LocalDateTime.now()));
        noteRepository.save(new Note("Test note 2", LocalDateTime.now()));
        noteRepository.save(new Note("Test note 3", LocalDateTime.now()));
    }
}
