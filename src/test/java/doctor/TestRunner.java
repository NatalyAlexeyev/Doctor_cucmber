package doctor;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions
        (
                features = "src/test/resources/features",
                glue = "doctor.stepsDefinitions",
                plugin = {"pretty", "json:target/cucumber.json"},
                tags = "@Logout or @ProfileVorNaname or @ProfileNachNaname or @ProfileTelefonnummer or " +
                        "@Login or @InvalidPassword or @Registration or @Infusionstherapie or " +
                        "@Neuraltherapie or @Schrüpftherapie or @Phytotherapie or @Aromatherapie or " +
                        "@Ernährungsberatung or @Labordiagnostik"
        )

public class TestRunner {
}

