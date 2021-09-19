package pl.kurs.test4dt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kurs.test4dt.entity.HistoryOperation;

import java.util.List;

@Repository
public interface HistoryRepository extends JpaRepository<HistoryOperation, Integer> {
    List<HistoryOperation> findByOperator(String operator);

//    @Query("SELECT * FROM history_operation where operator = ?1")
//    HistoryOperation findByOperator(String operator);
}
