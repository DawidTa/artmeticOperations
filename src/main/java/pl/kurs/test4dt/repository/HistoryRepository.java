package pl.kurs.test4dt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kurs.test4dt.entity.HistoryOperation;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface HistoryRepository extends JpaRepository<HistoryOperation, Integer> {
    List<HistoryOperation> findByOperator(String operator);

    List<HistoryOperation> findByCreatedDateTimeGreaterThan(Timestamp createdDateTime);

    List<HistoryOperation> findByCreatedDateTimeBetween(Timestamp createdDateTimeFrom, Timestamp createdDateTimeTo);

    List<HistoryOperation> findByCreatedDateTimeGreaterThanAndOperator(Timestamp createdDateTime, String operator);

    List<HistoryOperation> findByCreatedDateTimeLessThanAndOperator(Timestamp createdDateTime, String operator);

    List<HistoryOperation> findByCreatedDateTimeBetweenAndOperator(Timestamp createdDateTimeFrom, Timestamp createdDateTimeTo, String operator);

    List<HistoryOperation> findByCreatedDateTimeLessThan(Timestamp createdDateTime);
}
