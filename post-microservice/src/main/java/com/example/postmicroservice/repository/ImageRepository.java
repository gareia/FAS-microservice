package com.example.postmicroservice.repository;

import com.example.postmicroservice.model.Image;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
    Page<Image> findByPostId(Long postId, Pageable pageable);
}
