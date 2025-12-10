package com.Book_My_Show.Repository;

import com.Book_My_Show.Models.TheaterSeat;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterSeatRepository extends JpaRepository<TheaterSeat, Integer> {
}
