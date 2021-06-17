package com.example.mynote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.mynote.R;
import com.example.mynote.details.NoteDetailsActivity;
import com.example.mynote.details.NoteDetailsFragment;
import com.example.mynote.domain.Note;
import com.example.mynote.list.NotesListFragment;

public class MainActivity extends AppCompatActivity implements NotesListFragment.OnNoteClicked {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onNoteClicked(Note note) {

        boolean isLandscape = getResources().getBoolean(R.bool.isLandscape);

        if (isLandscape) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.notes_details_fragment, NoteDetailsFragment.newInstance(note))
                    .commit();

        } else {
            /*Toast.makeText(this,note.getDescription(), Toast.LENGTH_SHORT).show();*/
            Intent intent = new Intent(this, NoteDetailsActivity.class);
            intent.putExtra(NoteDetailsActivity.ARG_NOTE, note);
            startActivity(intent);
        }
    }
}