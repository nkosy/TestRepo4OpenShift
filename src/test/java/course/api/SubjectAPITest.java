package course.api;

import course.App;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Created by hashcode on 2015/08/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@IntegrationTest("server.port:0")
@WebAppConfiguration
public class SubjectAPITest {

    final String BASE_URL = "http://localhost:8080/";
    private MockMvc mockMvc;

    @Test
    public void testRead() throws Exception {
//        this.mockMvc.perform(get("/").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType("application/json"));

    }
}
