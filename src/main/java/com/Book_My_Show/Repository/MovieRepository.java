package com.Book_My_Show.Repository;

import com.Book_My_Show.Models.Movie;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.hibernate.sql.ast.tree.expression.JdbcParameter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Integer> {
}
