package services;

import org.jboss.logging.Logger;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;

class TimeServiceTest {
    final static Logger logger = Logger.getLogger(TimeServiceTest.class);

    @Test
    void convert() {
        Timestamp timestamp = TimeService.convert("2020-02-26T12:30");
        logger.info(timestamp.toString());
    }

    @Test
    void isCorrect() {
        logger.info(TimeService.isCorrect(Timestamp.valueOf("2020-02-02 12:00:00"), Timestamp.valueOf("2020-02-02 13:00:00")));
        logger.info(TimeService.isCorrect(Timestamp.valueOf("2020-02-02 14:00:00"), Timestamp.valueOf("2020-02-02 13:00:00")));
    }
}