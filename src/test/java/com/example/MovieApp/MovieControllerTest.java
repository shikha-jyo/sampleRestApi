package com.example.MovieApp;

import com.example.MovieApp.controller.MovieController;
import com.example.MovieApp.repository.primary.ShowRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@ContextConfiguration(classes = {MovieController.class})
@WebMvcTest
public class MovieControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ShowRepository showRepository;
    @Test
     void testMovieById() throws Exception {
        String TEST_USER_ID = "123";

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/movieById")
                       .with(user(TEST_USER_ID))
                       .with(csrf())
                       .queryParam("movieId","1")
                        .queryParam("date","07-10-2023")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String resultDOW = result.getResponse().getContentAsString();
       assertNotNull(resultDOW);
       // assertEquals(dow, resultDOW);
    }





}
