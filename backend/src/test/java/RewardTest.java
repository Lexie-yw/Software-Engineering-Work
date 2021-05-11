
import com.work.AppStart;
import com.work.controller.RewardController;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@SpringBootTest(classes = AppStart.class,webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@RunWith(SpringRunner.class)
public class RewardTest {
    private MockMvc mockMvc;
    @Autowired
    private RewardController rewardController;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        this.mockMvc= MockMvcBuilders.standaloneSetup(rewardController).build();
    }


    @Test
    public void getpic() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/reward/get/pic"))
                .andDo(print()).andReturn().getResponse();
    }
}
