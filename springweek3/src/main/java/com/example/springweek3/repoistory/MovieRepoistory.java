package com.example.springweek3.repoistory;

import com.example.springweek3.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepoistory extends JpaRepository<Movie,Integer> {

}
