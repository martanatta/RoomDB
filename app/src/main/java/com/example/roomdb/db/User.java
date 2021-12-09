package com.example.roomdb.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "first_name")
    public String name;

    @ColumnInfo(name = "last_name")
    public String surname;

    @ColumnInfo(name = "phone")
    public String phone;

    @ColumnInfo(name = "Email")
    public String Email;
}