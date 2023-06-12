package online.textformatdashboard.api;

import java.io.IOException;
import java.net.URISyntaxException;
import online.textformatdashboard.utility.SpecialTextFormattingUtility;
import online.textformatdashboard.utility.TextWorkerUtility;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("")
public class TextFormatDashboardController {

    public TextFormatDashboardController() {

        System.out.println();
        System.out.println("*** ");
        System.out.println("*** init -- textformatdashboard.online API");
        System.out.println("*** ");
        System.out.println();

    }

    @GetMapping("/health-check")
    public String returnHealthCheckContentJSON() {
        return "textformatdashboard.online API Is Up!";
    }

    @GetMapping("/hello-world")
    public String respondHelloWorld() {
        return "Hello World!";
    }

    @GetMapping("/hello-universe")
    public String respondHelloUniverse() {
        return "Hello, Universe!";
    }

    @PostMapping("/simple-text-format")
    public String prepareTextContentForRewriting(@RequestBody String userContentToBeRewritter) {

       System.out.println("the user string: ");
        System.out.println(userContentToBeRewritter);
        String returnC = SpecialTextFormattingUtility.facade(userContentToBeRewritter);

        // System.out.println("retunr c: " + returnC);
        return returnC;
    }

    @PostMapping("/calculate-text-percentage-difference")
    public Double calculateTextPercentageDifference(@RequestBody String userContentToBeRewritter) {

        System.out.println(" enter :: calculateTextPercentageDifference()");

        JSONObject ox = new JSONObject(userContentToBeRewritter);

        System.out.println("the user string: ");
        System.out.println(userContentToBeRewritter);

        String  originalContent=   ox.getString("originalContent");
                String   rewrittenContent= ox.getString("rewrittenContent");

                System.out.println("originalContent: "+ originalContent);
        System.out.println("rewrittenContent: "+ rewrittenContent);

        Double returnC = TextWorkerUtility.calculateTextSimilarityPercentage(
                originalContent,
                rewrittenContent
        );

        System.out.println(" returning: "+returnC);
        System.out.println(" enter :: calculateTextPercentageDifference()");

        return returnC;
    }
    //@PostMapping("/selective-rewrite-text-content")
    public String rewriteFormattedContent(@RequestBody String userContentToBeRewritter) throws IOException, InterruptedException, URISyntaxException {

        System.out.println(" enter :: rewriteFormattedContent()");

        System.out.println("the user string: ");
        System.out.println(userContentToBeRewritter);

        return SpecialTextFormattingUtility.rew333rite(userContentToBeRewritter);
    }
}
