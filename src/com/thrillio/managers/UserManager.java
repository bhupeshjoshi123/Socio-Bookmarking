package com.thrillio.managers;

import com.semanticsquare.thrillio.constants.Gender;
import com.semanticsquare.thrillio.constants.UserType;
import com.thrillio.dao.UserDao;
import com.thrillio.entities.User;

public class UserManager {
    private static UserManager instance = new UserManager();
    private static UserDao dao = new UserDao();
    //Singeleton pattern

    private UserManager(){

    }

    public static UserManager getInstance(){
        return instance;
    }

    public User createUser(long id, String email, String password,String firstName,String lastName,Gender gender,UserType userType){

        User user = new User();

        user.setId(id);
        user.setEmail(email);
        user.setPassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setGender(gender);
        user.setUserType(userType);

        return user;
    }
    public User[] getUsers(){
        return dao.getUsers();
    }
}
