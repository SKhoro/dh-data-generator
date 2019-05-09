package me.khoro.generator.service.impl;

import me.khoro.generator.pojo.Users;
import me.khoro.generator.service.ValueGenerator;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @author s-kh
 * Сервис, реализующий интерфейс генератора данных {@link me.khoro.generator.service.ValueGenerator}
 * Возвращает случайную строку из перечисления доступных пользователей {@link me.khoro.generator.pojo.Users}
 *
 * {@link #users} - сами доступные значения
 * {@link #random} - класс-генератор псевдослучайных значений
 * @since 0.0.1
 * @version 0.0.1
 */
@Service
public class UserIdGenerator implements ValueGenerator<String> {

    private final Users[] users = Users.values();

    private final Random random = new Random();

    @Override
    public String generate() {
        int index = random.nextInt(users.length);
        return users[index].getValue();
    }
}
