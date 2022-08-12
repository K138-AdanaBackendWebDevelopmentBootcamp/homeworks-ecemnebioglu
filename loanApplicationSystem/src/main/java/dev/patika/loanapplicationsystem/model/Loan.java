package dev.patika.loanapplicationsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
@ApiModel(value = "Loan object")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loan_id")
    @ApiModelProperty(value = "Loan object id")
    private Long loanId;

    @Column(name = "loan_amount")
    @ApiModelProperty(value = "Loan object loan amount")
    private double loanAmount;

    @Column(name = "loan_status")
    @ApiModelProperty(value = "Loan object status")
    private String loanStatus;

    @Column(name = "user_id_number")
    @ApiModelProperty(value = "User object ID number")
    private Long userIdNumber;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;


}
