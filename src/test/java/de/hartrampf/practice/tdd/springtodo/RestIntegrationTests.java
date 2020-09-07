package de.hartrampf.practice.tdd.springtodo;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
@ExtendWith(SpringExtension.class)
class RestIntegrationTests {

    @MockBean
    private TodoService todoService;
    
    @Autowired
    private MockMvc mockMvc;

    @Test
    void itShouldGetListOfTodos() throws Exception {
        when(todoService.getTodos()).thenReturn(List.of(new Todo("1", false), new Todo("2", true)));
        
        mockMvc.perform(MockMvcRequestBuilders.get("/todo"))
               .andExpect(status().isOk())
               .andExpect(content().contentType(MediaType.APPLICATION_JSON))
               .andExpect(jsonPath("$", Matchers.hasSize(2)))
               .andExpect(jsonPath("$[0].subject", CoreMatchers.equalTo("1")))
        ;
    }
    
    @Test
    void itShouldGetTodoByIndex() throws Exception {
        when(todoService.getTodo(anyInt())).thenReturn(new Todo("2", true));
        
        mockMvc.perform(MockMvcRequestBuilders.get("/todo/1"))
               .andExpect(status().isOk())
               .andExpect(content().contentType(MediaType.APPLICATION_JSON))
               .andExpect(jsonPath("$.subject", Matchers.equalTo("2")))
               .andExpect(jsonPath("$.done", Matchers.equalTo(true)))
        ;
    }
}
