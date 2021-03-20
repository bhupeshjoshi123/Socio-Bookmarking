package com.thrillio.controllers;

import com.thrillio.entities.Bookmark;
import com.thrillio.entities.User;
import com.thrillio.managers.BookmarkManagers;

public class BookmarkController {
    private static BookmarkController instance = new BookmarkController();
    private BookmarkController(){

    }

    public static BookmarkController getInstance(){
        return instance;
    }
//passing data to the Model(managers)
    public void saveUserBookmark(User user, Bookmark bookmark) {
        BookmarkManagers.getInstance().saveUserBookmark(user,bookmark);
    }

    public void setKidFriendlyStatus(User user, String kidFriendlyStatus, Bookmark bookmark) {
        BookmarkManagers.getInstance().setKidFriendlyStatus(user,kidFriendlyStatus,bookmark);

    }

    public void share(User user, Bookmark bookmark) {
        BookmarkManagers.getInstance().share(user,bookmark);
    }
}
