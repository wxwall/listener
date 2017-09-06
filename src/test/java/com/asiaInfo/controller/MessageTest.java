package com.asiaInfo.controller;

import com.asiaInfo.Application;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by wxwall on 2017/8/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@Transactional
public class MessageTest  {

    @Autowired
    private WebApplicationContext context;
    private MockMvc mvc;


    private Logger logger = Logger.getLogger(getClass());


    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.webAppContextSetup(context).build();//建议使用这种
    }

    //测试广东数据源
    @Test
    public void test3() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/test3?rout=8440000").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


    //测试江苏数据源
    @Test
    public void getHello() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/test3?rout=8320000").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
