package dev.patika.loanapplicationsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "loan")

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loan_id")
    private Long loanId;
    @Column(name = "loan_amount")
    private double loanAmount;
    @Column(name = "loan_status")
    private String loanStatus;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_number", referencedColumnName = "id_number")
    @JsonIgnore
    private User user;


}
