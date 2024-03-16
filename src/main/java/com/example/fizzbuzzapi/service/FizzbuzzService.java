package com.example.fizzbuzzapi.service;

import com.example.fizzbuzzapi.exception.InformationExistException;
import com.example.fizzbuzzapi.exception.InformationNotFoundException;
import org.springframework.stereotype.Service;
import com.example.fizzbuzzapi.repository.FizzbuzzRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.example.fizzbuzzapi.model.Fizzbuzz;
import java.util.Optional;


@Service
public class FizzbuzzService {
    private FizzbuzzRepository fizzbuzzRepository;


    @Autowired
    public void setFizzbuzzRepository(FizzbuzzRepository fizzbuzzRepository) {
        this.fizzbuzzRepository = fizzbuzzRepository;
    }


    /**
     * This is a GET request that checks to see if the list of fizzbuzzes is empty before either throwing an InformationNotFoundException, or  returning the list of fizzbuzzes
     *
     * @return a list of all fizzbuzzes
     */
    public List<Fizzbuzz> getAllFizzbuzzes() {
        List<Fizzbuzz> fizzbuzzList = fizzbuzzRepository.findAll();

        if (fizzbuzzList.isEmpty()) {
            throw new InformationNotFoundException("no fizzbuzzes found");
        } else {
            return fizzbuzzList;
        }
    }


    /**
     * This is a GET request that checks to see if an individual fizzbuzz exists before either returning it, or throwing an InformationNotFoundException
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
     * This is a POST request that checks to see if a fizzbuzz already exists before either throwing an InformationExistException, or saving the newly created fizzbuzz to the repository
     *
     * @param fizzbuzzObject represents the new fizzbuzz the user is trying to create
     * @return newly created fizzbuzz
     */
    public Fizzbuzz createFizzbuzz(Fizzbuzz fizzbuzzObject) {
        Fizzbuzz fizzbuzz = fizzbuzzRepository.findByMessage(fizzbuzzObject.getMessage());

        if (fizzbuzz != null) {
            throw new InformationExistException("fizzbuzz with message " + fizzbuzzObject.getMessage() + " already exists");
        } else {
            fizzbuzzRepository.save(fizzbuzzObject);
            return fizzbuzzObject;
        }
    }

}
