package me.khoro.generator.service.impl;

import me.khoro.generator.model.entity.DbData;
import me.khoro.generator.service.ValueGenerator;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

/**
 * @author s-kh
 * Сервис, реализующий интерфейс генератора данных {@link me.khoro.generator.service.ValueGenerator}
 * Возвращает экземпляр класса {@link me.khoro.generator.model.entity.DbData}, заполненный случайными данными
 * Свойство id - не заполняется (null)
 *
 * {@link #userIdGenerator} - генератор userId
 * {@link #factIdGenerator} - генератор factId
 * {@link #factStrGenerator} - генератор factStr
 * @since 0.0.1
 * @version 0.0.1
 */
@Service
public class MockDataGenerator implements ValueGenerator<DbData> {

    private final ValueGenerator<String> userIdGenerator;

    private final ValueGenerator<Long> factIdGenerator;

    private final ValueGenerator<String> factStrGenerator;

    public MockDataGenerator(ValueGenerator<String> userIdGenerator,
                             ValueGenerator<Long> factIdGenerator,
                             ValueGenerator<String> factStrGenerator) {
        this.userIdGenerator = userIdGenerator;
        this.factIdGenerator = factIdGenerator;
        this.factStrGenerator = factStrGenerator;
    }


    @Override
    public DbData generate() {
        return new DbData(
                null,
                userIdGenerator.generate(),
                factIdGenerator.generate(),
                factStrGenerator.generate(),
                new Timestamp(System.currentTimeMillis()));
    }
}
