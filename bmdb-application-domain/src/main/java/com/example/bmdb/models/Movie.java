package com.example.bmdb.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("MovieType")
public class Movie extends Media {

}
