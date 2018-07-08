package pl.sda.restexample.web;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

@Entity
@Data
//@NoArgsConstructor
@AllArgsConstructor

public class Post {

    @Id
    @GeneratedValue
    private long id;
    private String title;
    private String message;

    public Post(String title, String message) {
        this.title = title;
        this.message = message;
    }
}
