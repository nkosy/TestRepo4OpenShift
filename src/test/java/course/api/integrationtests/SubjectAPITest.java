package course.api.integrationtests;

import course.App;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by hashcode on 2015/08/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
@IntegrationTest({"server.port=8080"})
public class SubjectAPITest {

    final String BASE_URL = "http://localhost:8080/";
    private RestTemplate template;

    @Before
    public void setUp() throws Exception {
        template = new TestRestTemplate();
    }

    @Test
    public void testRead() throws Exception {
        ResponseEntity<String> response =template.getForEntity(BASE_URL+"api/subject/readall", String.class);

        System.out.println("The response is "+response.getBody());


    }
}
