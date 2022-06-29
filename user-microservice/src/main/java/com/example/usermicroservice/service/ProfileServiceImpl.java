package com.example.usermicroservice.service;

import com.example.usermicroservice.exception.ResourceNotFoundException;
import com.example.usermicroservice.model.Profile;
import com.example.usermicroservice.repository.ProfileRepository;
import com.example.usermicroservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileServiceImpl implements ProfileService{

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Profile createProfile(Long userId, Profile profile) {
        return userRepository.findById(userId).map(user->{
            profile.setUser(user);
            return profileRepository.save(profile);
        }).orElseThrow(()->new ResourceNotFoundException("User", "Id", userId));
    }

    @Override
    public Page<Profile> getAllProfiles(Pageable pageable) {
        return profileRepository.findAll(pageable);
    }

    @Override
    public Profile getProfileById(Long profileId) {
        return profileRepository.findById(profileId)
                .orElseThrow(()->new ResourceNotFoundException("Profile", "Id", profileId));
    }

    @Override
    public Profile getProfileByUserId(Long userId){
        return profileRepository.findByUserId(userId)
                .orElseThrow(()->new ResourceNotFoundException("User", "Id", userId));
    }

    @Override
    public Profile updateProfile(Long profileId, Profile profileRequest) {
        Profile profile = getProfileById(profileId);
        profile.setFirstNames(profileRequest.getFirstNames());
        profile.setLastNames(profileRequest.getLastNames());
        profile.setAddress(profileRequest.getAddress());
        profile.setCellphone(profileRequest.getCellphone());
        profile.setSize(profileRequest.getSize());
        return profileRepository.save(profile);
    }

    @Override
    public ResponseEntity<?> deleteProfile(Long profileId) {
        Profile profile = getProfileById(profileId);
        profileRepository.delete(profile);
        return ResponseEntity.ok().build();
    }


}
