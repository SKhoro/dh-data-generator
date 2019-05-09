package me.khoro.generator.service.impl;

import me.khoro.generator.pojo.Users;
import me.khoro.generator.service.ValueGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import static org.junit.Assert.*;

@ActiveProfiles("test")
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserIdGeneratorTest {

    @Autowired
    private ValueGenerator<String> userIdGenerator;

    @Test
    public void generate() {
        String userId = userIdGenerator.generate();
        boolean isPresent = Arrays.stream(Users.values()).map(Users::getValue).anyMatch(u -> u.equals(userId));
        assertTrue(isPresent);
    }
}