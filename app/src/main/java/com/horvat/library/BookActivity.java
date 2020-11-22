package com.horvat.library;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

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

//        String loremIpsum = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla placerat ullamcorper faucibus. Nulla at scelerisque est, eget tempus magna. Proin lacinia pretium nisl ut pretium. Phasellus viverra velit non ligula facilisis, sed molestie turpis porta. Donec ut commodo mi. Nam laoreet laoreet turpis, non tempus diam vestibulum vel. Sed egestas scelerisque magna, at viverra velit semper quis. Etiam sed aliquet nisl. Duis porttitor dapibus leo. Mauris id sagittis nunc. Maecenas ultricies molestie ligula viverra convallis. Suspendisse ac dui varius, facilisis risus quis, commodo diam.\n" +
//                "\n" +
//                "Praesent gravida tristique velit sed gravida. Nam molestie nulla rhoncus semper fringilla. Sed nec neque bibendum, fringilla ipsum ac, efficitur diam. Morbi tempus tellus et tempus scelerisque. Suspendisse metus magna, consequat vitae felis et, semper gravida lorem. Donec laoreet, dui ut mattis accumsan, lacus quam pellentesque leo, sagittis tempor orci arcu eu sem. Sed accumsan purus quis eros accumsan, et hendrerit sapien aliquam. Aliquam blandit suscipit dui, blandit cursus sapien pharetra non. Sed vitae tellus pellentesque orci facilisis vestibulum. Sed vitae dui eget purus bibendum egestas. Donec dapibus condimentum lorem, quis iaculis lacus fermentum nec. Pellentesque nec vehicula lorem. Morbi pretium, dolor sed porta aliquet, diam turpis pellentesque leo, eu vehicula diam ante in mi. Nunc lorem turpis, aliquet vitae ligula ut, finibus dapibus ligula. Nulla tincidunt condimentum nisi nec consectetur.";
//
//    //TODO: get the data from recyclet view in here
//    Book book = (new Book(2,"Mali princ", "Antoan de Sent-Egziperi",200,"https://i.ytimg.com/vi/EkCrKWZvlu0/hqdefault.jpg",
//                "Prica o doziviljajima malog princa", loremIpsum));

        Intent intent = getIntent();
        if(null != intent) {
            int bookId = intent.getIntExtra(BOOK_ID_KEY, -1);

            if (bookId != -1) {
            Book incomingBook = Utils.getInstance().getBookById(bookId);
         if(null != incomingBook){
             setData(incomingBook);
                }
            }
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
    btnAddCurrentlyReading = findViewById(R.id.btnCurrentlyReading);
    btnAddToFavorite = findViewById(R.id.btnAddToFavorites);


    }
}