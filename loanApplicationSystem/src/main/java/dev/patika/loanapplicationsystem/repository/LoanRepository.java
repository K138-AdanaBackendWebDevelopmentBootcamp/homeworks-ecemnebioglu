package dev.patika.loanapplicationsystem.repository;

import dev.patika.loanapplicationsystem.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {

    Loan findByUserIdNumber(Long idNumber);
}
