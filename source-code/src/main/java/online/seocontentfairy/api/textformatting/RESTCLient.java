///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package online.seocontentfairy.api.textformatting;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.OutputStream;
//import java.net.HttpURLConnection;
//import java.net.URL;
//
///**
// *
// * @author technical-writing
// */
//public class RESTCLient {
//
//    private static final String POST_URL = "http://localhost:8080/text-conversion/selective-rewrite-text-content";
//    private static final String USER_AGENT = "Mozilla/5.0";
//
//    public static String postcall(String strrgs) throws IOException {
//        URL obj = new URL(POST_URL);
//        HttpURLConnection httpURLConnection = (HttpURLConnection) obj.openConnection();
//        httpURLConnection.setRequestMethod("POST");
//        httpURLConnection.setRequestProperty("User-Agent", USER_AGENT);
//
//        // For POST only - START
//        httpURLConnection.setDoOutput(true);
//        try ( OutputStream os = httpURLConnection.getOutputStream()) {
//            os.write(strrgs.getBytes());
//            os.flush();
//            // For POST only - END
//        }
//
//        int responseCode = httpURLConnection.getResponseCode();
//        System.out.println("POST Response Code :: " + responseCode);
//
//        if (responseCode == HttpURLConnection.HTTP_OK) {
//            StringBuilder response;
//            try ( // success
//                     BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()))) {
//                String inputLine;
//                response = new StringBuilder();
//                while ((inputLine = in.readLine()) != null) {
//                    response.append(inputLine);
//                }
//            }
//
//            // print result
//            System.out.println("reponse: " + response.toString());
//            return response.toString();
//        } else {
//            System.out.println("POST request not worked");
//            return null;
//        }
//    }
//}
////    public void foo() {
////        CloseableHttpClient httpclient = HttpClients.createDefault();
////        try {
////            HttpUriRequest httppost = RequestBuilder.post()
////                    .setUri(new URI("http://localhost:8080/text-conversion/selective-rewrite-text-content"))
////                    .addParameter("tester", strrgs)
////                    .addParameter("foo2", "bar2")
////                    .build();
////
////            CloseableHttpResponse response = httpclient.execute(httppost);
////            try {
////                String r = EntityUtils.toString(response
////                ..getEntity()
////                );
////                System.out.println("r: ");
////                System.out.println(r);
////            } finally {
////                response.close();
////            }
////        } catch (URISyntaxException ex) {
////            Logger.getLogger(RESTCLient.class.getName()).log(Level.SEVERE, null, ex);
////        } finally {
////            httpclient.close();
////        }
////        return null;
////    }
////
////    public static void foo2() {
////        String result = "";
////        try {
////            URL url = new URL("http://localhost:8080/text-conversion/selective-rewrite-text-content");
////                  String postData = "foo1=bar1&foo2=bar2";
////
////            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
////            conn.setRequestMethod("POST");
////            conn.setDoOutput(true);
////            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
////            conn.setRequestProperty("Content-Length", Integer.toString(strrgs.length()));
////            conn.setUseCaches(false);
////
////            try ( DataOutputStream dos = new DataOutputStream(conn.getOutputStream())) {
////                dos.writeBytes(strrgs);
////            }
////
////            try ( BufferedReader br = new BufferedReader(
////                    new InputStreamReader(
////                            conn.getInputStream()))) {
////
////                String line;
////
////                while ((line = br.readLine()) != null) {
////                    System.out.println("api line: " + line);
////                }
////            }
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////        return "fakkeeeeedddd";
////    }
////}
