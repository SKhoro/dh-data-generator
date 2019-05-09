package me.khoro.generator.service;

/**
 * @author s-kh
 * Интерфейс, определяющий сервис, генерирующий некоторые данные
 *
 * @param <T> - тип генерируемых данных
 * @since 0.0.1
 * @version 0.0.1
 */
@FunctionalInterface
public interface ValueGenerator <T> {

    /**
     * Метод-producer, возвращающий случайные сгенерированные данные
     * @return новую порцию случайных данных
     */
    T generate();
}
