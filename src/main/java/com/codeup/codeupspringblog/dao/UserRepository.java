package com.codeup.codeupspringblog.dao;

import com.codeup.codeupspringblog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserById(long id);
    // By default this would return a Optional<User> object
    // By writing it myself, it returns a User ins
    @Query("from User u where u.id = :userId")
    User findUserByHisHerNumber(@Param("userId") long userId);
}
