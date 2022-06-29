package com.example.usermicroservice.resource;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfileResource {
    private Long id;
    private String firstNames;
    private String lastNames;
    private int cellphone;
    private String address;
    private String size;
    private Long userId;
}
