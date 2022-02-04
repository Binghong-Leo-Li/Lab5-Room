package edu.ucsd.cse110.lab5_room;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import edu.ucsd.cse110.lab5_room.model.IPerson;
import edu.ucsd.cse110.lab5_room.model.db.AppDatabase;

public class PersonDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_detail);

        TextView personNotesView = findViewById(R.id.person_detail_notes);

        Intent intent = getIntent();
        int personId = intent.getIntExtra("person_id", 0);

        AppDatabase db = AppDatabase.singleton(this);
        IPerson person = db.personsWithNotesDao().get(personId);

        String personName = intent.getStringExtra("person_name");
        String[] personNotes = intent.getStringArrayExtra("person_notes");

        setTitle(personName);
        personNotesView.setText(String.join("\n", personNotes));
    }

    public void onGoBackClicked(View view) {
        finish();
    }
}