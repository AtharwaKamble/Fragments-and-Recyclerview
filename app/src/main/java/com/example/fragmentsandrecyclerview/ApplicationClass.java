package com.example.fragmentsandrecyclerview;

import android.app.Application;

import java.util.ArrayList;

public class ApplicationClass extends Application
{
    public static ArrayList<Person>people;

    @Override
    public void onCreate() {
        super.onCreate();

        people = new ArrayList<Person>();
        people.add(new Person("John Norris", "659315698"));
        people.add(new Person("Nelson Mandela", "236489125"));
        people.add(new Person("Chuck Rambo", "784563156"));
    }
}
