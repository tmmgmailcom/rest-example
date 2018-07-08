package pl.sda.restexample.web;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PostController.class)
public class PostControllerTest {

    @Autowired
    MockMvc mvc;
    //Jackson
    ObjectMapper mapper = new ObjectMapper();

    @MockBean
    PostRepository postRepository;

    @Test
    public void shouldReturnCreatedPost() throws Exception {
        //Given
        Post postToAdd = new Post("title","message");
        Post createdPost = new Post(1L,"title", "message");

        when(postRepository.save(postToAdd)).thenReturn(createdPost);
        //When
        ResultActions result = mvc.perform(post("/posts")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(postToAdd)));
        //Then
        result.andExpect(status().isCreated())
        .andExpect(content().json(mapper.writeValueAsString(createdPost)));
    }
}
