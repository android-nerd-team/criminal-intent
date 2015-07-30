package com.example.recepinanc.criminalintent;

import java.util.UUID;

/**
 * Created by Recepinanc on 30.07.2015.
 */
public class Crime {

    private UUID mId;
    private String mTitle;

    public Crime(){
        mId = UUID.randomUUID(); //Generate unique identifier
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String Title) {
        this.mTitle = Title;
    }
}

