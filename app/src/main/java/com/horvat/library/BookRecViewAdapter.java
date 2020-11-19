package com.horvat.library;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BookRecViewAdapter {

    //1. Nested class ViewHolder
    //3. Novi xml file list_item_book
    public class ViewHolder extends RecyclerView.ViewHolder{

        //2. Konstruktor (alt + insert)
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
