package com.bridgelabz.greetingapp.service;

import com.bridgelabz.greetingapp.model.Greeting;
import com.bridgelabz.greetingapp.model.User;
import com.bridgelabz.greetingapp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service

public class GreetingServiceImpl implements IGreetingService {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private GreetingRepository greetingRepository;

    public void setGreetingRepository(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @Override
    public Greeting addGreeting (User user) {
        String fullName = "";

        if (user.getFirstName() != null && !user.getFirstName().isEmpty()) {
            fullName += user.getFirstName();
        }

        if (user.getLastName() != null && !user.getLastName().isEmpty()) {
            if (!fullName.isEmpty()) {
                fullName += " ";
            }
            fullName += user.getLastName();
        }
        String message = String.format(template, (user.toString().isEmpty()) ? "Hello World": fullName);
        return greetingRepository.save(new Greeting (counter.incrementAndGet(), message));
    }

    @Override
    public Greeting getGreetingById(long id) {
        return greetingRepository.findById(id).get();
    }

    @Override
    public List<Greeting> getAllGreeting(){
        return greetingRepository.findAll();
    }

    @Override
    public Greeting editMesssage(long id,String message){
        try {
        Greeting greeting=greetingRepository.findById(id).get();
        greeting.setMessage(message);
        greetingRepository.save(greeting);
        return greeting;
        }
        catch (Exception e){
            return null;
        }
    }

    @Override
    public String deleteGreeting(long id){
        try{
        greetingRepository.deleteById(id);
        return "Given Id deleted Succesfully";
        }
        catch (Exception e){
            return "Can't Delete the given id";
        }

    }

}