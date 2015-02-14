package com.rizki.mufrizal.belajar.oauth2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api")
public class HelloController {

    private static final String STATE = "state";

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public Map<String, Object> hello() {
        Map<String, Object> message = new HashMap<>();
        message.put("Success", Boolean.TRUE);
        message.put("Info", "Hello Word");

        return message;
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public Map<String, Object> admin(Principal principal) {
        Map<String, Object> message = new HashMap<>();
        message.put("Success", Boolean.TRUE);
        message.put("User", principal.getName());

        return message;
    }

    @RequestMapping("/state/new")
    public Map<String, Object> newState(HttpSession session) {
        Map<String, Object> hasil = new HashMap<>();
        hasil.put("sukses", Boolean.TRUE);

        String state = UUID.randomUUID().toString();
        hasil.put(STATE, state);
        session.setAttribute(STATE, state);

        return hasil;
    }

}
