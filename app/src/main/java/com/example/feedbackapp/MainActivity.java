package com.example.feedbackapp;
import android.os.Bundle;
import android.view.View;
import com.example.feedbackapp.R;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
public class MainActivity extends AppCompatActivity {
    // 1. Move the variable declaration here
    RatingBar ratingBar;
    EditText etFoodName, etFoodFeedback;
    Button btnSubmit;
    TextView tvMsg;
    FirebaseHelper firebaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // ... (WindowInsets code) ...

        // 2. Initialize it HERE after setContentView
        ratingBar = findViewById(R.id.ratingBar);
        etFoodName = findViewById(R.id.etFoodName);
        etFoodFeedback = findViewById(R.id.etFoodFeedback);
        btnSubmit = findViewById(R.id.btnSubmit);
        tvMsg = findViewById(R.id.tvMsg);
        firebaseHelper = new FirebaseHelper();

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etFoodName.getText().toString();
                String feedback = etFoodFeedback.getText().toString();

                // 3. Get the rating value
                float ratingValue = ratingBar.getRating();

                if (name.isBlank()) {
                    Toast.makeText(MainActivity.this, "please enter food name", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (feedback.isBlank()) {
                    Toast.makeText(MainActivity.this, "please enter food feedback", Toast.LENGTH_SHORT).show();
                    return;
                }

                // 4. Use the rating (Update your Feedback class to accept rating if needed)
                Feedback fb = new Feedback(name, feedback, ratingValue);
                firebaseHelper.addFeedback(fb);

                tvMsg.setText("Thanks for the " + ratingValue + " star feedback!");
                // Clear fields
                etFoodName.setText("");
                etFoodFeedback.setText("");
                ratingBar.setRating(0); // Reset stars
            }
        });
    }
}
