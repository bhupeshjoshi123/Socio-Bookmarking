package com.thrillio.managers;

import com.thrillio.dao.BookmarkDao;
import com.thrillio.entities.*;
import java.util.List;
import java.util.Map;

import com.thrillio.constants.BookGenre;
import com.thrillio.constants.KidFriendlyStatus;
import com.thrillio.constants.MovieGenre;


public class BookmarkManagers {

    private static BookmarkManagers instance = new BookmarkManagers();
    private static BookmarkDao dao = new BookmarkDao();
    private BookmarkManagers(){

    }
    public static BookmarkManagers getInstance(){
        return instance;
    }

   public Movie createMovie(long id, String title, String profileUrl, int releaseYear, String[] cast,
			String[] directors, MovieGenre genre, double imdbRating) {
		Movie movie = new Movie();
		movie.setId(id);
		movie.setTitle(title);
		movie.setProfileUrl(profileUrl);
		movie.setReleaseYear(releaseYear);
		movie.setCast(cast);
		movie.setDirectors(directors);
		movie.setGenre(genre);
		movie.setImdbRating(imdbRating);

		return movie;
	}

	public Book createBook(long id, String title, String profileUrl, int publicationYear, String publisher,
			String[] authors, BookGenre genre, double amazonRating) {
		Book book = new Book();
		book.setId(id);
		book.setTitle(title);
		book.setProfileUrl(profileUrl);
		book.setPublicationYear(publicationYear);
		book.setPublisher(publisher);
		book.setAuthors(authors);
		book.setGenre(genre);
		book.setAmazonRating(amazonRating);

		return book;
	}

	public WebLink createWebLink(long id, String title, String profileUrl, String url, String host) {
		WebLink weblink = new WebLink();
		weblink.setId(id);
		weblink.setTitle(title);
		weblink.setProfileUrl(profileUrl);
		weblink.setUrl(url);
		weblink.setHost(host);

		return weblink;
	}

	public Map<Integer, List<Bookmark>> getBookmarks() {
		return dao.getBookmarks();
	}

	public void saveUserBookmark(User user, Bookmark bookmark) {
		UserBookmark userBookmark = new UserBookmark();
		userBookmark.setUser(user);
		userBookmark.setBookmark(bookmark);
		

		
		dao.saveUserBookmark(userBookmark);
	}

	public void setKidFriendlyStatus(User user, KidFriendlyStatus kidFriendlyChoice, Bookmark bookmark) {
		bookmark.setKidFriendlyStatus(kidFriendlyChoice);
		bookmark.setKidFriendlyMarkedBy(user);
		
		dao.updateKidFriendlyStatus(bookmark);
		System.out.println("Kid friendly status: "+ kidFriendlyChoice + ", Marked by: "+ user.getEmail() + ", "+ bookmark);
	}

	public static void share(User user, Bookmark bookmark) {
		bookmark.setSharedBy(user);
		System.out.println("Data to be shared: ");

		if(!(bookmark instanceof Movie)) dao.updateSharedBy(bookmark);
        
		if(bookmark instanceof Book) {
			System.out.println(((Book)bookmark).getItemData());	
		}
		else if(bookmark instanceof WebLink) {
			System.out.println(((WebLink)bookmark).getItemData());	
		}
		
	
    }
}
