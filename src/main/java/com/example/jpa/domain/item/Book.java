package com.example.jpa.domain.item;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@DiscriminatorValue("B") //구분자? 같은거임
public class Book extends Item {

    private String author;
    private String isbn;
}
