package com.thrillio;

import com.thrillio.entities.Bookmark;
import com.thrillio.entities.User;
import com.thrillio.managers.BookmarkManagers;
import com.thrillio.managers.UserManager;

import static com.thrillio.DataStore.loadData;

public class Launch {

    private static User[] users;
    private static Bookmark[][] bookmarks;

    public static void loadData(){
        System.out.println("1. loading . . . . ");
        DataStore.loadData();

        users = UserManager.getInstance().getUsers();
        bookmarks = BookmarkManagers.getInstance().getBookmarks();

       // System.out.println("Printing data . . . ");
       // printUserData();
       // printBookmarkData();

    }

    private static void printBookmarkData() {
        for(Bookmark[] bookmarkList :bookmarks){
            for(Bookmark bookmark : bookmarkList){
                System.out.println(bookmark);
            }

        }
    }

    private static void printUserData(){
        for(User user: users){
            System.out.println(user);
        }
    }

    private static void start() {
       // System.out.println("1. Bookmarking . . . . ");

        for (User user: users){
            View.browse(user,bookmarks);
        }

    }

    public static void main(String[] args){
        loadData();
        start();
    }


}
