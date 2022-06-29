package com.example.postmicroservice.resource;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImageResource {
    private Long id;
    private Long postId;
    private String name;
    private String extension;
    private String content;
}
