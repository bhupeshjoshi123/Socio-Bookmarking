package com.thrillio;

import com.thrillio.constants.BookGenre;
import com.thrillio.constants.Gender;
import com.thrillio.constants.MovieGenre;
import com.thrillio.constants.UserType;
import com.thrillio.entities.Bookmark;
import com.thrillio.entities.User;
import com.thrillio.entities.UserBookmark;
import com.thrillio.managers.BookmarkManagers;
import com.thrillio.managers.UserManager;

public class DataStore {

    public static final int TOTAL_USER_COUNT = 5;
    public static final int BOOKMARK_TYPES_COUNT = 3;
    public static final int BOOKMARK_COUNT_PER_TYPE = 5;
    public static final int USER_BOOKMARK_LIMIT = 5;

    private static User[] users =  new User[TOTAL_USER_COUNT];
    public static User[] getUsers() {
        return users;
    }

    private static Bookmark[][] bookmarks = new Bookmark[BOOKMARK_TYPES_COUNT][BOOKMARK_COUNT_PER_TYPE];
    public static Bookmark[][] getBookmarks() {
        return bookmarks;
    }

    private static UserBookmark[] userBookmarks = new UserBookmark[TOTAL_USER_COUNT * USER_BOOKMARK_LIMIT];
    private static int bookmarkIndex;

    public static void loadData(){

        loadUsers();
        loadWebLinks();
        loadMovies();
        loadBooks();

    }




    private static void loadUsers(){
        users[0] = UserManager.getInstance().createUser(1000,"user0@semanticsquare.com","test",	"Don","M", Gender.MALE, UserType.USER);
        users[1] = UserManager.getInstance().createUser(1001,"user1@semanticsquare.com","test",	"Manu","M", Gender.FEMALE, UserType.USER);
        users[2] = UserManager.getInstance().createUser(1002,"user2@semanticsquare.com","test",	"Bhupesh","M", Gender.MALE, UserType.EDITOR);
        users[3] = UserManager.getInstance().createUser(1003,"user3@semanticsquare.com","test",	"Ayush","M", Gender.MALE, UserType.USER);
        users[4] = UserManager.getInstance().createUser(1004,"user4@semanticsquare.com","test",	"Rashika","M", Gender.FEMALE, UserType.CHIEF_EDITOR);
    }

    private static void loadWebLinks(){
        bookmarks[0][0] = BookmarkManagers.getInstance().createWebLink(2000,"Taming Tiger Part 2","http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html","http://www.javaworld.com");
        bookmarks[0][1] = BookmarkManagers.getInstance().createWebLink(2001,"How do I import a pre-existing Java project into Eclipse and get up and running?","http://stackoverflow.com/questions/142863/how-do-i-import-a-pre-existing-java-project-into-eclipse-and-get-up-and-running","http://www.stackoverflow.com");
        bookmarks[0][2] = BookmarkManagers.getInstance().createWebLink(2002,"Interface vs Abstract Class","http://mindprod.com/jgloss/interfacevsabstract.html\t","http://mindprod.com");
        bookmarks[0][3] = BookmarkManagers.getInstance().createWebLink(2003,"NIO tutorial by Greg Travis","http://cs.brown.edu/courses/cs161/papers/j-nio-ltr.pdf","http://cs.brown.edu");
        bookmarks[0][4] = BookmarkManagers.getInstance().createWebLink(2004,"IRON MAN 4","http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html","http://www.javaworld.com");
    }

    private static void loadMovies(){
        bookmarks[1][0] = BookmarkManagers.getInstance().createMovie(3000,"Citizen Kane","",1941,	new String[]{"Orson Welles","Joseph Cotten"},new String[] {"Orson Welles"} , MovieGenre.CLASSICS,8.5);
        bookmarks[1][1] = BookmarkManagers.getInstance().createMovie(3001,"The Avengers","",1941,	new String[]{"Orson Welles","Joseph Cotten"},new String[] {"Orson Welles"} , MovieGenre.CLASSICS,8.5);
        bookmarks[1][2] = BookmarkManagers.getInstance().createMovie(3002,"The Star Lord","",1941,	new String[]{"Orson Welles","Joseph Cotten"},new String[] {"Orson Welles"} , MovieGenre.CLASSICS,5);
        bookmarks[1][3] = BookmarkManagers.getInstance().createMovie(3003,"Kutu ma Kutu","",1941,	new String[]{"Orson Welles","Joseph Cotten"},new String[] {"Orson Welles"} , MovieGenre.CLASSICS,8.9);
        bookmarks[1][4] = BookmarkManagers.getInstance().createMovie(3004,"Iron Man","",1941,	new String[]{"Orson Welles","Joseph Cotten"},new String[] {"Orson Welles"} , MovieGenre.CLASSICS,9.5);


    }

    private static void loadBooks(){

        bookmarks[2][0] = BookmarkManagers.getInstance().createBook(4000,"Walden"	,1854,"Wilder Publications",new String[]{"Henry David" ,"Thoreau"}, BookGenre.PHILOSOPHY, 4.3);
        bookmarks[2][1] = BookmarkManagers.getInstance().createBook(4001,"Bhagwat Geeta"	,1854,"Byash rishi",new String[]{"byash rishi" ,"God"}, BookGenre.RELIGION, 4.3);
        bookmarks[2][2] = BookmarkManagers.getInstance().createBook(4002,"Dynamic meditation"	,1854,"Rajneesh",new String[]{"Osho"}, BookGenre.PHILOSOPHY, 5);
        bookmarks[2][3] = BookmarkManagers.getInstance().createBook(4003,"Walden"	,1854,"Wilder Publications",new String[]{"Henry" ,"Thoreau"}, BookGenre.PHILOSOPHY, 4.2);
        bookmarks[2][4] = BookmarkManagers.getInstance().createBook(4004,""	,1854,"Isha foundation",new String[]{"Maxwell" ,"Thoreau"}, BookGenre.ROMANCE, 4.3);

    }


    public static void add(UserBookmark userBookmark) {
        userBookmarks[bookmarkIndex] = userBookmark;
        bookmarkIndex++;
    }
}
