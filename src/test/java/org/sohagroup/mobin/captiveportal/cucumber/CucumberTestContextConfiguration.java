package org.sohagroup.mobin.captiveportal.cucumber;

import io.cucumber.spring.CucumberContextConfiguration;
import org.sohagroup.mobin.captiveportal.CaptiveportalApp;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

@CucumberContextConfiguration
@SpringBootTest(classes = CaptiveportalApp.class)
@WebAppConfiguration
public class CucumberTestContextConfiguration {}
