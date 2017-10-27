package ru.atom.AuthServer;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.atom.Cache.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/")
/**
 *curl -i localhost:8080/
 **/
public class AuthServerController {

    Map<String, User> database = new HashMap<String, User>();
    private ArrayList<User> userlist = new ArrayList<User>();
    private final static org.apache.log4j.Logger log = org.apache.log4j.LogManager.getLogger(AuthServerController.class);

    /**
     *curl -i localhost:8080/registration
     **/
    @RequestMapping(
            path = "registration",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseStatus(HttpStatus.OK)

    public void registration(@RequestParam("Login") String login,
                             @RequestParam("Password") String password) {

        User user = new User(login, password);
        for (User list : userlist) {
            if (user.getNick().equals(list.getNick())) {
                log.info("User already registered");
            }
        }
        userlist.add(user);
        log.info("User has been registered");

    }

}
