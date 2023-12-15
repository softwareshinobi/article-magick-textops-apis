package digital.softwareshinobi.articlemagick;

import java.io.IOException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ArticleMagickAPI {

    public static void main(final String[] commandLineArguments) throws IOException {

        System.out.println("launch > ArticleMagickAPI");

        SpringApplication.run(ArticleMagickAPI.class, commandLineArguments);
        
    }

}
