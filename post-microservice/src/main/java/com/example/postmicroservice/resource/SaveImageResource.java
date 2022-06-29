package com.example.postmicroservice.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class SaveImageResource {

    @NotNull
    @NotBlank
    private String name;
    @NotNull
    @NotBlank
    private String extension;
    @NotNull
    @NotBlank
    private String content;
}
