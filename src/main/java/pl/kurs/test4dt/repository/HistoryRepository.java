package pl.kurs.test4dt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kurs.test4dt.entity.HistoryOperation;

public interface HistoryRepository extends JpaRepository<HistoryOperation, Integer> {
}
