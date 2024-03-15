package com.example.fizzbuzzapi.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="fizzbuzz")
public class Fizzbuzz {

    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long fizzbuzzId;

    @Column
    private String userAgent;

    @Column
    private Date creationDate;

    @Column
    private String message;


    public Fizzbuzz() {
    }

    public Fizzbuzz(Long fizzbuzzId, String userAgent, String creationDate, String message) {
        this.fizzbuzzId = fizzbuzzId;
        this.userAgent = userAgent;
        // this initializes the creationDate field to the current date/time when a new FizzBuzz object is created.
        this.creationDate = new Date();
        this.message = message;
    }


    public Long getFizzbuzzId() {
        return fizzbuzzId;
    }

    public void setFizzbuzzId(Long fizzbuzzId) {
        this.fizzbuzzId = fizzbuzzId;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public Date getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    @Override
    public String toString() {
        return "Fizzbuzz{" +
                "fizzbuzzId=" + fizzbuzzId +
                ", userAgent='" + userAgent + '\'' +
                ", creationDate='" + creationDate + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
