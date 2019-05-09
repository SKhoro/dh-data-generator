package me.khoro.generator.service.impl;

import me.khoro.generator.service.ValueGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class FactStrGeneratorTest {

    @Autowired
    private ValueGenerator<String> factStrGenerator;

    @Value("${app.factstr_size}")
    int length;

    @Test
    public void generate() {
        String str = factStrGenerator.generate();
        assertNotNull(str);
        int generatedStrLen = str.length();
        assertEquals(generatedStrLen, length);
    }
}