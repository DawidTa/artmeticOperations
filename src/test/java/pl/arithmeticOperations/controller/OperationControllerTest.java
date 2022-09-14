package pl.arithmeticOperations.controller;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import pl.arithmeticOperations.model.ArithmeticModel;
import pl.arithmeticOperations.service.HistoryService;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class OperationControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    HistoryService historyService;

    @Test
    public void resultOperation() throws Exception {
        ArithmeticModel arithmeticModel = new ArithmeticModel();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS);
        arithmeticModel.setN1(2.0);
        arithmeticModel.setN2(6.0);
        arithmeticModel.setOperator("+");

        String jsonContent = objectMapper.writeValueAsString(arithmeticModel);

        MvcResult result = mockMvc.perform(post("/operation/result")
                        .content(jsonContent)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated()).andReturn();

        assertEquals("{\"result\":\"8.0\"}", result.getResponse().getContentAsString());

    }


    @Test
    public void historyOperations() throws Exception {

        mockMvc.perform(get("/operation/history")
                        .param("operator", "*")
                        .param("dateFrom", "2021-09-26 15:55:25")
                        .param("dateTo", "2021-09-26 15:55:25"))
                .andExpect(status().isOk());
    }
}