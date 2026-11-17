package com.hcld2.jwtdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hcld2.jwtdemo.entity.Post;
import java.util.Optional;
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    Optional<Post> findById(Long id);
    
}
