package com.example.feedbackapp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseHelper {

    DatabaseReference databaseReference;

    FirebaseHelper() {
        databaseReference = FirebaseDatabase.getInstance().getReference("trc_bandra");
    }

    void addFeedback(Feedback fb) {
        String key = databaseReference.push().getKey();
        databaseReference.child(key).setValue(fb);
    }
}