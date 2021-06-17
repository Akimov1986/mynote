package com.example.mynote.domain;

import com.example.mynote.R;

import java.util.ArrayList;
import java.util.List;

public class NotesRepositoryImpl implements com.example.mynote.domain.NotesRepository {
    @Override
    public List<com.example.mynote.domain.Note> getNotes() {
        ArrayList<com.example.mynote.domain.Note> result = new ArrayList<>();

        result.add(new com.example.mynote.domain.Note(R.string.birthday, R.string.stas_birth));
        result.add(new com.example.mynote.domain.Note(R.string.meeting, R.string.meet_jbs));
        result.add(new com.example.mynote.domain.Note(R.string.party, R.string.party_club));
        result.add(new com.example.mynote.domain.Note(R.string.credit, R.string.cred_bank));
        result.add(new com.example.mynote.domain.Note(R.string.exam, R.string.ex_driv));
        result.add(new com.example.mynote.domain.Note(R.string.haircut, R.string.hair_brs));
        return result;
    }
}
