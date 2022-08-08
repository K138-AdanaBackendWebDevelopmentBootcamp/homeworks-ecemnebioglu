package dev.patika.loanapplicationsystem.repository;

import dev.patika.loanapplicationsystem.model.Loan;
import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
    @Query("SELECT idNumber FROM User" )
    Loan findByIdNumber(Long idNumber);
}
