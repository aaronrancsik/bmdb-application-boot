package com.example.bmdb.services;

import com.example.bmdb.models.Actor;
import com.example.bmdb.models.Media;
import com.example.bmdb.models.Review;
import com.example.bmdb.models.User;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.List;

@Component
public class MockLoader implements ApplicationRunner {

    private UserService userService;
    @Inject
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    private MediaService mediaService;
    @Inject
    public void setMediaService(MediaService mediaService) {
        this.mediaService = mediaService;
    }

    private ActorService actorService;
    @Inject
    public void setActorService(ActorService actorService) {
        this.actorService = actorService;
    }

    private ReviewService reviewService;
    @Inject
    public void setReviewService(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @Inject
    private List<Media> mediaList;

    @Inject
    private List<Actor> actorList;

    @Inject
    private List<Review> reviewList;

    @Inject
    private List<User> userList;

    @Override
    public void run(ApplicationArguments args){
        actorService.saveAll(actorList);
        mediaService.saveAll(mediaList);
        userService.saveAll(userList);
        reviewService.saveAll(reviewList);
    }
}
