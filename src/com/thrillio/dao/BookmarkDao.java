package com.thrillio.dao;

import com.thrillio.DataStore;
import com.thrillio.entities.Bookmark;
import com.thrillio.entities.UserBookmark;

//for sql queries

public class BookmarkDao {
    public Bookmark[][] getBookmarks(){
        return DataStore.getBookmarks();
    }

    //Placr of sql for saving in database
    public void saveUserBookmark(UserBookmark userBookmark) {
        DataStore.add(userBookmark);
    }
}
