package ru.atom.boot.mm;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.atom.thread.mm.ConnectionQueue;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@WebMvcTest
public class GamesControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void list() throws Exception {
        ConnectionQueue.getInstance().clear();

        mockMvc.perform(post("/connection/connect")
                .content("id=1&name=a")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED));
        mockMvc.perform(post("/connection/connect")
                .content("id=2&name=b")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED));
        mockMvc.perform(post("/connection/connect")
                .content("id=3&name=c")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED));
        mockMvc.perform(post("/connection/connect")
                .content("id=4&name=d")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED));


        mockMvc.perform(get("/game/list")
                .contentType(MediaType.TEXT_PLAIN_VALUE))
                .andExpect(status().isOk());
    }

}