package com.thrillio.managers;

import com.thrillio.dao.BookmarkDao;
import com.thrillio.entities.*;

public class BookmarkManagers {

    private static BookmarkManagers instance = new BookmarkManagers();
    private static BookmarkDao dao = new BookmarkDao();
    private BookmarkManagers(){

    }
    public static BookmarkManagers getInstance(){
        return instance;
    }

    public WebLink createWebLink(long id,String title,String url,String host){
        WebLink webLink = new WebLink();

        webLink.setId(id);
        webLink.setTitle(title);
        webLink.setUrl(url);
        webLink.setHost(host);

        return webLink;
    }
    public Book createBook(long id, String title,int publicationYear, String publisher, String [] authors, String genre,double amazonRating){
        Book book = new Book();

        book.setId(id);
        book.setTitle(title);

        book.setPublicationYear(publicationYear);
        book.setPublisher(publisher);
        book.setAuthors(authors);
        book.setGenre(genre);
        book.setAmazonRating(amazonRating);

        return book;

    }
    public Movie createMovie(long id, String title, String profileURL, int releaseYear, String [] cast, String[] directors, String genre, double imdbRating){
        Movie movie = new Movie();

        movie.setId(id);
        movie.setTitle(title);
        movie.setProfileUrl(profileURL);
        movie.setReleaseYear(releaseYear);
        movie.setCast(cast);
        movie.setDirectors(directors);
        movie.setGenre(genre);
        movie.setImbRating(imdbRating);

        return movie;

    }

    public Bookmark[][] getBookmarks(){
        return dao.getBookmarks();
    }

    public void saveUserBookmark(User user, Bookmark bookmark) {
        UserBookmark userBookmark = new UserBookmark();
        userBookmark.setUser(user);
        userBookmark.setBookmark(bookmark);

        //passing to the Dao for SQL stuffs
        dao.saveUserBookmark(userBookmark);
    }

    public void setKidFriendlyStatus(User user, String kidFriendlyStatus, Bookmark bookmark) {
        bookmark.setKidFriendlyStatus(kidFriendlyStatus);
        bookmark.setKidFriendlyMarkedBy(user);

        System.out.println("Kid Friendly Status: " + kidFriendlyStatus + ", Marked By" + user.getEmail()+","+bookmark);
    }

    public void share(User user, Bookmark bookmark) {
        bookmark.setSharedBy(user);

        System.out.println("Data to be Shared:");

        if(bookmark instanceof Book){
            System.out.println(((Book)bookmark).getItemData());
        }
        else if(bookmark instanceof WebLink){
            System.out.println(((WebLink)bookmark).getItemData());
        }
    }
}
