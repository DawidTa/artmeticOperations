package pl.kurs.test4dt.controller;

import org.junit.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import pl.kurs.test4dt.service.HistoryService;

@WebMvcTest(OperationController.class)
public class OperationControllerTest {

    @MockBean
    private HistoryService historyService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void resultOperation() throws Exception {

    }

    @Test
    public void historyOperations() {
    }
}