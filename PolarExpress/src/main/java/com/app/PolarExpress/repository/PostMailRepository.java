package com.app.PolarExpress.repository;

import com.app.PolarExpress.entity.PostMail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostMailRepository extends JpaRepository<PostMail, Integer> {
    Optional<PostMail> findById(Integer id);
}
