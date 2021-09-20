package pl.kurs.test4dt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import pl.kurs.test4dt.entity.HistoryOperation;
import pl.kurs.test4dt.helper.DateTimeHelper;
import pl.kurs.test4dt.model.AritmeticModel;
import pl.kurs.test4dt.service.HistoryService;
import pl.kurs.test4dt.service.OperationFacade;

import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/operation")
public class OperationController {

    @Autowired
    OperationFacade operationFacade;
    @Autowired
    HistoryService historyService;

    @PostMapping("/result")
    @ResponseBody
    public ResponseEntity<String> resultOperation(@RequestBody AritmeticModel aritmeticModel) throws UnknownHostException {
        double result = operationFacade.operationResult(aritmeticModel);
        historyService.saveRecord(aritmeticModel);
        return new ResponseEntity<String>(String.valueOf(result), HttpStatus.CREATED);
    }

//    @GetMapping("/history")
//    public List<HistoryOperation> historyOperations(@RequestParam(required = false, value = "operator") String operator,
//                                                    @RequestParam(required = false, value = "dateFrom")
//                                                    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime dateFrom,
//                                                    @RequestParam(required = false, value = "dateTo")
//                                                    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime dateTo) {
//        return historyService.getRecords(operator, dateFrom, dateTo);
//    }

    @GetMapping("/history")
    public List<HistoryOperation> historyOperations(@RequestParam(required = false, value = "operator") String operator,
                                                    @RequestParam(required = false, value = "dateFrom") String dateFrom,
                                                    @RequestParam(required = false, value = "dateTo") String dateTo) {
        return historyService.getRecords(operator, dateFrom, dateTo);
    }
}
