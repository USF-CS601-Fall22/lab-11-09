package solution;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SFAttractionsHtmlParser {

    public static final String REGEX = "<a\\s+[^>]*href\\s*=\\s*\"([^\"]+)\"[^>]*";

    public static List<String> getValidLinks(String filename) {
        List<String> links = new ArrayList<>();
        Pattern pattern = Pattern.compile(REGEX);
        StringBuffer sb = new StringBuffer();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
            }
            Matcher m = pattern.matcher(sb.toString());
            while (m.find()) {
                // add the appropriate group from regular expression to list
                String res = m.group(1);
                if (!res.startsWith("#")) {
                    // remove the fragment at the end:
                    res = res.replaceAll("#[^#]+", "");
                    if (!res.isEmpty() && !links.contains(res))
                        links.add(res);

                }
            }

        } catch (IOException e) {
            System.out.println("IOException occurred: " + e);
        }

        return links;
    }

    public static void writeToHtmlFile(List<String> links, String outputFilename) {
        try (PrintWriter pw = new PrintWriter(outputFilename)) {
            pw.println("<!DOCTYPE html> <html><br><body>");
            for (String link: links) {
                pw.println("<a href = \""+ link + "\">" + link + "</a><br>");
            }
            pw.println("</body></html>");

        }
        catch (IOException e) {
            System.out.println(e);
        }

    }

    public static void main(String[] args) {
        List<String> links = getValidLinks("input/touristInfo.html");
        System.out.println(links);
        writeToHtmlFile(links, "result.html"); // output all the valid links to another html file
    }
}
