package com.Book_My_Show.Repository;

import com.Book_My_Show.Models.Movie;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.hibernate.sql.ast.tree.expression.JdbcParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MovieRepository extends JpaRepository<Movie,Integer> {

    Movie findMovieByMovieName(String movieName);

    @Query(value = "select * from movies where movie_name = :movieName", nativeQuery = true)
    Movie findMovie(String movieName);
}
