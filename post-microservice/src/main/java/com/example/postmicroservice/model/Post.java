package com.example.postmicroservice.model;

import com.example.postmicroservice.resource.UserResource;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="posts")
@Getter
@Setter
public class Post extends Audit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description; //default 255
    private boolean sellable;
    private double price;
    private int stock;

    @Column(length = 50)
    private String size;

    private Long userId;

    @ElementCollection
    private List<Long> usersLiked;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name="taggables",
            joinColumns = {@JoinColumn(name="post_id")},
            inverseJoinColumns = {@JoinColumn(name = "tag_id")})
    @JsonIgnore
    private List<Tag> tags;

    //1 univ tiene muchos periodos
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "post")
    private List<Image> images;
}