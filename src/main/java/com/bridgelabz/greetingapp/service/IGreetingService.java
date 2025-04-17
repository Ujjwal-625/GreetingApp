package com.bridgelabz.greetingapp.service;



import com.bridgelabz.greetingapp.model.Greeting;
import com.bridgelabz.greetingapp.model.User;

import java.util.List;

public interface IGreetingService {
    Greeting addGreeting(User user);
    Greeting getGreetingById(long id);
    List<Greeting> getAllGreeting();
    Greeting editMesssage(long id,String message);
    String deleteGreeting(long id);
}
