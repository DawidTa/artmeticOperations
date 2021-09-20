package pl.kurs.test4dt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "history_operation")
public class HistoryOperation {
    @Id
    @Column(name = "operation_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "created_date")
    private Timestamp createdDateTime;
    @Column(name = "user_ip")
    private String userIPAddress;
    @Column(name = "n1")
    private double n1;
    @Column(name = "n2")
    private double n2;
    @Column(name = "operator")
    private String operator;

}
