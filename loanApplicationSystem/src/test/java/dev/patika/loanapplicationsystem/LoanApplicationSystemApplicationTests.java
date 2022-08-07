package dev.patika.loanapplicationsystem;

import dev.patika.loanapplicationsystem.model.User;
import dev.patika.loanapplicationsystem.repository.LoanRepository;
import dev.patika.loanapplicationsystem.repository.UserRepository;
import dev.patika.loanapplicationsystem.test.TestCrud;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LoanApplicationSystemApplicationTests implements TestCrud {

    //    @Autowired
//    LoanRepository loanRepository;
    @Autowired
    UserRepository userRepository;

    @Test
    @Override
    public void testCreate() {
        User user = User.builder()
                .idNumber(1234567891L)
                .firstName("Caleb Test")
                .lastName("Beasley Test")
                .mobile("(726) 412-3583")
                .email("mi.felis@protonmail.com")
                .monthlyIncome(15084)
                        .build();
        userRepository.save(user);

        //if object is null send assertionError
        assertNotNull(userRepository.findByIdNumber(1234567891L).get());
    }

    @Test
    @Override
    public void testUpdate() {
        User user = userRepository.findByIdNumber(1234567891L).get();
        user.setFirstName("Caleb 11 TEST");
        userRepository.save(user);

        assertNotEquals("Caleb Test", userRepository.findByIdNumber(1234567891L).get().getFirstName());
    }

    @Test
    @Override
    public void testList() {
        List<User> userList = userRepository.findAll();

        //if list is greater than 0
        assertThat(userList.isEmpty());
    }

    @Test
    @Override
    public void testFindByIdNumber() {
        User user = userRepository.findByIdNumber(1234567891L).get();

        assertEquals("Caleb Test", user.getFirstName());
    }

    @Test
    @Override
    public void testDelete() {
        userRepository.deleteByIdNumber(1234567891L);
        assertThat(userRepository.findByIdNumber(1234567891L).isPresent());
    }
}
