package com.springmvclearn.web.ch4_6;

import com.springmvclearn.MyMvcConfig;
import com.springmvclearn.service.DemoService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * WebAppConfiguration 声明加载的ApplicationContext是一个WebApplicationContext,他的属性指的是web资源的位置
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MyMvcConfig.class})
@WebAppConfiguration("src/main/resources")
public class TestControllerIntegrationTests {
    private MockMvc mockMvc;//模拟MVC对象

    @Autowired
    DemoService demoService;

    @Autowired
    WebApplicationContext wac;

    @Autowired
    MockHttpSession session;//可注入模拟的 http session

    @Autowired
    MockHttpServletRequest request;//可注入模拟的 http request

    //测试之前的初始化工作
    @Before
    public void setup(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void testNormalController() throws Exception{
        mockMvc.perform(get("/normal"))//模拟向/normal进行get请求
                .andExpect(status().isOk())//预期返回状态为200
                .andExpect(view().name("page"))//预期view名称为page
                .andExpect(forwardedUrl("/WEB-INF/classes/views/page.jsp"))//预期页面真正跳转
                .andExpect(model().attribute("msg",demoService.saySomething()));//预期model里的msg值
    }

    @Test
    public void testRestController() throws Exception{
        mockMvc.perform(get("/testRest")) //13
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))//14
                .andExpect(content().string(demoService.saySomething()));//15
    }
}
