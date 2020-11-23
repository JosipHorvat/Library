package com.horvat.library;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {

    public static final String  BOOK_ID_KEY = "bookId";

    private ImageView bookImage;
    private TextView txtBookName, txtPages, txtAuthor, txtDescription;
    private Button btnAddWantToRead, btnAddCurrentlyReading, btnAddAlreadyRead, btnAddToFavorite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        initViews();


        Intent intent = getIntent();
        if(null != intent) {
            int bookId = intent.getIntExtra(BOOK_ID_KEY, -1);

            if (bookId != -1) {
            Book incomingBook = Utils.getInstance().getBookById(bookId);
         if(null != incomingBook){
             setData(incomingBook);

             handleAlreadyRead(incomingBook);
             handleWantToReadBooks(incomingBook);
             handleCurrentlyReadingBook(incomingBook);
             handleFavoriteBooks(incomingBook);
                }
            }
        }
    }

    private void handleFavoriteBooks(Book book) {
        ArrayList<Book> favoriteBooks = Utils.getInstance().getFavoriteBooks();

        boolean existInFavoriteBooks = false;
        for(Book b: favoriteBooks){
            if(b.getId() == book.getId()){
                existInFavoriteBooks = true;
            }
        }
        if(existInFavoriteBooks){
            btnAddToFavorite.setEnabled(false);
        }else {
            btnAddToFavorite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(Utils.getInstance().addToFavorite(book)){
                        Toast.makeText(BookActivity.this, "Book Added", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(BookActivity.this, FavoriteBooksActivity.class);
                        startActivity(intent);

                    }else{
                        Toast.makeText(BookActivity.this, "Something wrong happend, please try again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void handleCurrentlyReadingBook(final Book book) {
        ArrayList<Book> currentlyReadingBook = Utils.getInstance().getCurrentlyReadingBooks();

        boolean existInCurrentlyReadingBooks = false;
        for(Book b: currentlyReadingBook){
            if(b.getId() == book.getId()){
                existInCurrentlyReadingBooks = true;
            }
        }
        if(existInCurrentlyReadingBooks){
            btnAddCurrentlyReading.setEnabled(false);
        }else {
            btnAddCurrentlyReading.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(Utils.getInstance().addToCurrentlyReadingBook(book)){
                        Toast.makeText(BookActivity.this, "Book Added", Toast.LENGTH_SHORT).show();


                            Intent intent = new Intent(BookActivity.this, CurrentlyReadingBookActivity.class);
                            startActivity(intent);

                    }else{
                        Toast.makeText(BookActivity.this, "Something wrong happend, please try again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void handleWantToReadBooks(final Book book) {
        ArrayList<Book> wantToReadBooks = Utils.getInstance().getWantToReadBooks();

        boolean existInWantToReadBooks = false;
        for(Book b: wantToReadBooks){
            if(b.getId() == book.getId()){
                existInWantToReadBooks = true;
            }
        }
        if(existInWantToReadBooks){
            btnAddWantToRead.setEnabled(false);
        }else {
            btnAddWantToRead.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(Utils.getInstance().addToWantToReadBook(book)){
                        Toast.makeText(BookActivity.this, "Book Added", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(BookActivity.this, WantToReadActivity.class);
                        startActivity(intent);

                    }else{
                        Toast.makeText(BookActivity.this, "Something wrong happend, please try again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    /**
     * Enable and disable button
     * Add book to Already read Book ArrayList
     * @param book
     */
    private void handleAlreadyRead( final Book book){
        ArrayList<Book> alreadyReadBooks = Utils.getInstance().getAlreadyReadBook();

        boolean existInAlreadyReadBooks = false;
        for(Book b: alreadyReadBooks){
            if(b.getId() == book.getId()){
                existInAlreadyReadBooks = true;
            }
        }
        if(existInAlreadyReadBooks){
            btnAddAlreadyRead.setEnabled(false);
        }else {
            btnAddAlreadyRead.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
            if(Utils.getInstance().addToAlreadyRead(book)){
                Toast.makeText(BookActivity.this, "Book Added", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(BookActivity.this, AlreadyReadBookActivity.class);
                startActivity(intent);

            }else{
                Toast.makeText(BookActivity.this, "Something wrong happend, please try again", Toast.LENGTH_SHORT).show();
            }
                }
            });
        }
    }

    private void setData(Book book) {
        txtBookName.setText(book.getName());
        txtAuthor.setText(book.getAuthor());
        txtPages.setText(String.valueOf(book.getPages()));
        txtDescription.setText(book.getLongDescription());
        Glide.with(this)
                .asBitmap()
                .load(book.getImageUrl())
                .into(bookImage);

    }

    private void initViews() {

     bookImage = findViewById(R.id.bookImage);

    txtBookName = findViewById(R.id.txtBookName);
    txtPages = findViewById(R.id.txtPages);
    txtAuthor = findViewById(R.id.txtAuthorName);
    txtDescription = findViewById(R.id.txtDescription);

    btnAddWantToRead = findViewById(R.id.btnAddWantToRead);
    btnAddAlreadyRead = findViewById(R.id.btnAddAlreadyRead);
    btnAddCurrentlyReading = findViewById(R.id.btnAddToCurrentlyReading);
    btnAddToFavorite = findViewById(R.id.btnAddToFavorites);


    }
}