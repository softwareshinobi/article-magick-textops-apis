package digital.softwareshinobi.articlemagick.controller;

import digital.softwareshinobi.articlemagick.utility.SpecialTextFormattingUtility;
import digital.softwareshinobi.articlemagick.utility.TextWorkerUtility;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
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

    @GetMapping("/health")
    public String healthCheck() {

        return "OK";

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

    @PostMapping("/convert-to-permalink")
    public String convertToPermalink(@RequestBody final String textToConvert) {

        String formattedTextContent = textToConvert.toLowerCase().trim().replaceAll("[\\n\\s]+", "-");

        formattedTextContent = formattedTextContent.replaceAll("\\?\\.", "?").trim();

        return formattedTextContent;

    }

    @PostMapping("/convert-from-permalink")
    public String convertFromPermalink(@RequestBody final String textToConvert) {

        System.out.println("enter > convertFromPermalink()");

        final Pattern WORD_SEPARATOR_PATTERN = Pattern.compile("-|\\s+");

        StringBuilder sentence = new StringBuilder();

        boolean capitalizeNext = true;

        for (String word : WORD_SEPARATOR_PATTERN.split(textToConvert)) {

            if (capitalizeNext) {

                sentence.append(Character.toUpperCase(word.charAt(0)));

                sentence.append(word.substring(1));

            } else {

                sentence.append(word);

            }

            sentence.append(" ");

            capitalizeNext = false;

        }

        return sentence.toString().trim();

    }

    //@PostMapping("/keyword-density")
    //broken, not what i want
    private static Map<String, Double> extractTwoTailKeywordDensity(String text, List<String> keywords) {

        Map<String, Double> keywordDensities = new HashMap<>();

        String[] words = text.toLowerCase().split("\\s+");

        for (int i = 0; i < words.length - 1; i++) {

            String twoTailKeyword = words[i] + " " + words[i + 1];

            // Check if the 2-tail keyword is in the list
            if (keywords.contains(twoTailKeyword)) {

                // Update the keyword density
                keywordDensities.put(twoTailKeyword, keywordDensities.getOrDefault(twoTailKeyword, 0.0) + 1);

            }

        }

        // Calculate and return densities as percentages
        for (Map.Entry<String, Double> entry : keywordDensities.entrySet()) {

            entry.setValue(entry.getValue() / (words.length - 1) * 100);

        }

        return keywordDensities;

    }

}
