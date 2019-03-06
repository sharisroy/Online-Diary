package com.example.onlinediary.AccountActivity;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.onlinediary.Model.Listdata;
import com.example.onlinediary.Model.Notes;
import com.example.fishermen.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class PreviousNotesActivity extends AppCompatActivity {

   DatabaseReference databaseReference;
   ArrayList<Listdata> list;
    FirebaseDatabase database;
    RecyclerView recyclerview;
    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previous_note);


        Bundle extras = getIntent().getExtras();
        String emailId = extras.getString("key");
        recyclerview = (RecyclerView)  findViewById(R.id.rview);
        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("Notes");
        Query query = databaseReference.orderByChild("userId").equalTo(emailId);
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                list = new ArrayList<>();
                for(DataSnapshot data: dataSnapshot.getChildren()){

                    Notes notes = data.getValue(Notes.class);
                    Listdata listdata = new Listdata();

                    String name=notes.getName();
                    String note =notes.getDetails();
                    String date=notes.getDate();

                    listdata.setName(name);
                    listdata.setDetails(note);
                    listdata.setDate(date);
                    list.add(listdata);

                }
                RecyclerviewAdapter recycler = new RecyclerviewAdapter(list);
                RecyclerView.LayoutManager layoutmanager = new LinearLayoutManager(PreviousNotesActivity.this);
                recyclerview.setLayoutManager(layoutmanager);
                recyclerview.setItemAnimator( new DefaultItemAnimator());
                recyclerview.setAdapter(recycler);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

        });


    }

}

