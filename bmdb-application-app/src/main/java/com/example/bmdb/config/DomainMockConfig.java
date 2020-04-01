package com.example.bmdb.config;

import com.example.bmdb.models.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import javax.inject.Inject;
import java.time.LocalDate;
import java.util.*;

@Configuration
public class DomainMockConfig {

    private Actor.ActorBuilder actorBuilder;
    @Inject
    public void setActorBuilder(Actor.ActorBuilder actorBuilder) {
        this.actorBuilder = actorBuilder;
    }

    private Media.MediaBuilder mediaBuilder;
    @Inject
    public void setMediaBuilder(Media.MediaBuilder mediaBuilder) {
        this.mediaBuilder = mediaBuilder;
    }

    private User.UserBuilder userBuilder;
    @Inject
    public void setUserBuilder(User.UserBuilder userBuilder) {
        this.userBuilder = userBuilder;
    }

    private Review.ReviewBuilder reviewBuilder;
    @Inject
    public void setReviewBuilder(Review.ReviewBuilder reviewBuilder) {
        this.reviewBuilder = reviewBuilder;
    }

    private Calendar cal = Calendar.getInstance();

    @Bean
    public Actor createActor0(){
        cal.set(1910, 1, 11);
        return actorBuilder
                .withName("Actor 1")
                .withBorn(cal.getTime())
                .withSex(Sex.MALE)
                .withBiography("Bio Bullshit 1")
                .withFilmography(new ArrayList<>())
                .build();
    }

    @Bean
    public Actor createActor1(){
        cal.set(1920, 2, 12);
        return actorBuilder
                .withName("Actor 2")
                .withBorn(cal.getTime())
                .withSex(Sex.FEMALE)
                .withBiography("Bio Bullshit 2")
                .withFilmography(new ArrayList<>())
                .build();
    }

    @Bean
    public Actor createActor2(){
        cal.set(1930, 3, 13);
        return actorBuilder
                .withName("Actor 3")
                .withBorn(cal.getTime())
                .withSex(Sex.FEMALE)
                .withBiography("Bio Bullshit 3")
                .withFilmography(new ArrayList<>())
                .build();
    }

    @Bean
    public Actor createActor3(){
        cal.set(1940, 4, 14);
        return actorBuilder
                .withName("Actor 4")
                .withBorn(cal.getTime())
                .withSex(Sex.FEMALE)
                .withBiography("Bio Bullshit 4")
                .build();
    }

    @Bean
    public Actor createActor4(){
        cal.set(1950, 5, 15);
        return actorBuilder
                .withName("Actor 5")
                .withBorn(cal.getTime())
                .withSex(Sex.MALE)
                .withBiography("Bio Bullshit 5")
                .build();
    }

    @Bean
    public Actor createActor5(){
        cal.set(1960, 6, 16);
        return actorBuilder
                .withName("Actor 6")
                .withBorn(cal.getTime())
                .withSex(Sex.FEMALE)
                .withBiography("Bio Bullshit 6")
                .build();
    }

    @Bean
    public Actor createActor6(){
        cal.set(1970, 7, 17);
        return actorBuilder
                .withName("Actor 7")
                .withBorn(cal.getTime())
                .withSex(Sex.MALE)
                .withBiography("Bio Bullshit 7")
                .build();
    }
    @Bean
    public Actor createActor7(){
        cal.set(1980, 8, 18);
        return actorBuilder
                .withName("Actor 8")
                .withBorn(cal.getTime())
                .withSex(Sex.FEMALE)
                .withBiography("Bio Bullshit 8")
                .build();
    }
    @Bean
    public Actor createActor8(){
        cal.set(1990, 9, 19);
        return actorBuilder
                .withName("Actor 9")
                .withBorn(cal.getTime())
                .withSex(Sex.MALE)
                .withBiography("Bio Bullshit 9")
                .build();
    }

    @Bean
    public Actor createActor9(){
        cal.set(2000, 10, 20);
        return actorBuilder
                .withName("Actor 10")
                .withBorn(cal.getTime())
                .withSex(Sex.FEMALE)
                .withBiography("Bio Bullshit 10")
                .build();
    }

    @Bean
    public Media createMedia0(){
        cal.set(2011,1,21);
        return mediaBuilder
                .withTitle("Movie 1")
                .withDescription("Super description 1")
                .withPremier(cal.getTime())
                .withCast(new ArrayList<>())
                .addCast(createActor0())
                .addCast(createActor1())
                .build();
    }

    @Bean
    public Media createMedia1(){
        cal.set(2011, 2, 22);
        return mediaBuilder
                .withTitle("Movie 2")
                .withDescription("Super description 2")
                .withPremier(cal.getTime())
                .withCast(new ArrayList<>())
                .addCast(createActor2())
                .addCast(createActor3())
                .build();
    }

    @Bean
    public Media createMedia2(){
        cal.set(2013, 3, 23);
        return mediaBuilder
                .withTitle("Movie 3")
                .withDescription("Super description 3")
                .withPremier(cal.getTime())
                .withCast(new ArrayList<>())
                .addCast(createActor4())
                .addCast(createActor5())
                .build();
    }

    @Bean
    public Media createMedia3(){
        cal.set(2014, 4, 24);
        return mediaBuilder
                .withTitle("Movie 4")
                .withDescription("Super description 4")
                .withPremier(cal.getTime())
                .withCast(new ArrayList<>())
                .addCast(createActor6())
                .addCast(createActor7())
                .build();
    }

    @Bean
    public Media createMedia4(){
        cal.set(2015, 5, 15);
        return mediaBuilder
                .withTitle("Movie 5")
                .withDescription("Super description 5")
                .withPremier(cal.getTime())
                .withCast(new ArrayList<>())
                .addCast(createActor8())
                .addCast(createActor9())
                .build();
    }

    @Bean
    public User createUser0() {
        return userBuilder
                .withName("Alma")
                .withEmail("alma@ealma.com")
                .withPassword("batman")
                .withReviews(new ArrayList<>())
                .build();
    }

    @Bean
    public User createUser1() {
        return userBuilder
                .withName("Banana")
                .withEmail("banan@banan.com")
                .withPassword("beethoven")
                .build();
    }

    @Bean
    public User createUser2() {
        return userBuilder
                .withName("Peel")
                .withEmail("peel@peel.com")
                .withPassword("brown")
                .build();
    }

    @Bean
    public Review createReview0(){
        return reviewBuilder
                .withText("rev 1")
                .withCreator(createUser0())
                .withCreator(createUser0())
                .withMedia(createMedia0())
                .withRating(Rating.GOOD)
                .build();
    }

    @Bean
    public Review createReview1(){
        return reviewBuilder
                .withText("rev 2")
                .withCreator(createUser0())
                .withMedia(createMedia1())
                .withRating(Rating.BAD)
                .build();
    }

    @Bean
    public Review createReview2(){
        return reviewBuilder
                .withText("rev 3")
                .withCreator(createUser1())
                .withMedia(createMedia2())
                .withRating(Rating.AVERAGE)
                .build();
    }

    @Bean
    public Review createReview3(){
        return reviewBuilder
                .withText("rev 4")
                .withCreator(createUser1())
                .withMedia(createMedia3())
                .withRating(Rating.GOOD)
                .build();
    }

    @Bean
    public Review createReview4(){
        return reviewBuilder
                .withText("rev 5")
                .withCreator(createUser2())
                .withMedia(createMedia4())
                .withRating(Rating.BAD)
                .build();
    }

    @Bean
    public Review createReview5(){
        return reviewBuilder
                .withText("rev 6")
                .withCreator(createUser2())
                .withMedia(createMedia4())
                .withRating(Rating.AVERAGE)
                .build();
    }


}
