package com.things.vuestart.repository;

import com.things.vuestart.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListRepository extends JpaRepository<Board,Long> {
}
