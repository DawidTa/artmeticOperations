package pl.kurs.test4dt.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import pl.kurs.test4dt.entity.HistoryOperation;
import pl.kurs.test4dt.model.AritmeticModel;
import pl.kurs.test4dt.service.HistoryService;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.when;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(OperationController.class)
public class OperationControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    HistoryService historyService;

    @BeforeEach
    public void setUp() throws Exception {

        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void resultOperation() throws Exception {
        AritmeticModel aritmeticModel = new AritmeticModel();
        aritmeticModel.setN1(2);
        aritmeticModel.setN2(6);
        aritmeticModel.setOperator("*");

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter objectWriter = objectMapper.writer().withDefaultPrettyPrinter();
        String requestJson = objectWriter.writeValueAsString(aritmeticModel);

        mockMvc.perform(post("/operation/result")
                .contentType(APPLICATION_JSON_UTF8)
                .content(requestJson))
                .andExpect(status().isCreated());

    }


    @Test
    public void historyOperations() throws Exception {

        mockMvc.perform(get("/operation/history")
        .param("operator", "*")
        .param("dateFrom" , "2021-09-26 15:55:25")
        .param("dateTo", "2021-09-26 15:55:25"))
                .andExpect(status().isOk());
    }
}