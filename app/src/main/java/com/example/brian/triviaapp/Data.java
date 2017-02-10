/*
Assignment #: In Class 04
File Name: Data.java
Group Members: Brian Bystrom, Mohamed Salad
*/

package com.example.brian.triviaapp;

import java.util.ArrayList;

/**
 * Created by brianbystrom on 2/6/17.
 */

public class Data {
    String text, image;
    ArrayList<String> choices;
    int id, answer;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Data{" +
                "text='" + text + '\'' +
                ", image='" + image + '\'' +
                ", choices=" + choices +
                ", id=" + id +
                ", answer=" + answer +
                '}';
    }

    public ArrayList<String> getChoices() {
        return choices;
    }

    public void setChoices(ArrayList<String> choices) {
        this.choices = choices;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public Data() {

    }
}
