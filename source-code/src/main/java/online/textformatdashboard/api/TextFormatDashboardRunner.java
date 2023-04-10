package online.textformatdashboard.api;

import java.io.IOException;

//@SpringBootApplication
public class TextFormatDashboardRunner {

    public static void main(String[] commandLineArguments) throws IOException {

        //SpringApplication.run(TextFormatDashboardRunner.class, commandLineArguments);
        ExternalPythonScriptRunner externalPythonScriptRunner = new ExternalPythonScriptRunner();

        externalPythonScriptRunner.runScript();

    }

}
