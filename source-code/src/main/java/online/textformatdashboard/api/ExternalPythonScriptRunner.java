package online.textformatdashboard.api;

import java.io.*;

public class ExternalPythonScriptRunner {

    public void runScript() throws IOException {

        File file = new File("wfaf");
        System.out.println("file: " + file.getAbsolutePath());

        //need to call myscript.py and also pass arg1 as its arguments.
        //and also myscript.py path is in C:\Demo\myscript.py
        String[] cmd = {
            "python3",
            "secretsauce.py",
            "hello world",};
        Runtime.getRuntime().exec(cmd);
    }

}
