package com.example.usermicroservice.service;

import com.example.usermicroservice.model.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface ProfileService {

    Profile createProfile(Long userId, Profile profile);
    Profile updateProfile(Long profileId, Profile profileRequest);
    ResponseEntity<?> deleteProfile(Long profileId);

    Page<Profile> getAllProfiles(Pageable pageable);

    Profile getProfileById(Long profileId);
    Profile getProfileByUserId(Long userId);
}
