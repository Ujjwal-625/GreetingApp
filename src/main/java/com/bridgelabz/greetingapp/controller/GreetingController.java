package com.bridgelabz.greetingapp.controller;


import com.bridgelabz.greetingapp.model.Greeting;
import com.bridgelabz.greetingapp.model.User;
import com.bridgelabz.greetingapp.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//@RestController // controller and response body aggregation of RestController
@RestController
@RequestMapping("/greetings")
public class GreetingController {
    @Autowired
    private IGreetingService greetingService;


    @GetMapping("")
    public Greeting greetfirstLastName(@RequestParam(required = false) String firstname,@RequestParam (required = false) String lastname) {
        User user=new User();
        if(firstname!=null){
            user.setFirstName(firstname);
        }
        if(lastname!=null){
            user.setLastName(lastname);
        }
        Greeting greet= greetingService.addGreeting(user);
        return greet;
    }
    @GetMapping("/{id}")
    public Greeting getGreeting(@PathVariable("id") String greetingId ){
        long id=Long.parseLong(greetingId);
        try{
            return greetingService.getGreetingById(id);
        } catch (Exception e) {
            return null;
        }
    }
    @GetMapping("/getall")
    public List<Greeting> getAllGreeting(){
        return greetingService.getAllGreeting();
    }
        @PutMapping("/edit")
        public Greeting editMessage(@RequestBody EditRequest request) {
            long id=Long.parseLong(request.getId());
            String message=request.getMessage();
            return greetingService.editMesssage(id,message);

        }

        // ✅ static nested class
        public static class EditRequest {
            private String id;
            private String message;

            // ✅ Default constructor
            public EditRequest() {}

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getMessage() {
                return message;
            }

            public void setMessage(String message) {
                this.message = message;
            }
        }

    @DeleteMapping("/{id}")
    public String deleteGreet(@PathVariable("id") String greetId){
        long id=Long.parseLong(greetId);
        return greetingService.deleteGreeting(id);
    }
}
