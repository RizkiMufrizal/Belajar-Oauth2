package com.rizki.mufrizal.belajar.oauth2.controller;

import com.rizki.mufrizal.belajar.oauth2.domain.User;
import com.rizki.mufrizal.belajar.oauth2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = UserController.API)
public class UserController {

    public static final String API = "/api";
    public static final String USER = "/User";
    public static final String SAVE_USER = "/UserSave";
    public static final String UPDATE_USER = "/UserUpdate";
    public static final String DELETE_USER = "/UserDelete/{username}";

    @Autowired
    private UserService userService;

    @Secured({"ROLE_ADMIN"})
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = USER, method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<User> getUserList() {
        return userService.getUserList();
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = SAVE_USER, method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Map<String, Object> saveUser(@RequestBody User user) {
        userService.save(user);

        Map<String, Object> message = new HashMap<>();
        message.put("Success", Boolean.TRUE);
        message.put("Info", "Save Data Berhasil");

        return message;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = UPDATE_USER, method = RequestMethod.PUT, produces = {MediaType.APPLICATION_JSON_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Map<String, Object> updateUser(@RequestBody User user) {
        userService.update(user);

        Map<String, Object> message = new HashMap<>();
        message.put("Success", Boolean.TRUE);
        message.put("Info", "Update Data Berhasil");

        return message;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = DELETE_USER, method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Map<String, Object> deleteUser(@PathVariable("username") String username) {
        User user = userService.getUser(username);
        userService.delete(user);

        Map<String, Object> message = new HashMap<>();
        message.put("Success", Boolean.TRUE);
        message.put("Info", "Delete Data Berhasil");

        return message;
    }

}
