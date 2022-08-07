package dev.patika.loanapplicationsystem.repository;

import dev.patika.loanapplicationsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByIdNumber(Long idNumber);

    void deleteByIdNumber(Long idNumber);
}
