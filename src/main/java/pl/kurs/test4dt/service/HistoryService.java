package pl.kurs.test4dt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kurs.test4dt.entity.HistoryOperation;
import pl.kurs.test4dt.model.operations.AritmeticModel;
import pl.kurs.test4dt.repository.HistoryRepository;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDate;


@Service
public class HistoryService {

    @Autowired
    HistoryRepository historyRepository;

    public void saveRecord(HistoryOperation historyOperation) throws UnknownHostException {
        AritmeticModel aritmeticModel = new AritmeticModel();
        historyOperation.setN1(aritmeticModel.getN1());
        historyOperation.setN2(aritmeticModel.getN2());
        historyOperation.setOperator(aritmeticModel.getOperator());
        historyOperation.setUserIPAddress(InetAddress.getLocalHost().getHostAddress());
        historyOperation.setCreatedDate(LocalDate.now());
        historyRepository.save(historyOperation);
    }
}
