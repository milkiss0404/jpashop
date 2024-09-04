package com.example.jpa.domain.item;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@DiscriminatorValue("M")//구분자? 같은거임
public class Movie extends Item{

    private String director;
    private String actor;
}
