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
                //tags= "@Login"
                tags = "@UberMich or @Contact or @Team or @Logout or @ProfileVorNaname or @ProfileNachNaname or " +
                        "@ProfileTelefonnummer or @Terminedelet or @Login or @InvalidPassword or @Registration or " +
                        "@UsercliksAnmelden or @Infusionstherapienewuser or @Infusionstherapie"
        )

public class TestRunner {
}

