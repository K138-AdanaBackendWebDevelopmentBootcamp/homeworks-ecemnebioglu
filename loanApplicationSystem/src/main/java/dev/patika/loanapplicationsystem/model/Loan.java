package dev.patika.loanapplicationsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.*;
import javax.transaction.Transactional;

@Entity
@Table(name = "loan")

@Data
@NoArgsConstructor
@AllArgsConstructor
@Log4j2
@Builder
@Transactional
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loan_id")
    private Long loanId;
    @Column(name = "loan_amount")
    private double loanAmount;
    @Column(name = "loan_status")
    private String loanStatus;


    @OneToOne
    @JoinColumn(name = "idnumber", referencedColumnName = "id_number")
    @JsonIgnore
    private User user;


}
