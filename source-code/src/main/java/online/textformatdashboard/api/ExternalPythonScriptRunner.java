package online.textformatdashboard.api;

import java.io.*;

public class ExternalPythonScriptRunner {

    public static String s;

    public void runScript() throws IOException {

        String pathPython = "secretsauce.py";
        String[] cmd = new String[5];
        cmd[0] = "python3";
        cmd[1] = pathPython;
        cmd[2] = "arg1";
        cmd[3] = "arg2";
        cmd[4] = "arg3";
        Runtime r = Runtime.getRuntime();

        Process p = r.exec(cmd);
        BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
        while ((s = in.readLine()) != null) {
            System.out.println(s);
        }

    }

}
