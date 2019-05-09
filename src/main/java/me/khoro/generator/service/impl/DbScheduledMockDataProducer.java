package me.khoro.generator.service.impl;

import me.khoro.generator.model.entity.DbData;
import me.khoro.generator.repository.DbDataRepository;
import me.khoro.generator.service.ValueGenerator;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Сервис, заполняющий базу данных случайными данными в соответствии с моделью
 * {@link me.khoro.generator.model.entity.DbData}
 */
@Service
public class DbScheduledMockDataProducer implements Runnable {

    private final ValueGenerator<DbData> dataGenerator;

    private final DbDataRepository dbDataRepository;

    public DbScheduledMockDataProducer(ValueGenerator<DbData> dataGenerator, DbDataRepository dbDataRepository) {
        this.dataGenerator = dataGenerator;
        this.dbDataRepository = dbDataRepository;
    }

    @Override
    @Scheduled(cron = "${app.row_generator_rate}")
    @Transactional
    public void run() {
        dbDataRepository.save(dataGenerator.generate());

    }
}
