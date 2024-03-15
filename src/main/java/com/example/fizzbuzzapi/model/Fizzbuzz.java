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
    private Long fizzbuzz_id;

    @Column
    private String useragent;

    @Column
    private Date creation_date;

    @Column
    private String message;


    public Fizzbuzz() {
    }

    public Fizzbuzz(Long fizzbuzz_id, String useragent, String creation_date, String message) {
        this.fizzbuzz_id = fizzbuzz_id;
        this.useragent = useragent;
        // this initializes the creationDate field to the current date/time when a new FizzBuzz object is created.
        this.creation_date = new Date();
        this.message = message;
    }


    public Long getFizzbuzz_id() {
        return fizzbuzz_id;
    }

    public void setFizzbuzz_id(Long fizzbuzz_id) {
        this.fizzbuzz_id = fizzbuzz_id;
    }

    public String getUseragent() {
        return useragent;
    }

    public void setUseragent(String useragent) {
        this.useragent = useragent;
    }

    public Date getCreation_date() {
        return this.creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
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
                "fizzbuzz_id=" + fizzbuzz_id +
                ", useragent='" + useragent + '\'' +
                ", creation_date='" + creation_date + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
