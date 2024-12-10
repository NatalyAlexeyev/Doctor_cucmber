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
             //   tags ="@Infusionstherapienewuser or @Infusionstherapie"
                tags = "@Terminedelet or @UberMich or @Contact or @Team or @Logout or @ProfileVorNaname or @ProfileNachNaname or " +
                        "@ProfileTelefonnummer or @Login or @InvalidPassword or @Registration or " +
                        "@UsercliksAnmelden or @Infusionstherapienewuser or @Infusionstherapie"

        )

public class TestRunner {
}


