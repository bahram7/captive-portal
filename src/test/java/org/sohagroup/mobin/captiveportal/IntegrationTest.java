package org.sohagroup.mobin.captiveportal;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.sohagroup.mobin.captiveportal.CaptiveportalApp;
import org.sohagroup.mobin.captiveportal.config.TestSecurityConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Base composite annotation for integration tests.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@SpringBootTest(classes = { CaptiveportalApp.class, TestSecurityConfiguration.class })
public @interface IntegrationTest {
}
