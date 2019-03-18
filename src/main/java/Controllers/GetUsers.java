package Controllers;

import Models.User;
import Repositories.UserRepository;
import Services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class GetUsers{

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity getUsers() {
        List<User> users = UserRepository.getUsers();
        if(users.size() != 0)
            return ResponseEntity.ok(users);
        else
            return new ResponseEntity<>("Couldn't fetch user list from database!",HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public ResponseEntity getUser(@PathVariable String id) {
        User user = UserService.findUserWithID(id);
        if(user != null)
            return ResponseEntity.ok(user);
        else
            return new ResponseEntity<>("User not found with this ID!", HttpStatus.NOT_FOUND);
    }
}
