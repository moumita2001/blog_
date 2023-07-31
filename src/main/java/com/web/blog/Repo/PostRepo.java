package com.web.blog.Repo;

import com.web.blog.model.Post;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface PostRepo extends JpaRepository<Post,Long> {
    List<Post> findByUserId(Long userId);
   // List<Post> findByUsername(String user_name);

    @Transactional
    void deleteByUserId(long userId);

}
