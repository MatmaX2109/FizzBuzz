package com.mat.fizzbuzz.step1;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class FizzBuzzControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FizzBuzzService service;

    private Resp mockEntity;
    private String[] mockString;

    @BeforeEach
    public void setUp(){
        mockString = new String[2];
        mockString[0]="transformation";
        mockString[1]="raport";

        mockEntity = Resp.builder().transformation("transformation").raport("raport").build();
    }

    @Test
    public void testOk() throws Exception{
        when(service.transform(1,20)).thenReturn(mockString);
        when(service.generateString(any())).thenReturn("transformation");
        when(service.generateReport(any())).thenReturn("raport");

        mockMvc.perform(get("/transformation?startInterval=1&endInterval=20"))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.transformation", Matchers.is("transformation")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.raport", Matchers.is("raport")))
                .andReturn();
    }

    @Test
    public void testBadRequest() throws Exception {
        when(service.transform(1,20)).thenReturn(mockString);
        when(service.generateString(any())).thenReturn("transformation");
        when(service.generateReport(any())).thenReturn("raport");

        MvcResult test = mockMvc.perform(get("/transformation?startInterval=1a&endInterval=20"))
                .andExpect(status().isBadRequest())
                .andReturn();

        assertTrue(test.getResponse().getContentAsString().equals("Apelul nu este corect"));
    }

}