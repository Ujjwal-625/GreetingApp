package com.bridgelabz.greetingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.bridgelabz.greetingapp.model.Greeting;
import org.springframework.stereotype.Repository;

@Repository
public interface GreetingRepository extends JpaRepository<Greeting,Long> {

}
