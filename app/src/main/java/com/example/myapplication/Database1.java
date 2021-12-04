package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Database1 extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<User> arrayList;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database1);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        arrayList = new ArrayList<>();


        database = FirebaseDatabase.getInstance();

        databaseReference = database.getReference();


        //db에서 데이터 가져오기
        databaseReference.child("center").child("0").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                arrayList.clear();
//                String name;
//
//                User user = datasnapshot.getValue(User.class);
//
//                name = user.getName();
//                arrayList.add(user);

                //데이터 하나만 불러올 때
                if(datasnapshot.getValue(User.class) != null){
                    User post = datasnapshot.getValue(User.class);
                    arrayList.add(post);
               }

////                모든 데이터 불러올 때
//                for(DataSnapshot snapshot : datasnapshot.getChildren()){
//                    User user = snapshot.getValue(User.class);
//                    arrayList.add(user);//arrayList에 데이터 넣기
//                }

                adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.e("Database", String.valueOf(databaseError.toException()));
            }
        });

        adapter = new CustomAdapter2(arrayList, this);
        recyclerView.setAdapter(adapter);

    }

}