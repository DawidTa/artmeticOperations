package pl.arithmeticOperations.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.arithmeticOperations.model.ArithmeticModel;
import pl.arithmeticOperations.service.HistoryService;
import pl.arithmeticOperations.service.OperationFacade;

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
    public ResponseEntity resultOperation(@RequestBody @Valid ArithmeticModel arithmeticModel) throws UnknownHostException {
        double result = operationFacade.operationResult(arithmeticModel);
        historyService.saveRecord(arithmeticModel);
        return new ResponseEntity(Map.of("result", String.valueOf(result)), HttpStatus.CREATED);
    }

    @GetMapping("/history")
    public ResponseEntity historyOperations(@RequestParam(required = false, value = "operator") String operator,
                                            @RequestParam(required = false, value = "dateFrom") String dateFrom,
                                            @RequestParam(required = false, value = "dateTo") String dateTo) {
        return ResponseEntity.ok(historyService.getRecords(operator, dateFrom, dateTo));
    }
}
