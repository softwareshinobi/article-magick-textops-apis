package online.seocontentfairy.api.textformatting;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import online.softwareshinobi.oldefashioned.utility.FileUtil;
import online.softwareshinobi.oldefashioned.utility.StringUtil;

public class ContentFormatterHelperUtility {

    public static final String rewrite_DELIMITER = "!!";

    public static final String emptystring = "";

    public static final String SPECIAL_DELIMITER = " @@ ";

    public static final String OUTER_DELIMITER = "";

    public static String facade(String content) {
        System.out.println("enter facade");
//        Map<String, String> data = new HashMap<>();
//        data.put("title", "A dagfafasfasdfsafsaasfffsfasffsf");
//        //data.put("state", "CA");
//
//        String result = HttpRequest.post("http://localhost:8080/text-conversion/format-text-content").form(data).body();
////        if (HttpRequest.post("http://localhost:8080/text-conversion/format-text-content").form(data)..created()) {
////            System.out.println("User was created");
////        }
//        System.out.println("Usedddddr was created");
//        System.out.println("result from api:");
//        System.out.println(result);
//        System.out.println("exit facade");
//        System.exit(30);
        File tempFile = new File(UUID.randomUUID() + ".txt");

        FileUtil.writeToFile(content, tempFile);

        String returnString = facade(tempFile);

        tempFile.delete();
        tempFile = null;

        return returnString;
    }

    private static String facade(File filePath) {

        List<String> contentFromFile = ContentFormatterHelperUtility.parseFileLinesFromFile(filePath);
        FileUtil.writeToFile(contentFromFile, new File(filePath + "pass-1-simple-save.md"));

        contentFromFile = ContentFormatterHelperUtility.removeEmptyContent(contentFromFile);
        FileUtil.writeToFile(contentFromFile, new File(filePath + "pass-2-remove-spaces.md"));

        contentFromFile = ContentFormatterHelperUtility.removeBadContent(contentFromFile);
        FileUtil.writeToFile(contentFromFile, new File(filePath + "pass-2-bad-content-spaces.md"));

        contentFromFile = ContentFormatterHelperUtility.toLowerCaseAll(contentFromFile);
        FileUtil.writeToFile(contentFromFile, new File(filePath + "pass-3-to-lowercase.md"));

        contentFromFile = ContentFormatterHelperUtility.splitContent(contentFromFile);
        FileUtil.writeToFile(contentFromFile, new File(filePath + "pass-4-split-sentences.md"));

        contentFromFile = ContentFormatterHelperUtility.capitalizeContent(contentFromFile);
        FileUtil.writeToFile(contentFromFile, new File(filePath + "pass-5-correct-capitalization.md"));

//        contentFromFile = ContentFormatterHelperUtility.addSpacesAndStuff(contentFromFile);
//        FileUtil.writeToFile(contentFromFile, new File(filePath + "pass-7-add-spaces-and-stuff.md"));
        contentFromFile = prepContentForRewriteFormat(contentFromFile);
        FileUtil.writeToFile(contentFromFile, new File(filePath + "convert-to-rewrite-format.dat.rytr"));

        File fff = new File(filePath + "-final.md");
        fff.delete();

        ContentFormatterHelperUtility.writeFinalFile(contentFromFile, fff);
        //   FileUtil.writeToFile(contentFromFile, new File(filePath + "-final.md"));

        ContentFormatterHelperUtility.printCurrentContent(contentFromFile);

        StringBuilder buf = new StringBuilder();

        for (Object o : contentFromFile) {
            buf.append(o);
            buf.append("\n");
            buf.append("\n");
        }
        return buf.toString().trim();
    }

    private static List<String> prepContentForRewriteFormat(List<String> contentFromFile) {
        List<String> list = new ArrayList();

        for (String cc : contentFromFile) {
            //    System.out.println("c: " + cc);

            // if (!cc.trim().isBlank()) {
            //  String s = " [ " + cc + SPECIAL_DELIMITER + cc + " ] ";
            String s = OUTER_DELIMITER + cc + SPECIAL_DELIMITER + cc + OUTER_DELIMITER;
            list.add(s.trim());

            //  }
        }
        return list;
    }

    public static List<String> parseFileLinesFromFile(final File file) {

        //   System.out.println("stating...");
        String[] c = FileUtil.readFileContents(file);
        List<String> list = new ArrayList();
        for (String cc : c) {
            // System.out.println("c: " + cc);

            if (!cc.trim().isBlank()) {
                list.add(cc);
            }
        }
        return list;
    }

    public static List<String> removeEmptyContent(List<String> content) {
        List<String> list = new ArrayList();

        for (String cc : content) {
            //    System.out.println("c: " + cc);

            if (!cc.trim().isBlank()) {
                list.add(cc.trim());

            }
        }
        return list;
    }

    public static List<String> toLowerCaseAll(List<String> content) {
        List<String> list = new ArrayList();

        for (String cc : content) {
            //    System.out.println("c: " + cc);

            //if (!cc.trim().isBlank()) {
            list.add(cc.toLowerCase());

            //}
        }
        return list;
    }

    public static void printCurrentContent(List<String> content) {
        System.out.println();
        System.out.println("list of all strings to process");
        System.out.println();
        for (String cc : content) {
            System.out.println("content: " + cc);

            //if (!cc.trim().isBlank()) {
            //   list.add(cc.toLowerCase());
            //}
        }
    }

    public static List<String> splitContent(List<String> content) {
        System.out.println();
        System.out.println("list of all strings to process");
        System.out.println();
        List<String> list = new ArrayList();
        for (final String cc : content) {

            System.out.println("in: " + cc);

            if (cc.trim().startsWith("#")) {
                //    System.out.println("skipping b/c header");
                list.add(cc);
//     list.add(StringUtil.toBookCase(cc));
                continue;
            }

            String[] splitOut = cc.split("\\.");

            System.out.println("out: " + cc);
            for (final String split : splitOut) {

                System.out.println("split: " + split);
                list.add(split + ".");
            }
        }
        return list;
    }

    public static List<String> capitalizeContent(List<String> content) {
        System.out.println();
        System.out.println("list of all strings to process");
        System.out.println();
        List<String> list = new ArrayList();
        for (final String cc : content) {

            System.out.println("in: " + cc);

            if (cc.trim().startsWith("#")) {
                //    System.out.println("skipping b/c header");
                list.add(StringUtil.toBookCase(cc));
                continue;
            }

            String[] splitOut = cc.split("\\.");

            System.out.println("out: " + cc);
            for (final String split : splitOut) {

                System.out.println("split: " + split);
                list.add(StringUtil.toSentenceCase(split) + ".");
            }
        }
        return list;
    }

    public static List<String> addSpacesAndStuff(List<String> content) {
        System.out.println();
        System.out.println("list of all strings to process");
        System.out.println();
        List<String> list = new ArrayList();

        String BLANKLINE = "";

        for (final String cc : content) {

            System.out.println("in: " + cc);

            if (cc.trim().startsWith("#")) {
                //    System.out.println("skipping b/c header");
                list.add(cc);

                list.add(BLANKLINE);

            } else {
                list.add(cc);

                list.add(BLANKLINE);
            }
        }
        return list;
    }

    public static String rew333rite(String content) throws IOException, InterruptedException, URISyntaxException {

        System.out.println("enter :: rew333rite");

        String[] contenttt = content.split("\n");

        List<String> rewrittenContent = new ArrayList();

        for (String originalText : contenttt) {

            if (originalText.startsWith(rewrite_DELIMITER)) {

                //    System.out.println("marked for rewrite: " + text);
                //   rewriteOrderList.add(text);
                System.out.println(" -> rewrite: " + originalText);

                String isolatedLeft = originalText.split(SPECIAL_DELIMITER)[0].replaceFirst(rewrite_DELIMITER, emptystring);
                //    System.out.println(" -> -> isolated: " + isolatedRight);

                String isolatedRight = originalText.split(SPECIAL_DELIMITER)[1];
                System.out.println(" -> -> isolated: " + isolatedRight);

//                Map<String, String> data = new HashMap<>();
//                data.put("title", "A User");
//                //data.put("state", "CA");
//
//                String result = HttpRequest.post("http://localhost:8080/text-conversion/format-text-content").form(data).body();
////        if (HttpRequest.post("http://localhost:8080/text-conversion/format-text-content").form(data)..created()) {
////            System.out.println("User was created");
////        }
//                System.out.println("Usedddddr was created");
//                System.out.println("result from api:");
//                System.out.println(result);
                System.exit(30);
                String rewrittenText = StringUtil.toLeetSpeak(isolatedRight);
                System.out.println(" -> -> rewriten: " + rewrittenText);

                //  String s = " [ " + cc + SPECIAL_DELIMITER + cc + " ] ";
                String AA = OUTER_DELIMITER + isolatedLeft + SPECIAL_DELIMITER + rewrittenText + OUTER_DELIMITER;
                System.out.println(" <- rewritten: " + AA);

                rewrittenContent.add(AA);

            } else {
                rewrittenContent.add(originalText);
            }
        }

        StringBuilder buf = new StringBuilder();

        for (String o : rewrittenContent) {
            buf.append(o.trim());
            buf.append("\n");
            // buf.append("\n");
        }

        return buf.toString().trim();
    }

    public static List<String> removeBadContent(List<String> contentFromFile) {
        return contentFromFile;
    }

    public static void writeFinalFile(List<String> contentFromFile, File file) {
        for (String x : contentFromFile) {
            FileUtil.writeToFile(x, file);
        }
    }

}
