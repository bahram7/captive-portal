package org.sohagroup.mobin.captiveportal;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {
        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("org.sohagroup.mobin.captiveportal");

        noClasses()
            .that()
            .resideInAnyPackage("org.sohagroup.mobin.captiveportal.service..")
            .or()
            .resideInAnyPackage("org.sohagroup.mobin.captiveportal.repository..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..org.sohagroup.mobin.captiveportal.web..")
            .because("Services and repositories should not depend on web layer")
            .check(importedClasses);
    }
}
