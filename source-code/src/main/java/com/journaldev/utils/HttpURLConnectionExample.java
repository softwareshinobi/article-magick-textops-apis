package com.journaldev.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpURLConnectionExample {

    private static final String USER_AGENT = "Mozilla/5.0";

    //  private static final String GET_URL = "https://localhost:9090/SpringMVCExample";
    //private static final String POST_URL = "http://localhost:8080/text-conversion/format-text-content";
    private static final String POST_URL = "http://159.89.178.126:28444/content/rewrite-content";

    public static void main(String[] args) throws IOException {
//        sendGET();
//        System.out.println("GET DONE");
        sendPOST();
        System.out.println("POST DONE");
    }

    private static void sendPOST() throws IOException {
        URL obj = new URL(POST_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);

        // For POST only - START
        con.setDoOutput(true);
        OutputStream os = con.getOutputStream();

        String POST_PARAMS = "title=Panasdfasfasfasfsffkaj";
        System.out.println("ig to here");
        System.out.println("POST_PARAMS: " + POST_PARAMS);

//        if (POST_PARAMS.endsWith("=.")) {
//            System.out.println("it does...");
//            POST_PARAMS = POST_PARAMS.replace("=.", "");
//        }
        os.write(POST_PARAMS.getBytes());
        os.flush();
        os.close();
        // For POST only - END

        int responseCode = con.getResponseCode();
        System.out.println("POST Response Code :: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) { //success
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            System.out.println(response.toString());
        } else {
            System.out.println("POST request did not work.");
        }
    }

}
//       if (HttpRequest.post("http://localhost:8080/text-conversion/format-text-content").form(data).created()) {

//    private static void sendGET() throws IOException {
//        URL obj = new URL(GET_URL);
//        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
//        con.setRequestMethod("GET");
//        con.setRequestProperty("User-Agent", USER_AGENT);
//        int responseCode = con.getResponseCode();
//        System.out.println("GET Response Code :: " + responseCode);
//        if (responseCode == HttpURLConnection.HTTP_OK) { // success
//            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
//            String inputLine;
//            StringBuffer response = new StringBuffer();
//
//            while ((inputLine = in.readLine()) != null) {
//                response.append(inputLine);
//            }
//            in.close();
//
//            // print result
//            System.out.println(response.toString());
//        } else {
//            System.out.println("GET request did not work.");
//        }
//
//    }
