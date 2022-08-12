package dev.patika.loanapplicationsystem.repository;

import dev.patika.loanapplicationsystem.model.User;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByIdNumber(Long idNumber);

    void deleteByIdNumber(Long idNumber);

    List<User> findById(Optional<Long> id);
}
