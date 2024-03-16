package com.example.fizzbuzzapi.service;

import com.example.fizzbuzzapi.exception.InformationNotFoundException;
import org.springframework.stereotype.Service;
import com.example.fizzbuzzapi.repository.FizzbuzzRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.example.fizzbuzzapi.model.Fizzbuzz;
import java.util.Optional;
import java.util.Date;


@Service
public class FizzbuzzService {

    private FizzbuzzRepository fizzbuzzRepository;


    @Autowired
    public void setFizzbuzzRepository(FizzbuzzRepository fizzbuzzRepository) {
        this.fizzbuzzRepository = fizzbuzzRepository;
    }


    /**
     * This is a GET request that checks to see if the list of fizzbuzzes is empty before either throwing an InformationNotFoundException, or  returning the list of fizzbuzzes.
     *
     * @return a list of all fizzbuzzes
     */
    public List<Fizzbuzz> getAllFizzbuzzes() {
        List<Fizzbuzz> fizzbuzzList = fizzbuzzRepository.findAll();

        if (fizzbuzzList.isEmpty()) {
            throw new InformationNotFoundException("fizzbuzz list not found");
        } else {
            return fizzbuzzList;
        }
    }


    /**
     * This is a GET request that checks to see if an individual fizzbuzz exists before either returning it, or throwing an InformationNotFoundException.
     *
     * @param fizzbuzzId represents the id of the specific fizzbuzz the user is trying to get
     * @return fizzbuzz by id if it exists
     */
    public Optional<Fizzbuzz> getFizzbuzzById(Long fizzbuzzId) {
        Optional<Fizzbuzz> fizzbuzzOptional = fizzbuzzRepository.findById(fizzbuzzId);

        if (fizzbuzzOptional.isPresent()) {
            return fizzbuzzOptional;
        } else {
            throw new InformationNotFoundException("fizzbuzz with id " + fizzbuzzId + " not found");
        }
    }


    /**
     * This is a POST request that validates the input for the message and the user agent before setting the user agent, creation date, and message, and then saving the newly created fizzbuzz to the repository. Otherwise, if the message or user agent is null or empty, it will throw an IllegalArgumentException.
     *
     * @param fizzbuzzObject represents the new fizzbuzz object the user is trying to create
     * @param userAgent represents the user who created the fizzbuzz object
     */
//    public void createFizzbuzz(String message, String userAgent) {
    public void createFizzbuzz(Fizzbuzz fizzbuzzObject, String userAgent) {
        // This validates the input
        if (fizzbuzzObject.getMessage() == null || fizzbuzzObject.getMessage().isEmpty()) {
            throw new IllegalArgumentException("Message cannot be null or empty");
        } else if (userAgent == null || userAgent.isEmpty()) {
            throw new IllegalArgumentException("User agent cannot be null or empty");
        }

        Fizzbuzz fizzbuzz = new Fizzbuzz();
        fizzbuzz.setUserAgent(userAgent);
        fizzbuzz.setCreationDate(new Date());
        fizzbuzz.setMessage(fizzbuzzObject.getMessage());

        fizzbuzzRepository.save(fizzbuzz);
    }

}
