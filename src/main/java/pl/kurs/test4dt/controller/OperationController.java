package pl.kurs.test4dt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.kurs.test4dt.entity.HistoryOperation;
import pl.kurs.test4dt.model.AritmeticModel;
import pl.kurs.test4dt.service.HistoryService;
import pl.kurs.test4dt.service.OperationFacade;

import java.net.UnknownHostException;
import java.util.List;

@RestController
@RequestMapping("/operation")
public class OperationController {

    @Autowired
    OperationFacade operationFacade;
    @Autowired
    HistoryService historyService;

    @PostMapping("/result")
    public ResponseEntity<Double> resultOperation(@RequestBody AritmeticModel aritmeticModel) throws UnknownHostException {
        double result = operationFacade.operationResult(aritmeticModel);
        historyService.saveRecord(aritmeticModel);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

//    @GetMapping("/history")
//    public List<HistoryOperation> historyOperations() {
//
//    }
}
