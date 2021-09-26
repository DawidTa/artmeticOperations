package pl.kurs.test4dt.controller;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.kurs.test4dt.model.AritmeticModel;
import pl.kurs.test4dt.service.HistoryService;
import pl.kurs.test4dt.service.OperationFacade;

import javax.validation.Valid;
import java.net.UnknownHostException;
import java.util.Map;

@RestController
@RequestMapping("/operation")
public class OperationController {

    @Autowired
    OperationFacade operationFacade;
    @Autowired
    HistoryService historyService;

    @PostMapping("/result")
    @ResponseBody
    public ResponseEntity resultOperation(@RequestBody @Valid AritmeticModel aritmeticModel) throws UnknownHostException {
        double result = operationFacade.operationResult(aritmeticModel);
        historyService.saveRecord(aritmeticModel);
        return new ResponseEntity(Map.of("result", String.valueOf(result)), HttpStatus.CREATED);
    }

    @GetMapping("/history")
    public ResponseEntity historyOperations(@RequestParam(required = false, value = "operator") String operator,
                                            @RequestParam(required = false, value = "dateFrom") String dateFrom,
                                            @RequestParam(required = false, value = "dateTo") String dateTo) {
        return ResponseEntity.ok(historyService.getRecords(operator, dateFrom, dateTo));
    }
}
