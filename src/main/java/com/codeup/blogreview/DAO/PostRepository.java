package com.codeup.blogreview.DAO;

import com.codeup.blogreview.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface PostRepository extends JpaRepository<Post, Long> {
    @Query("from Post as a where a.title like %:term% or a.description like %:term%")
    List<Post> searchByTitle(@Param("term") String term);

    Post findFirstByTitle(String title);

    Post findByTitle(String post_to_be_deleted);
}



