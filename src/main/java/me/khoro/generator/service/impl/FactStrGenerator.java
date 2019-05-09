package me.khoro.generator.service.impl;

import me.khoro.generator.service.ValueGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @author s-kh
 * Сервис, реализующий интерфейс генератора данных {@link me.khoro.generator.service.ValueGenerator}
 * Возвращает случайное строку из символов [a-z] длинной {{@link #strLength}}
 *
 * {@link #strLength} - длина возвращаемой строки
 * {@link #random} - класс-генератор псевдослучайных значений
 * @since 0.0.1
 * @version 0.0.1
 */
@Service
public class FactStrGenerator implements ValueGenerator<String> {

    private Random random = new Random();

    @Value("${app.factstr_size}")
    private int strLength;

    @Override
    public String generate() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strLength; i++) {
            sb.append(genAsciiChar());
        }
        return sb.toString();
    }

    /**
     * Генерирует случайные символы
     * @return возвращает символ в пределах [a-z]
     */
    private char genAsciiChar() {
        int size = 'z' - 'a';
        int i = random.nextInt(size);
        return (char) (i + 'a');
    }
}
