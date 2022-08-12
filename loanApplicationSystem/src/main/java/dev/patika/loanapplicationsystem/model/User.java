package dev.patika.loanapplicationsystem.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(value = "User object")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "User object id")
    private Long id;
    @Column(name = "id_number")
    @ApiModelProperty(value = "User object ID number")
    private Long idNumber;
    @Column(name = "first_name")
    @ApiModelProperty(value = "User object first name")
    private String firstName;
    @Column(name = "last_name")
    @ApiModelProperty(value = "User object last name")
    private String lastName;
    @Column(name = "email")
    @ApiModelProperty(value = "User object email")
    private String email;
    @Column(name = "mobile")
    @ApiModelProperty(value = "User object mobile")
    private String mobile;
    @Column(name = "monthly_income")
    @ApiModelProperty(value = "User object monthly income")
    private double monthlyIncome;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "loan_id")
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JsonIgnore
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
