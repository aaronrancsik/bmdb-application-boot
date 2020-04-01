package com.example.bmdb.models;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@DiscriminatorValue("ReviewType")
public class Review {
    @Id
    @GeneratedValue
    private long id;

    @Version
    private int version;

    private String text;

    @ManyToOne
    private com.example.bmdb.models.Media media;

    @ManyToOne
    private com.example.bmdb.models.User creator;

    @Enumerated(EnumType.STRING)
    private com.example.bmdb.models.Rating rating;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", version=" + version +
                ", text='" + text + '\'' +
                ", creator=" + creator.getEmail() +
                ", rating=" + rating +
                '}';
    }

    @Component
    public static class ReviewBuilder {
        private String text;
        private Media media;
        private User creator;
        private Rating rating;

        private ReviewBuilder() {
        }

        public static ReviewBuilder aReview() {
            return new ReviewBuilder();
        }


        public ReviewBuilder withText(String text) {
            this.text = text;
            return this;
        }

        public ReviewBuilder withMedia(Media media) {
            this.media = media;
            return this;
        }

        public ReviewBuilder withCreator(User creator) {
            this.creator = creator;
            return this;
        }

        public ReviewBuilder withRating(Rating rating) {
            this.rating = rating;
            return this;
        }

        public Review build() {
            Review review = new Review();
            review.setText(text);
            review.setMedia(media);
            review.setCreator(creator);
            review.setRating(rating);
            return review;
        }
    }
}
