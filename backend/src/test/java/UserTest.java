import com.alibaba.fastjson.JSONObject;
import com.work.AppStart;
import com.work.controller.UserContorller;

import com.work.entity.User;
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
public class UserTest {
    private MockMvc mockMvc;
    @Autowired
    private UserContorller userContorller;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        this.mockMvc= MockMvcBuilders.standaloneSetup(userContorller).build();
    }

    @Test
    public void login() throws Exception{
        User user=new User();
        user.setEmail("123@164.com");
        user.setPassword("123");
        String param= JSONObject.toJSONString(user);
      this.mockMvc.perform(MockMvcRequestBuilders.post("/user/login")
              .contentType(MediaType.APPLICATION_JSON).content(param))
      .andDo(print()).andReturn().getResponse();
    }

    @Test
    public void register() throws Exception{
        User user=new User();
        user.setUserName("test4");
        user.setEmail("123@165.com");
        user.setPassword("123");
        String param= JSONObject.toJSONString(user);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/user/register")
                .contentType(MediaType.APPLICATION_JSON).content(param))
                .andDo(print()).andReturn().getResponse();
    }
}
