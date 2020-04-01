package com.example.bmdb.models;


import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@NamedEntityGraph(name = "sel",
        attributeNodes = {@NamedAttributeNode("filmography")})
public class Actor {

    @Id
    @GeneratedValue
    protected long id;

    @Version
    private int version;

    private String name;

    @Temporal(TemporalType.DATE)
    private Date born;

    private String biography;

    @Enumerated(EnumType.STRING)
    private Sex sex;

    @ManyToMany(mappedBy = "cast", cascade = {CascadeType.ALL})
    private Collection<Media> filmography;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBorn() {
        return born;
    }

    public void setBorn(Date born) {
        this.born = born;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Collection<Media> getFilmography() {
        return filmography;
    }

    public void setFilmography(Collection<Media> filmography) {
        this.filmography = filmography;
    }

    public void addFilmography(Media filmography) {
        this.filmography.add(filmography);
    }

    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                ", version=" + version +
                ", name='" + name + '\'' +
                ", born=" + born +
                ", biography='" + biography + '\'' +
                ", sex=" + sex +
                '}';
    }


    @Component
    public static class ActorBuilder {
        private String name;
        private Date born;
        private String biography;
        private Sex sex;
        private Collection<Media> filmography;

        public ActorBuilder() {
        }

        public static ActorBuilder anActor() {
            return new ActorBuilder();
        }


        public ActorBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public ActorBuilder withBorn(Date born) {
            this.born = born;
            return this;
        }

        public ActorBuilder withBiography(String biography) {
            this.biography = biography;
            return this;
        }

        public ActorBuilder withSex(Sex sex) {
            this.sex = sex;
            return this;
        }

        public ActorBuilder withFilmography(Collection<Media> filmography) {
            this.filmography = filmography;
            return this;
        }

        public ActorBuilder addFilmography(Media filmography) {
            this.filmography.add(filmography);
            return this;
        }

        public Actor build() {
            Actor actor = new Actor();
            actor.setName(name);
            actor.setBorn(born);
            actor.setBiography(biography);
            actor.setSex(sex);
            actor.setFilmography(filmography);
            return actor;
        }
    }
}
