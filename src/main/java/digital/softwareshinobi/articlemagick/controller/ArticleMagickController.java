package digital.softwareshinobi.articlemagick.controller;

import digital.softwareshinobi.articlemagick.util.SpecialTextFormattingUtility;
import digital.softwareshinobi.articlemagick.util.TextWorkerUtility;
import java.util.Map;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("")
public class ArticleMagickController {

    public ArticleMagickController() {

        System.out.println();
        System.out.println("##");
        System.out.println("## init > ArticleMagickController");
        System.out.println("##");
        System.out.println();

    }

    @GetMapping("/")
    public String landing() {

        return "ArticleMagickController API";

    }

    @GetMapping("/health-check")
    public String healthCheck() {

        return "ArticleMagickController API Is Up!";

    }

    @PostMapping({"/convert-to-permalink"})
    public String convertToPermalink(@RequestBody final String textToConvert) {

        System.out.println("hello?");

        System.out.println("textToConvert?" + textToConvert);

        String formattedTextContent = textToConvert.toLowerCase().trim().replaceAll("[\\n\\s]+", "-");

        formattedTextContent = formattedTextContent.replaceAll("\\?\\.", "?");

        formattedTextContent = formattedTextContent.trim();

        return formattedTextContent;

    }

    @PostMapping("/simple-text-format")
    public String simpleTextFormat(@RequestBody String textContentToBeFormatted) {

        System.out.println("enter :: simpleTextFormat()");

        System.out.println("textContentToBeFormatted");

        System.out.println(textContentToBeFormatted);

        JSONObject ox = new JSONObject(textContentToBeFormatted);

        System.out.println("JSONObject: ");

        System.out.println(ox);

        String originalContent = ox.getString("originalContent");

        String formattedTextContent = SpecialTextFormattingUtility.cleanAndFormatText(originalContent);

        formattedTextContent = formattedTextContent.replaceAll("\\?\\.", "?");

        formattedTextContent = formattedTextContent.trim();

        return formattedTextContent;

    }

    @PostMapping("/calculate-text-similarity-percentage")
    public Double calculateTextSimilarityPercentage(@RequestBody Map requestPayLoad) {

        System.out.println("enter > calculateTextSimilarityPercentage()");

        JSONObject ox = new JSONObject(requestPayLoad);

        System.out.println("requestPayLoad / " + requestPayLoad);

        System.out.println(requestPayLoad);

        String originalContent = ox.getString("originalContent")
                .toLowerCase().replaceAll("\\n+", " ").replaceAll("\\s+", " ").trim();

        String rewrittenContent = ox.getString("rewrittenContent")
                .toLowerCase().replaceAll("\\n+", " ").replaceAll("\\s+", " ").trim();

        System.out.println("content / original / " + originalContent);

        System.out.println("content / rewrite / " + rewrittenContent);

        Double textSimilarityPercentage = TextWorkerUtility.calculateTextSimilarityPercentage(
                                
                originalContent,
                
                rewrittenContent
                
        );

        System.out.println(" return / " + textSimilarityPercentage);

        System.out.println("exit < calculateTextSimilarityPercentage()");

        return textSimilarityPercentage;

    }

}
