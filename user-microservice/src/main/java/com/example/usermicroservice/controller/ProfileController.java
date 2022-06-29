package com.example.usermicroservice.controller;

import com.example.usermicroservice.model.Profile;
import com.example.usermicroservice.model.User;
import com.example.usermicroservice.resource.ProfileResource;
import com.example.usermicroservice.resource.SaveProfileResource;
import com.example.usermicroservice.resource.SaveUserResource;
import com.example.usermicroservice.resource.UserResource;
import com.example.usermicroservice.service.ProfileService;
import com.example.usermicroservice.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Tag(name="profiles")
@RestController
@RequestMapping("/api")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @Autowired
    private ModelMapper mapper;

    private Profile convertToEntity(SaveProfileResource resource){
        return mapper.map(resource, Profile.class);
    }
    private ProfileResource convertToResource(Profile entity){
        return mapper.map(entity, ProfileResource.class);
    }

    @GetMapping("/profiles")
    public Page<ProfileResource> getAllProfiles(Pageable pageable){
        Page<Profile> profiles = profileService.getAllProfiles(pageable);
        List<ProfileResource> resources = profiles.getContent().stream()
                .map(this::convertToResource).collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @PostMapping("/users/{userId}/profile")
    public ProfileResource createProfile(@PathVariable(name="userId") Long userId,
            @Valid @RequestBody SaveProfileResource resource) {
        Profile profile = convertToEntity(resource);
        return convertToResource(profileService.createProfile(userId,profile));
    }

    @GetMapping("/users/{userId}/profile")
    public ProfileResource getProfileByUserId(@PathVariable(name = "userId") Long userId) {
        return convertToResource(profileService.getProfileByUserId(userId));
    }

    @PutMapping("/profiles/{profileId}")
    public ProfileResource updateProfile(@PathVariable(name = "profileId") Long profileId,
                                         @Valid @RequestBody SaveProfileResource resource) {
        Profile profile = convertToEntity(resource);
        return convertToResource(profileService.updateProfile(profileId, profile));
    }

    @DeleteMapping("/profiles/{profileId}")
    public ResponseEntity<?> deleteProfile(@PathVariable(name = "profileId") Long profileId) {
        return profileService.deleteProfile(profileId);
    }
}
