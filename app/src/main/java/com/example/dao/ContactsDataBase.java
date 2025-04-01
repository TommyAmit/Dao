package com.example.dao;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Contact.class}, version = 1)
public abstract class ContactsDataBase extends RoomDatabase {
    private static ContactsDataBase instance;

    public abstract ContactDAO noteDao();

    public static synchronized ContactsDataBase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(
                    context.getApplicationContext(),
                            ContactsDataBase.class,
                    "contact_db")
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
}
