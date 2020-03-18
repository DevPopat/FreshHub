package com.example.freshhub;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;

@ParseClassName("Food")
public class Food extends ParseObject {
    public static final String KEY_NAME = "name";
    public static final String KEY_QUANTITY = "quantity";
    public static final String KEY_IMAGE = "image";
    public static final String KEY_TYPE = "type";

    public String getName(){
        return getString(KEY_NAME);
    }
    public int getQuantity(){
        return getInt(KEY_QUANTITY);
    }
    public String getType(){
        return getString(KEY_TYPE);
    }
    public ParseFile getImage(){
        return getParseFile(KEY_IMAGE);
    }
}
