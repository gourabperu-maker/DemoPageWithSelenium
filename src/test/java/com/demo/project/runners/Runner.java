package com.demo.project.runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features= "src/test/resources/features",
        glue="com.demo.project", // name of principal directory
        tags="@Regression",  //  tags utilize for execute specific test cases {"",""}
        plugin={"pretty", "html:src/test/resources/report/report.html"}, // good UI & route where the report is saved
        monochrome = false // no weird characters, no colors, just plain text in the console


)



public class Runner {
}


// mvn clean test '-Dcucumber.tags=@test01' (Ejecutar un test especifico en maven)