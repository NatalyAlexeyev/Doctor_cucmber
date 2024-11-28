package doctor;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions
        (
                features = "src/test/resources/features",
                glue = "doctor.stepsDefinitions",
                plugin = {"pretty", "html:target/cucumber-reports.html"},
                tags = "@Logout or @ProfileVorNaname or @ProfileNachNaname or @ProfileTelefonnummer or " +
                        "@Login or @InvalidPassword or @Registration or @Infusionstherapie or " +
                        "@Neuraltherapie or @Schrüpftherapie or @Phytotherapie or @Aromatherapie or " +
                        "@Ernährungsberatung or @Labordiagnostik or @About or @Team or @Contact or @Services or @TerminVereinbaren",
                monochrome = true
        )

public class TestRunner {
}
