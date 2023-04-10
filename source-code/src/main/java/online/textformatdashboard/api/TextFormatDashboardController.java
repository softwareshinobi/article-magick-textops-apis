package online.textformatdashboard.api;

import java.io.IOException;
import java.net.URISyntaxException;
import online.textformatdashboard.utility.SpecialTextFormattingUtility;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/text-conversion")
public class TextFormatDashboardController {

    public TextFormatDashboardController() {
        System.out.println("init -- SEO Content Fairy Rewrite API");
    }

    @GetMapping("/health-check")
    public String returnHealthCheckContentJSON() {
        return "SEO Content Fairy Rewrite API Is Up & Healthy!";
    }

    @PostMapping("/format-text-content")
    public String prepareTextContentForRewriting(@RequestBody String userContentToBeRewritter) {

        System.out.println("the user string: ");
        System.out.println(userContentToBeRewritter);

        String returnC = SpecialTextFormattingUtility.facade(userContentToBeRewritter);
        System.out.println("retunr c: " + returnC);
        return returnC;
    }

    @PostMapping("/selective-rewrite-text-content")
    public String rewriteFormattedContent(@RequestBody String userContentToBeRewritter) throws IOException, InterruptedException, URISyntaxException {

        System.out.println(" enter :: rewriteFormattedContent()");

        System.out.println("the user string: ");
        System.out.println(userContentToBeRewritter);

        return SpecialTextFormattingUtility.rew333rite(userContentToBeRewritter);
    }
}
