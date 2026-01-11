package com.example.BerlinerKollektivRanking.Repository;

import com.example.BerlinerKollektivRanking.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
