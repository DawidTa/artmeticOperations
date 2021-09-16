package pl.kurs.test4dt.model.history;

import lombok.Data;

import java.time.LocalDate;

@Data
public class HistoryModel {
    private int id;
    private LocalDate createdDate;
    private String userIPAddress;
    private double n1;
    private double n2;
    private String operator;
}
