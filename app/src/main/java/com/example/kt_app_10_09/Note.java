package com.example.kt_app_10_09;

public class Note {
    private String title;
    private String content;

    // Constructor
    public Note(String title, String content) {
        this.title = title;
        this.content = content;
    }

    // Getter cho title
    public String getTitle() {
        return title;
    }

    // Setter cho title
    public void setTitle(String title) {
        this.title = title;
    }

    // Getter cho content
    public String getContent() {
        return content;
    }

    // Setter cho content
    public void setContent(String content) {
        this.content = content;
    }
}
