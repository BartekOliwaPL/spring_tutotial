package com.examplecom.infoshareacademy.springdemo.repository;

import com.examplecom.infoshareacademy.springdemo.model.Note;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NoteRepository extends CrudRepository<Note, Long> {

    List<Note> findAllByOrderByDateAsc();
    List<Note> findAllByOrderByDateDesc();

}
