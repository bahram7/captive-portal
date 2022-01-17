package org.sohagroup.bsi.smsservice;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {

        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("org.sohagroup.bsi.smsservice");

        noClasses()
            .that()
                .resideInAnyPackage("org.sohagroup.bsi.smsservice.service..")
            .or()
                .resideInAnyPackage("org.sohagroup.bsi.smsservice.repository..")
            .should().dependOnClassesThat()
                .resideInAnyPackage("..org.sohagroup.bsi.smsservice.web..")
        .because("Services and repositories should not depend on web layer")
        .check(importedClasses);
    }
}
