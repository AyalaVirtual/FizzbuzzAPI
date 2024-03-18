package com.example.fizzbuzzapi.controller;

import com.example.fizzbuzzapi.model.Fizzbuzz;
import org.springframework.web.bind.annotation.*;
import com.example.fizzbuzzapi.service.FizzbuzzService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;


@RestController
@RequestMapping("/api/") // http://localhost:9092/api
public class FizzbuzzController {
    private FizzbuzzService fizzbuzzService;

    HashMap<String, Object> result = new HashMap<>();
    HashMap<String, Object> message = new HashMap<>();


    @Autowired
    public void setFizzbuzzService(FizzbuzzService fizzbuzzService) {
        this.fizzbuzzService = fizzbuzzService;
    }


    /**
     * This sets the path for GET requests for all fizzbuzzes and checks if the list of fizzbuzzes is empty or not before deciding whether to send an HTTP status message of OK or NOT FOUND.
     *
     * @return the HTTP status message
     */
    @GetMapping(path="/fizzbuzz/")
    public ResponseEntity<?> getAllFizzbuzzes() {
        List<Fizzbuzz> fizzbuzzList = fizzbuzzService.getAllFizzbuzzes();

        if (fizzbuzzList.isEmpty()) {
            message.put("message", "fizzbuzz list not found");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        } else {
            message.put("message", "success");
            message.put("data", fizzbuzzList);
            return new ResponseEntity<>(message, HttpStatus.OK);
        }
    }


    /**
     * This sets the path for GET requests for an individual fizzbuzz and checks if the fizzbuzz exists or not before deciding whether to send an HTTP status message of OK or NOT FOUND.
     *
     * @param fizzbuzzId represents the id of the specific fizzbuzz the user is trying to get
     * @return the HTTP status message
     */
    @GetMapping(path="/fizzbuzz/{fizzbuzzId}/")
    public ResponseEntity<?> getFizzbuzzById(@PathVariable(value="fizzbuzzId") Long fizzbuzzId) {
        Optional<Fizzbuzz> fizzbuzzOptional = fizzbuzzService.getFizzbuzzById(fizzbuzzId);

        if (fizzbuzzOptional.isPresent()) {
            message.put("message", "success");
            message.put("data", fizzbuzzOptional);
            return new ResponseEntity<>(message, HttpStatus.OK);
        } else {
            message.put("message", "fizzbuzz with id " + fizzbuzzId + " not found");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }


    /**
     * This sets the path for POST requests for a new fizzbuzz and  before sending an HTTP status message of CREATED.
     *
     * @param fizzbuzzObject represents the new fizzbuzz object the user is trying to create
     * @param request represents the HTTP servlet request containing additional request information
     * @return the HTTP status message as "CREATED" if the fizzbuzz object is created successfully
     */
    @PostMapping(path="/fizzbuzz/")
    public ResponseEntity<?> createFizzbuzz(@RequestBody Fizzbuzz fizzbuzzObject, HttpServletRequest request) {
        // This retrieves the user agent from the request headers
        String userAgent = request.getHeader("User-Agent");

        // This creates the fizzbuzz object with the new fizzbuzz object that the user is trying to create and the user agent from the request headers
        fizzbuzzService.createFizzbuzz(fizzbuzzObject, userAgent);

        // This constructs the response body with a success message
        HashMap<String, String> responseBody = new HashMap<>();
        responseBody.put("message", "success");

        return ResponseEntity.status(HttpStatus.CREATED).body(responseBody);
    }

}