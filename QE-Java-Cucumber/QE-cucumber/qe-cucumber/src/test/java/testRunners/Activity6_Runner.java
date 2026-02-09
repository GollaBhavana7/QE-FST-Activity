package testRunners;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SelectClasspathResource;
import io.cucumber.core.options.Constants;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter (
    key=Constants.GLUE_PROPERTY_NAME,
    value="stepDefinitions"
)
@ConfigurationParameter(
    key=Constants.FILTER_TAGS_PROPERTY_NAME,
    value="@activity6"
)
@ConfigurationParameter(
    key=Constants.PLUGIN_PROPERTY_NAME,

value =
        "pretty," +
        "html:target/cucumber-report/cucumber.html," +
        "json:target/cucumber-report/cucumber.json," +
        "junit:target/cucumber-report/cucumber.xml"

)
public class Activity6_Runner {

}
