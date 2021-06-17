package com.example.mynote.domain;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.DimenRes;
import androidx.annotation.StringRes;

public class Note implements Parcelable {


    @StringRes
    private int name;
    private int description;

    public Note(int name, int description){
        this.name = name;
        this.description = description;

    }

    protected Note(Parcel in) {
        name = in.readInt();
        description = in.readInt();
    }

    public static final Creator<Note> CREATOR = new Creator<Note>() {
        @Override
        public Note createFromParcel(Parcel in) {
            return new Note(in);
        }

        @Override
        public Note[] newArray(int size) {
            return new Note[size];
        }
    };

    public int getName() {
        return name;
    }

    public int getDescription() {
        return description;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(name);
        dest.writeInt(description);
    }
}

