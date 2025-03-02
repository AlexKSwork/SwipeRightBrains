package com.nsa.cubric.application.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IntroControllerTest {

    @Autowired
    private Intro introController;

    @Test
    public void loadcontroller() throws Exception{
        assertThat(introController).isNotNull();
    }
}
