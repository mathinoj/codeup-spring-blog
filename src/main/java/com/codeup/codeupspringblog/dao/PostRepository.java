package com.codeup.codeupspringblog.dao;

import com.codeup.codeupspringblog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
    //what type of object(Post) its being a repository for and what data type(Long) the id colomn will be = (<Post, Long>). <-this is called object relational mapping. We create an object in such a way that they relate to an object in the database.
//    Post findPostById(long id);
}
