package me.khoro.generator.pojo;

import lombok.Getter;

/**
 * @author s-kh
 * Перечисление, определяющее доступные значения свойства userId сущености
 * {@link me.khoro.generator.model.entity.DbData}
 *
 * @since 0.0.1
 * @version 0.0.1
 */
public enum Users {

    USER_1("user_1"), USER_2("user_2"), USER_3("user_3");

    @Getter
    private String value;

    Users(String value) {
        this.value = value;
    }
}
