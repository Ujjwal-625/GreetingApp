package com.bridgelabz.greetingapp.controller;

import com.bridgelabz.greetingapp.model.UserInfo;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello") // integrate all http methods
public class HelloController {
    @RequestMapping(value = {"", "/", "/home"})
    public String sayHello() {
        return "Hello !";
    }

    @GetMapping("/param/{name}")
    public String sayHello(@PathVariable("name") String name) {
        return "Hello "+name+ "!";
    }

    @PostMapping("/post")
    public String sayHello(@RequestBody UserInfo user) {
        return "Hello "+ user.getFirstName() + "!";
    }

    @PutMapping("/put/{firstname}")
    public String sayHelloput(@PathVariable String firstname,@RequestParam("lastname") String lastname) {
        return "Hello "+ firstname +" "+lastname +"!";
    }
}