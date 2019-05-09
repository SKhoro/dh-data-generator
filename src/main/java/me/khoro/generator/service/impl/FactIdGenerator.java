package me.khoro.generator.service.impl;

import me.khoro.generator.service.ValueGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @author s-kh
 * Сервис, реализующий интерфейс генератора данных {@link me.khoro.generator.service.ValueGenerator}
 * Возвращает случайное число в пределах от 1 до {{@link #maxFactIdValue}}
 *
 * {@link #maxFactIdValue} - максимально значение
 * {@link #random} - класс-генератор псевдослучайных значений
 * @since 0.0.1
 * @version 0.0.1
 */
@Service
public class FactIdGenerator implements ValueGenerator<Long> {

    @Value("${app.max_factid_value}")
    private int maxFactIdValue;

    private Random random = new Random();

    @Override
    public Long generate() {
        return (long) random.nextInt(maxFactIdValue) + 1;
    }
}
