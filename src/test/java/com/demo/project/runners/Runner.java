package com.demo.project.runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features= "src/test/resources/features",
        glue="com.demo.project",
        tags="@Hotfix",
        plugin={"pretty", "html:src/test/resources/report/report.html"}

)



public class Runner {
}


// mvn clean test '-Dcucumber.tags=@test01' (Ejecutar un test especifico en maven)