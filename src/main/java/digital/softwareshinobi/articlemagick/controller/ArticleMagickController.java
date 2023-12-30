package digital.softwareshinobi.articlemagick.controller;

import digital.softwareshinobi.articlemagick.util.SpecialTextFormattingUtility;
import digital.softwareshinobi.articlemagick.util.TextWorkerUtility;
import java.util.Map;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("article-magick")
public class ArticleMagickController {

    public ArticleMagickController() {

        System.out.println();
        System.out.println("##");
        System.out.println("## init > Article Magick Controller");
        System.out.println("##");
        System.out.println();

    }

    @GetMapping("/")
    public String landing() {

        return "Article Magick API";

    }

    @GetMapping("/health-check")
    public String healthCheck() {

        return "Article Magick API is RUNNING";

    }

    @PostMapping("/simple-format")
    public String simpleTextFormat(@RequestBody Map requestPayLoad) {

        System.out.println("enter > simpleTextFormat()");

        System.out.println("requestPayLoad / " + requestPayLoad);

        String dirtyText = requestPayLoad.get("originalContent").toString();

        System.out.println("content / original / " + dirtyText);

        String cleanText = SpecialTextFormattingUtility.cleanAndFormatText(dirtyText);

        cleanText = cleanText.replaceAll("\\?\\.", "?").trim();

        System.out.println("return / " + cleanText);

        System.out.println("exit < simpleTextFormat()");

        return cleanText;

    }

    @PostMapping("/calculate-similarity")
    public Double calculateTextSimilarityPercentage(@RequestBody Map requestPayLoad) {

        System.out.println("enter > calculateTextSimilarityPercentage()");

        System.out.println("requestPayLoad / " + requestPayLoad);

        String originalContent = requestPayLoad.get("originalContent").toString()
                .toLowerCase().replaceAll("\\n+", " ").replaceAll("\\s+", " ").trim();

        System.out.println("content / original / " + originalContent);

        String rewrittenContent = requestPayLoad.get("rewrittenContent").toString()
                .toLowerCase().replaceAll("\\n+", " ").replaceAll("\\s+", " ").trim();

        System.out.println("content / rewrite / " + rewrittenContent);

        Double textSimilarityPercentage = TextWorkerUtility.calculateTextSimilarityPercentage(
                originalContent,
                rewrittenContent
        );

        System.out.println("return / " + textSimilarityPercentage);

        System.out.println("exit < calculateTextSimilarityPercentage()");

        return textSimilarityPercentage;

    }

    @PostMapping("/convert-permalink")
    public String convertToPermalink(@RequestBody final String textToConvert) {

        String formattedTextContent = textToConvert.toLowerCase().trim().replaceAll("[\\n\\s]+", "-");

        formattedTextContent = formattedTextContent.replaceAll("\\?\\.", "?").trim();

        return formattedTextContent;

    }

}
