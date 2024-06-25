package com.example.proiect;

import com.example.proiect.controller.AutorController;
import com.example.proiect.service.AutorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AutorController.class)
public class AutorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AutorService autorService;

    @Test
    public void testListaAutori() throws Exception {
        mockMvc.perform(get("/autori"))
                .andExpect(status().isOk());
    }

    // Alte teste
}