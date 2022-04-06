import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/book_list.feature", "src/test/resources/features/HomeBottons.feature", "src/test/resources/features/search.feature"},
        plugin = {"json:target/cucumber.json", "junit:target/cucumber.xml"}
)
public class RunCucumber {
}
