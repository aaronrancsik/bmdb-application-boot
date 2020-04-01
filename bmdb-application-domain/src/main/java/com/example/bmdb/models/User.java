package com.example.bmdb.models;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class User {

    @Id
    @GeneratedValue
    private long id;

    @Version
    private int version;


    private String name;

    @Column(unique=true)
    private  String email;

    private String password;

    @OneToMany(mappedBy = "creator", cascade = {CascadeType.ALL})
    private Collection<Review> reviews;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Collection<Review> reviews) {
        this.reviews = reviews;
    }

    @Component
    public static class UserBuilder {
        private String name;
        private  String email;
        private String password;
        private Collection<Review> reviews;

        private UserBuilder() {

        }

        public static UserBuilder anUser() {
            return new UserBuilder();
        }


        public UserBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder withPassword(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder withReviews(Collection<Review> reviews) {
            this.reviews = reviews;
            return this;
        }

        public UserBuilder addReview(Review review) {
            this.reviews.add(review);
            return this;
        }

        public User build() {
            User user = new User();
            user.setName(name);
            user.setEmail(email);
            user.setPassword(password);
            user.setReviews(reviews);
            return user;
        }

        @Override
        public String toString() {
            return "UserBuilder{" +
                    ", email='" + email + '\'' +
                    '}';
        }
    }
}
