import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions( tags={"@todo","~@needtoclarify"},format = {"pretty", "html:target/cucumber", "json:target/cucumber.json"})
public class RunCukesIT {

}
