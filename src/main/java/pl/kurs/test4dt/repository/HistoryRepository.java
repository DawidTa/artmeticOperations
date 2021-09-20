package pl.kurs.test4dt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.kurs.test4dt.entity.HistoryOperation;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface HistoryRepository extends JpaRepository<HistoryOperation, Integer> {
    List<HistoryOperation> findByOperator(String operator);

    List<HistoryOperation> findByCreatedDateTime(Timestamp createdDateTime);

//    @Query(value = "SELECT h FROM history_operation h where created_date = ?1", nativeQuery = true)
//    List<HistoryOperation> findByCreatedDateTime(LocalDateTime createdDateTime);
}
