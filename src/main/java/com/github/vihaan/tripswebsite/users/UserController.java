package com.github.vihaan.tripswebsite.users;

import com.github.vihaan.tripswebsite.controller.IControllersStrings;
import com.github.vihaan.tripswebsite.httpstatus.HttpStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.github.vihaan.tripswebsite.controller.IControllersStrings;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(IControllersStrings.USERS_MAPPING)
public class UserController {

    private UserRepositoriesFacade userRepositoriesFacade;

    @Autowired
    public UserController(UserRepositoriesFacade userRepositoriesFacade){
        this.userRepositoriesFacade = userRepositoriesFacade;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserDTO>> getAllUsers(){
            List<UserDTO> users = userRepositoriesFacade.getAllUserDtos();
        return ResponseEntity.ok(users);
    }

    @GetMapping(path = IControllersStrings.USERNAME_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> getUser(@PathVariable String username){
        return ResponseEntity.of(userRepositoriesFacade.getUserDtoByUsername(username));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addUser(Model model, @RequestParam UserDTO userDTO){
        HttpStatusEnum status = HttpStatusEnum.OK;
        return new ResponseEntity<>(status.getResponse());
    }
}
