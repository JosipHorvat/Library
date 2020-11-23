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


        allBooks.add(new Book(3,"Guns, Germs, and Steel: The Fate of Human Societies","Jared Diamond",2000,"https://pictures.abebooks.com/isbn/9780393354324-us.jpg",
                "Fascinating.... Lays a foundation for understanding human history. ―Bill Gates" ,"In this \"artful, informative, and delightful\" (William H. McNeill, New York Review of Books) book, Jared Diamond convincingly argues that geographical and environmental factors shaped the modern world. Societies that had had a head start in food production advanced beyond the hunter-gatherer stage, and then developed religion --as well as nasty germs and potent weapons of war --and adventured on sea and land to conquer and decimate preliterate cultures. A major advance in our understanding of human societies, Guns, Germs, and Steel chronicles the way that the modern world came to be and stunningly dismantles racially based theories of human history. Winner of the Pulitzer Prize, the Phi Beta Kappa Award in Science, the Rhone-Poulenc Prize, and the Commonwealth club of California's Gold Medal."));

        allBooks.add((new Book(4, "The Witcher", " Andrzej Sapkowski",1500, "https://upload.wikimedia.org/wikipedia/en/1/14/Andrzej_Sapkowski_-_The_Last_Wish.jpg",
              "The Witcher (Polish: Wiedźmin, pronounced [ˈvʲɛd͡ʑmʲin]) is a series of fantasy novels and short stories", "The stories are set on an unnamed Continent, which was settled several thousand years earlier by elves from overseas. When they arrived, the elves encountered gnomes and dwarves. After a period of war between the elves and dwarves, the dwarves retreated into the mountains and the elves settled in the plains and forests. Human colonists arrived about five hundred years before the events in the stories, igniting a series of wars. The humans were victorious, and became dominant; the non-human races, now considered second-class citizens, often live in small ghettos within human settlements. Those not confined to the ghettos live in wilderness regions not yet claimed by humans. Other races on the Continent are halflings and dryads; werewolves and vampires appeared after a magical event, known as the Conjunction of the Spheres.\n" +
                "\n" +
                "During the centuries preceding the stories, most of the Continent's southern regions have been taken over by the Nilfgaard Empire; the north belongs to the fragmented Northern Kingdoms. The Witcher saga takes place in the aftermath of the first major war between the Nilfgaard Empire and the Northern Kingdoms, with a second war beginning in the middle of the series." )));
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

    public boolean addToWantToReadBook(Book book){
        return wantToReadBooks.add(book);
    }

    public boolean addToCurrentlyReadingBook(Book book){
        return currentlyReadingBooks.add(book);
    }

    public boolean addToFavorite(Book book){
        return favoriteBooks.add(book);
    }

    public boolean removeFromAlreadyRead(Book book){
        return alreadyReadBook.remove(book);
    }
    public boolean removeFromWantToRead(Book book){
        return wantToReadBooks.remove(book);
    }
    public boolean removeFromCurrentlyReading(Book book){
        return currentlyReadingBooks.remove(book);
    }
    public boolean removeFromFavorites(Book book){
        return favoriteBooks.remove(book);
    }
}
