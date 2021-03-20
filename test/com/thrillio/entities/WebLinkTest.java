package com.thrillio.entities;

import com.thrillio.managers.BookmarkManagers;
import org.junit.Test;

import static org.junit.Assert.*;

public class WebLinkTest {
//TDD approach (Test driven approach)
    @Test
    public void testIsKidFriendlyEligible(){
        //test 1
        WebLink webLink = BookmarkManagers.getInstance().createWebLink(2000,"Taming Tiger Part 2","http://www.javaworld.com/article/2072759/core-porn/taming-tiger--part-2.html","http://www.javaworld.com");
        boolean isKidFriendlyEligible = webLink.IsKidFriendlyEligible();

        assertFalse("For porn in URL - isKidFriendlyEligible() must return false",isKidFriendlyEligible);
        //test 2

        //test 3

        //test 4

    }

}