package com.horvat.library;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class AllBooksActivity extends AppCompatActivity {
    //16:
    private BookRecViewAdapter adapter;

    private RecyclerView booksRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_books);

    adapter = new BookRecViewAdapter(this);
        booksRecyclerView = findViewById(R.id.booksRecycleView);

        booksRecyclerView.setAdapter(adapter);
        booksRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Book> books = new ArrayList<>();

        books.add(new Book( 1, "Rat i mir" , "Tolstoj" ,2000,"https://www.njuskalo.hr/image-w920x690/knjige-knjizevnost/rat-mir-slika-18343244.jpg",
       "Brilliant ", "Long description" ));


        books.add(new Book(2,"Mali princ", "Antoan de Sent-Egziperi",200,"https://i.ytimg.com/vi/EkCrKWZvlu0/hqdefault.jpg",
                "Prica o doziviljajima malog princa", "Predugi opis"));

        adapter.setBooks(books);
    }
}