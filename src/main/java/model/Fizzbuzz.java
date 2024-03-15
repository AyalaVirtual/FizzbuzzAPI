package model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import javax.persistence.*;
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
    private String creation_date;

    @Column
    private String message;


    public Fizzbuzz() {
    }

    public Fizzbuzz(Long fizzbuzz_id, String useragent, String creation_date, String message) {
        this.fizzbuzz_id = fizzbuzz_id;
        this.useragent = useragent;
        this.creation_date = creation_date;
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

    public String getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(String creation_date) {
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
