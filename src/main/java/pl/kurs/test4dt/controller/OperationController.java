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
    public ResponseEntity resultOperation(@RequestBody AritmeticModel aritmeticModel) throws UnknownHostException {
        if (!operationFacade.getCodes().contains(aritmeticModel.getOperator())) {
            return ResponseEntity.badRequest().body("Operator not found");
        }
        double result = operationFacade.operationResult(aritmeticModel);
        historyService.saveRecord(aritmeticModel);
        return new ResponseEntity(Map.of("result", String.valueOf(result)), HttpStatus.CREATED);
    }

    @GetMapping("/history")
    public ResponseEntity historyOperations(@RequestParam(required = false, value = "operator") String operator,
                                            @RequestParam(required = false, value = "dateFrom") String dateFrom,
                                            @RequestParam(required = false, value = "dateTo") String dateTo) {
//        query.setParameter("dateFrom", dateFrom)
        String sql = "select * from history_operations where 1=1";
        if (operator != null) {
            sql += " operator = '" + operator + "'";
        }
        if (dateFrom != null) {

        }
        if (dateTo != null) {

        }
        return ResponseEntity.ok(historyService.getRecords(operator, dateFrom, dateTo));
    }
}
