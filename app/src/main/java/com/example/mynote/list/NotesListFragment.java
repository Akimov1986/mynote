package com.example.mynote.list;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mynote.R;
import com.example.mynote.domain.Note;
import com.example.mynote.domain.NotesRepository;
import com.example.mynote.domain.NotesRepositoryImpl;

import java.util.List;

public class NotesListFragment extends Fragment {

    public interface OnNoteClicked {
        void onNoteClicked(Note note);
    }

    private NotesRepository notesRepository;

    private OnNoteClicked onNoteClicked;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if(context instanceof OnNoteClicked) {
            onNoteClicked = (OnNoteClicked) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();

        onNoteClicked = null;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        notesRepository = new NotesRepositoryImpl();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull  LayoutInflater inflater, @Nullable  ViewGroup container, @Nullable  Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_notes_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        LinearLayout noteslist = view.findViewById(R.id.notes_list_container);

        List<Note> notes = notesRepository.getNotes();

        for(Note note: notes) {
            View itemView = LayoutInflater.from(requireContext()).inflate(R.layout.item_notes, noteslist,false);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onNoteClicked != null) {
                        onNoteClicked.onNoteClicked(note);
                    }

                }
            });

            TextView noteName = itemView.findViewById(R.id.note_name);
            noteName.setText(note.getName());

            noteslist.addView(itemView);
        }


    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

}

