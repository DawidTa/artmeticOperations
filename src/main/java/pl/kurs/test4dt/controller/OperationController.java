package pl.kurs.test4dt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.kurs.test4dt.entity.HistoryOperation;
import pl.kurs.test4dt.model.operations.AritmeticModel;
import pl.kurs.test4dt.service.HistoryService;
import pl.kurs.test4dt.service.OperationFacade;

@RestController
@RequestMapping("/operation")
public class OperationController {

    @Autowired
    OperationFacade operationFacade;

    @PostMapping("/result")
    public ResponseEntity<Double> resultOperation(@RequestBody AritmeticModel aritmeticModel) {
        double result = operationFacade.operationResult(aritmeticModel);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

}
