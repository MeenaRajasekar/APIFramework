//package Cucumber.Options;
//
//import org.junit.runner.RunWith;
//
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
//
//@RunWith(Cucumber.class)
////@CucumberOptions(features="src/test/java/Features/",glue= {"stepdefinition"})
//@CucumberOptions(features="/Users/rakshan/projects_Meena/eclipse-workspace/APIFramework/src/test/java/Features/PlaceValidations.feature",glue= {"stepdefinition"})
//
//
//public class TestRunner {
//	//tags= {"@AddPlace"}
//
//}
//
//
//
//

package Cucumber.Options;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "/Users/rakshan/projects_Meena/eclipse-workspace/APIFramework/src/test/java/Features/", // Location of your feature files
    glue = "StepDefinition.java",  // Location of your step definitions package
    plugin = {"pretty", "html:target/cucumber-reports"} // Optional: Report format and location
)
public class TestRunner {
}
