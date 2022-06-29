package com.example.postmicroservice.repository;

import com.example.postmicroservice.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    Page<Post> findByUserId(Long userId, Pageable pageable);
    Page<Post> findBySellable(boolean sellable, Pageable pageable);
    Page<Post> findByUsersLiked(Long usersLikedId, Pageable pageable);

}
