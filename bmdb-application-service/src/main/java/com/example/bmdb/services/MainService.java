package com.example.bmdb.services;


import com.example.bmdb.models.*;

import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class MainService {

    private ReviewService reviewService;
    @Inject
    public void setReviewService(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

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

    private Review.ReviewBuilder reviewBuilder;
    @Inject
    public void setReviewBuilder(Review.ReviewBuilder reviewBuilder) {
        this.reviewBuilder = reviewBuilder;
    }

    public void doReview(String email, String pass, long mediaId, String reviewText, Rating rating){
        Media media = mediaService.findById(mediaId);

        Review review = reviewBuilder
                .withText(reviewText)
                .withRating(rating)
                .withMedia(media)
                .withCreator(userService.findUser(email,pass))
                .build();
        media.addReview(review);
        reviewService.save(review);
        mediaService.save(media);
    }
}
