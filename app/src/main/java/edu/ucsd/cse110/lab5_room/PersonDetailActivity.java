package edu.ucsd.cse110.lab5_room;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import edu.ucsd.cse110.lab5_room.model.IPerson;
import edu.ucsd.cse110.lab5_room.model.NotesViewAdapter;
import edu.ucsd.cse110.lab5_room.model.db.AppDatabase;
import edu.ucsd.cse110.lab5_room.model.db.Note;

public class PersonDetailActivity extends AppCompatActivity {

    private AppDatabase db;
    private IPerson person;

    private RecyclerView notesRecyclerView;
    private RecyclerView.LayoutManager notesLayoutManager;
    private NotesViewAdapter notesViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_detail);

        //TextView personNotesView = findViewById(R.id.person_detail_notes);

        Intent intent = getIntent();
        int personId = intent.getIntExtra("person_id", 0);

        db = AppDatabase.singleton(this);
        person = db.personsWithNotesDao().get(personId);
        List<Note> notes = db.notesDao().getForPerson(personId);

        setTitle(person.getName());

        //String personName = intent.getStringExtra("person_name");
        //String[] personNotes = intent.getStringArrayExtra("person_notes");

        //setTitle(personName);
        //personNotesView.setText(String.join("\n", person.getNotes()));

        notesRecyclerView = findViewById(R.id.notes_view);
        notesLayoutManager = new LinearLayoutManager(this);
        notesRecyclerView.setLayoutManager(notesLayoutManager);


        notesViewAdapter = new NotesViewAdapter(notes);
        notesRecyclerView.setAdapter(notesViewAdapter);


    }

    public void onGoBackClicked(View view) {
        finish();
    }
}