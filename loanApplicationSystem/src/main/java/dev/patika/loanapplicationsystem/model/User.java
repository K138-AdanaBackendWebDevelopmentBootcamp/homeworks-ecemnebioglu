package dev.patika.loanapplicationsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "user", uniqueConstraints = {@UniqueConstraint(columnNames = "email"), @UniqueConstraint(columnNames = "id_number")})
//for not using the same email and id number again
//add exception

@Data
@NoArgsConstructor
@AllArgsConstructor
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "users_loans",
            joinColumns = @JoinColumn(name = "id_number", referencedColumnName = "id_number"),
            inverseJoinColumns = {@JoinColumn(name = "loan_id", referencedColumnName = "loan_id"), @JoinColumn(name = "loan_amount", referencedColumnName = "loan_amount")}
    )
    private Collection<Loan> loans;

    public User(Long idNumber, String firstName, String lastName, String email, String mobile, double monthlyIncome) {
        this.idNumber = idNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobile = mobile;
        this.monthlyIncome = monthlyIncome;
    }
}
