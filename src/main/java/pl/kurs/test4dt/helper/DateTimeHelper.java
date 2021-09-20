package pl.kurs.test4dt.helper;

import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class DateTimeHelper {
    public Timestamp convertStringToDateTime(String date) {
        return Timestamp.valueOf(date);
    }
}
