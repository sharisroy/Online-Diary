package com.example.onlinediary.AccountActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.onlinediary.Model.Notes;
import com.example.fishermen.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;


public class NotesActivity extends AppCompatActivity {

    private EditText inputName, inputDetails,inputDate;
    private Button btnSubmit;
    private ProgressBar progressBar;
    private FirebaseAuth auth;
    DatabaseReference databaseReference;
    Calendar currentDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        auth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference("Notes");

        btnSubmit = (Button) findViewById(R.id.submit);
        inputName = (EditText) findViewById(R.id.nName);
        inputDetails = (EditText) findViewById(R.id.noteDetails);
        inputDate = (EditText) findViewById(R.id.date);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);



        inputDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentDate = Calendar.getInstance();

                int year = currentDate.get(Calendar.YEAR);
                int month = currentDate.get(Calendar.MONTH);
                final int day = currentDate.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(NotesActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        inputDate.setText(dayOfMonth+"-"+month+"-"+year);

                        currentDate.set(year,month,day);

                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle extras = getIntent().getExtras();
                String name = inputName.getText().toString().trim();
                String details = inputDetails.getText().toString().trim();
                String date = inputDate.getText().toString().trim();
                String id = databaseReference.push().getKey();
                String emailId = extras.getString("key");

                Notes notes = new Notes(id,name,details,date,emailId);

                databaseReference.child(id).setValue(notes);

                inputName.setText("");
                inputDetails.setText("");
                inputDate.setText("");

                startActivity(new Intent(NotesActivity.this, PreviousNotesActivity.class));
                finish();
            }
        });
    }


}
