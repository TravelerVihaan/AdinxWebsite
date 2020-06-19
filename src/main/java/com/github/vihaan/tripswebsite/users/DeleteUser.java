package com.github.vihaan.tripswebsite.users;

import com.github.vihaan.tripswebsite.httpstatus.HttpStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;

public class DeleteUser {

    private UserRepositoriesFacade userRepositoriesFacade;

    @Autowired
    public DeleteUser(UserRepositoriesFacade userRepositoriesFacade) {
        this.userRepositoriesFacade = userRepositoriesFacade;
    }

    HttpStatusEnum deleteUser(String username){
        userRepositoriesFacade
                .getUserByUsername(username)
                .ifPresentOrElse(
                        u -> userRepositoriesFacade.deleteUser(u),
                        //TODO httpstatus
                        () -> System.out.println("Not deleted")
                 );
    return HttpStatusEnum.OK;
    }
}
