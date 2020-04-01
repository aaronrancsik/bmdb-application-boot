package com.example.bmdb.models;

import org.springframework.stereotype.Component;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;
import java.util.stream.Collectors;


@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("mediaBase")
@NamedEntityGraph(name = "Media.detail",
        attributeNodes = {@NamedAttributeNode("reviews")})
public class Media {

    @Id
    @GeneratedValue
    protected long id;

    @Version
    private int version;

    protected String title;

    protected String description;

    @Temporal(TemporalType.DATE)
    protected Date premier;

    @OneToMany(mappedBy = "media", cascade = {CascadeType.ALL})
    protected Collection<com.example.bmdb.models.Review> reviews;

    //cascade = {CascadeType.ALL}
    @ManyToMany()
    @JoinTable
    protected Collection<com.example.bmdb.models.Actor> cast;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPremier() {
        return premier;
    }

    public void setPremier(Date premier) {
        this.premier = premier;
    }

    public Collection<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Collection<Review> reviews) {
        this.reviews = reviews;
    }

    public void addReview(Review review) {
        this.reviews.add(review);
    }

    public Collection<Actor> getCast() {
        return cast;
    }

    public void setCast(Collection<Actor> cast) {
        this.cast = cast;
    }

    public void addCast(Actor cast) {
        this.cast.add(cast);
    }

    @Override
    public String toString() {
        return "Media{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", premier=" + premier +
                ", reviews=" + reviews.stream().map(Objects::toString).collect(Collectors.joining(",")) +
                '}';
    }

    @Component
    public static class MediaBuilder {
        protected String title;
        protected String description;
        protected Date premier;
        protected Collection<Review> reviews;
        protected Collection<Actor> cast;

        private MediaBuilder() {
        }

        public static MediaBuilder aMedia() {
            return new MediaBuilder();
        }


        public MediaBuilder withTitle(String title) {
            this.title = title;
            return this;
        }

        public MediaBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public MediaBuilder withPremier(Date premier) {
            this.premier = premier;
            return this;
        }

        public MediaBuilder withReviews(Collection<Review> reviews) {
            this.reviews = reviews;
            return this;
        }

        public MediaBuilder addReview(Review review) {
            this.reviews.add(review);
            return this;
        }

        public MediaBuilder withCast(Collection<Actor> cast) {
            this.cast = cast;
            return this;
        }

        public MediaBuilder addCast(Actor cast) {
            this.cast.add(cast);
            return this;
        }

        public Media build() {
            Media media = new Media();
            media.setTitle(title);
            media.setDescription(description);
            media.setPremier(premier);
            media.setReviews(reviews);
            media.setCast(cast);
            return media;
        }
    }
}
