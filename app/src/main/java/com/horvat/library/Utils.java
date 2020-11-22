package com.horvat.library;

import java.util.ArrayList;

// SINGLETON
public class Utils {

    private static Utils instance;



    private static ArrayList<Book> allBooks;
    private static ArrayList<Book> alreadyReadBook;
    private static ArrayList<Book> wantToReadBooks;
    private static ArrayList<Book> currentlyReadingBooks;
    private static ArrayList<Book> favoriteBooks;

    private Utils() {
        if (null == allBooks) {
            allBooks = new ArrayList<>();
            initData();
        }
        if (null == alreadyReadBook) {
            alreadyReadBook = new ArrayList<>();

        }
        if (null == wantToReadBooks) {
            wantToReadBooks = new ArrayList<>();

        }
        if (null == currentlyReadingBooks) {
            currentlyReadingBooks = new ArrayList<>();

        }
        if (null == favoriteBooks) {
            favoriteBooks = new ArrayList<>();

        }
    }

    private void initData() {
        //TODO: add initial data

        allBooks.add(new Book( 1, "Rat i mir" , "Tolstoj" ,2000,"https://www.njuskalo.hr/image-w920x690/knjige-knjizevnost/rat-mir-slika-18343244.jpg",
                "Brilliant ", "Long description" ));


        allBooks.add(new Book(2,"Mali princ", "Antoan de Sent-Egziperi",200,"https://i.ytimg.com/vi/EkCrKWZvlu0/hqdefault.jpg",
                "Prica o doziviljajima malog princa", "Predugi opis"));
    }

    public static Utils getInstance() {
        if(null != instance){
            return instance;
        }else{
            instance = new Utils();
            return instance;
        }

    }

    public static ArrayList<Book> getAllBooks() {
        return allBooks;
    }

    public static ArrayList<Book> getAlreadyReadBook() {
        return alreadyReadBook;
    }

    public static ArrayList<Book> getWantToReadBooks() {
        return wantToReadBooks;
    }

    public static ArrayList<Book> getCurrentlyReadingBooks() {
        return currentlyReadingBooks;
    }

    public static ArrayList<Book> getFavoriteBooks() {
        return favoriteBooks;
    }

    public  Book getBookById(int id){
        for (Book b : allBooks) {
         if(b.getId() == id){
             return b;
         }
        }
        return null;
    }

    public boolean addToAlreadyRead(Book book){
        return alreadyReadBook.add(book);
    }
}
