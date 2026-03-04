package com.example.feedbackapp;
public class Feedback {
    private String name;
    private String feedback;private float rating; // 1. Add this field

    // 2. Default constructor (Required for Firebase)
    public Feedback() {}

    // 3. Update constructor to include rating
    public Feedback(String name, String feedback, float rating) {
        this.name = name;
        this.feedback = feedback;
        this.rating = rating;
    }

    // 4. Getters and Setters (Required for Firebase)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getFeedback() { return feedback; }
    public void setFeedback(String feedback) { this.feedback = feedback; }

    public float getRating() { return rating; }
    public void setRating(float rating) { this.rating = rating; }
}
