package com.example.demo.question;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(value = QuestionController.class)
public class QuestionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private QuestionService questionService;

    Reply mockReply = new Reply(1, "Riapl", "Reply_Author");

    String exampleReplyJson = "{\"author\":\"Ripal\", \"message\":\"Reply_Author\"}";

    @Test
    public void retrieveDetailsForReply() throws Exception {

        Mockito.when(questionService.getReplyById(Mockito.anyInt(), Mockito.anyInt())).thenReturn(mockReply);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/questions/101/Reply/1").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        System.out.println(result.getResponse());
        String expected = "{id:1,author:Ripal,message:Reply_Author}";

        JSONAssert.assertEquals(expected,result.getResponse().getContentAsString(),false);
    }
}
