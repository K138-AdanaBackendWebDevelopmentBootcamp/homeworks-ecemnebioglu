package dev.patika.loanapplicationsystem.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.extern.log4j.Log4j2;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.transaction.Transactional;

@Entity
@Table(name = "user", uniqueConstraints = {@UniqueConstraint(columnNames = "email"), @UniqueConstraint(columnNames = "id_number")})
//for not using the same email and id number again
//add exception

@Data
@NoArgsConstructor
@AllArgsConstructor
@Transactional
@Log4j2
@Builder
@Getter
@Setter
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

    @OneToOne(fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn(name = "id_number")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private Loan loan;

    public User(Long idNumber, String firstName, String lastName, String email, String mobile, double monthlyIncome) {
        this.idNumber = idNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobile = mobile;
        this.monthlyIncome = monthlyIncome;
    }

    public User(Long idNumber, double monthlyIncome) {
        this.idNumber = idNumber;
        this.monthlyIncome= monthlyIncome;
    }
}
