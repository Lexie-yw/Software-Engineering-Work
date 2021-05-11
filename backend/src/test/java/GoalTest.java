import com.alibaba.fastjson.JSONObject;
import com.work.AppStart;
import com.work.controller.GoalController;
import com.work.entity.Goal;
import com.work.entity.User;
import com.work.service.GoalService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest(classes = AppStart.class,webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@RunWith(SpringRunner.class)
public class GoalTest {
    private MockMvc mockMvc;
    @Autowired
    private GoalController goalController;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        this.mockMvc= MockMvcBuilders.standaloneSetup(goalController).build();
    }
    @Test
    public void addGoal() throws Exception{
        Goal goal=new Goal();
        goal.setUserId("6087d963120dda53a75f6149");
        goal.setGoalName("test4");
        goal.setDescription("desc");
        goal.setTotalTimes(10);
        goal.setNowTimes(0);
        goal.setStatus(0);
        String param= JSONObject.toJSONString(goal);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/goal/add")
                .contentType(MediaType.APPLICATION_JSON).content(param))
                .andDo(print()).andReturn().getResponse();
    }

    @Test
    public void getGoal() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/goal/get/6087d963120dda53a75f6149"))
                .andDo(print()).andReturn().getResponse();
    }
}
