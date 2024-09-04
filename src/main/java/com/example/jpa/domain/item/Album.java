package com.example.jpa.domain.item;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@DiscriminatorValue("A") //구분자? 같은거임
public class Album extends Item{
    private String artist;
    private String etc;
}
