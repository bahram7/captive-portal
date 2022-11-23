package org.sohagroup.mobin.captiveportal.cucumber;

import io.cucumber.spring.CucumberContextConfiguration;
import org.sohagroup.mobin.captiveportal.TokenApp;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

@CucumberContextConfiguration
@SpringBootTest(classes = TokenApp.class)
@WebAppConfiguration
public class CucumberTestContextConfiguration {}
