package com.example.mynote.domain;

import java.util.List;

public interface NotesRepository {

    List<com.example.mynote.domain.Note> getNotes();
}

