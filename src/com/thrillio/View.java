package com.thrillio;

import com.thrillio.constants.KidFriendlyStatus;
import com.thrillio.constants.UserType;
import com.thrillio.controllers.BookmarkController;
import com.thrillio.dao.BookmarkDao;
import com.thrillio.entities.Bookmark;
import com.thrillio.entities.User;
import com.thrillio.partner.Shareable;

public class View {
    public static void browse(User user, Bookmark[][] bookmarks){
        System.out.println("\n"+user.getEmail()+"\tis browseing items . . . ");

        int bookmarkCount = 0;

        for(Bookmark[] bookmarkList : bookmarks){
            for(Bookmark bookmark : bookmarkList){
                if(bookmarkCount< DataStore.USER_BOOKMARK_LIMIT){
                   boolean isBookmarked = getBookmarkDecision(bookmark);

                   if(isBookmarked){
                      bookmarkCount++;

                      BookmarkController.getInstance().saveUserBookmark(user,bookmark);

                      System.out.println("New Item Bookmarked\t"+ bookmark);
                   }
                }

                if(user.getUserType().equals(UserType.EDITOR) || user.getUserType().equals(UserType.CHIEF_EDITOR)){
                    //mark as kid friendly
                    if(bookmark.IsKidFriendlyEligible() && bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.UNKNOWN)){
                         KidFriendlyStatus kidFriendlyStatus = getKidFriendlyStatusDecision(bookmark);

                        if(!kidFriendlyStatus.equals(KidFriendlyStatus.UNKNOWN)){
                            BookmarkController.getInstance().setKidFriendlyStatus(user,kidFriendlyStatus,bookmark);

                        }
                    }
                    if(bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.APPROVED) && bookmark instanceof Shareable){
                        getShareDecision();
                        boolean isShared = getShareDecision();
                        if(isShared){
                            BookmarkController.getInstance().share(user,bookmark);
                        }
                    }
                }
            }
        }


    }

    private static boolean getShareDecision() {
        return Math.random()<0.5? true : false;

    }

    private static String getKidFriendlyStatusDecision(Bookmark bookmark) {
        return Math.random()<0.4? KidFriendlyStatus.APPROVED:(Math.random() >= 0.4 && Math.random()<0.8 ? KidFriendlyStatus.RJECTED:KidFriendlyStatus.UNKNOWN);
    }

    private static boolean getBookmarkDecision(Bookmark bookmark) {
        return Math.random()<0.5? true : false;
    }
}
