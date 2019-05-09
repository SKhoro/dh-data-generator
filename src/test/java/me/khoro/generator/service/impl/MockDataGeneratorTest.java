package me.khoro.generator.service.impl;

import me.khoro.generator.model.entity.DbData;
import me.khoro.generator.service.ValueGenerator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@ActiveProfiles("test")
@SpringBootTest
@RunWith(SpringRunner.class)
public class MockDataGeneratorTest {

    @Mock
    private ValueGenerator<String> factStrGenerator;

    @Mock
    private ValueGenerator<String> userIdGenerator;

    @Mock
    private ValueGenerator<Long> factIdGenerator;

    private Long mockFactIdData = 1L;

    private String mockUserIdData = "user_1";

    private String mockFactStrData = "qwertyuioasdfghjzxc";

    @Before
    public void init() {
        when(factIdGenerator.generate()).thenReturn(mockFactIdData);
        when(userIdGenerator.generate()).thenReturn(mockUserIdData);
        when(factStrGenerator.generate()).thenReturn(mockFactStrData);
    }

    @Test
    public void generate() {
        MockDataGenerator mockDataGenerator = new MockDataGenerator(userIdGenerator, factIdGenerator, factStrGenerator);

        DbData data = mockDataGenerator.generate();
        assertEquals(data.getFactId(), mockFactIdData);
        assertEquals(data.getUserId(), mockUserIdData);
        assertEquals(data.getFactStr(), mockFactStrData);
    }
}