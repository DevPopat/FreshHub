package com.example.freshhub;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;


@ParseClassName("User")
public class User extends ParseObject{
    public static final String KEY_NAME = "name";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_CREATED_AT = "createdAt";

    public String getName(){
        return getString(KEY_NAME);
    }
    public String getEmail(){
        return getString(KEY_EMAIL);
    }
}
