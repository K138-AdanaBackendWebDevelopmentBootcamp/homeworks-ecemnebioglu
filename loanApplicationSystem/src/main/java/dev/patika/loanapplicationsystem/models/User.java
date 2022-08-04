package dev.patika.loanapplicationsystem.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user", uniqueConstraints = {@UniqueConstraint(columnNames = "email"), @UniqueConstraint(columnNames = "id_number")})
//for not using same email again

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "id_number")
    private Long idNumber;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "mobile")
    private String mobile;
    @Column(name = "monthly_income")
    private double monthlyIncome;

    @OneToMany
    private List<Transaction> transactions;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "users_loans",
            joinColumns = @JoinColumn(name = "id_number", referencedColumnName = "id_number"),
            inverseJoinColumns = {@JoinColumn(name = "loan_id", referencedColumnName = "id"), @JoinColumn(name = "loan_amount", referencedColumnName = "loan_amount")}

    )
    private List<Loan> loans;

}
