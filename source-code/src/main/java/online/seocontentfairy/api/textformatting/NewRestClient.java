///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package online.seocontentfairy.api.textformatting;
//
//import java.io.IOException;
//import java.net.URI;
//import java.net.URISyntaxException;
//import java.net.http.HttpClient;
//import java.net.http.HttpRequest;
//import java.net.http.HttpResponse;
//
///**
// *
// * @author technical-writing
// */
//public class NewRestClient {
//
////    private static final String POST_URL = "http://localhost:8080/text-conversion/selective-rewrite-text-content";
////    private static final String USER_AGENT = "Mozilla/5.0";
//    public static String postcall(String contentRewriteArguments) throws IOException, InterruptedException, URISyntaxException {
//
//        RESTUtil.getResponseStatusCode();
//
////        System.out.println("enter post call");
////
//        String TARGET_URL = "http://159.89.178.126:28444/content/rewrite-content";
////
////        URI targetURI = new URI(TARGET_URL);
////        HttpRequest httpRequest = HttpRequest.newBuilder()
////                .uri(targetURI)
////                .GET("")
////                .build();
////
//        HttpClient httpClient = HttpClient.newHttpClient();
////
////        System.out.println("GET HERE");
////
////        HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
////        System.out.println(response.body());
////        return response.body();
//
//        //   String POST_URL = "https://jsonplaceholder.typicode.com/todos/";
//        URI postURI = new URI(TARGET_URL);
//
//        System.out.println("args: " + contentRewriteArguments);
//
//        //    String postBody
//        //   = //" content: '" + contentRewriteArguments + "'"
//        //"" + "    body: 'bar',\n"
//        // + "    userId: 1,";
//        HttpRequest httpRequestPost = HttpRequest.newBuilder()
//                .uri(postURI)
//                // .POST(HttpRequest.BodyPublishers.ofString(postBody))
//                .POST(HttpRequest.BodyPublishers.ofString("{\"content2\": value, \"content\": \"another value\"}"))
//                .build();
//
//        System.out.println("calling the reqest");
//
//        HttpResponse<String> postResponse = httpClient.send(httpRequestPost, HttpResponse.BodyHandlers.ofString());
//        System.out.println("post request body: " + postResponse.body());
//        return postResponse.body();
//
//    }
//}
