package me.khoro.generator.repository;

import me.khoro.generator.model.entity.DbData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author s-kh
 * Стандартный spring-data репозиторий для сущности
 * {@link me.khoro.generator.model.entity.DbData}
 *
 * @since 0.0.1
 * @version 0.0.1
 */
@Repository
public interface DbDataRepository extends CrudRepository<DbData, Long> {
}
