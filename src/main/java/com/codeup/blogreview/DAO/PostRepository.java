package com.codeup.blogreview.DAO;

import com.codeup.blogreview.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {



}
