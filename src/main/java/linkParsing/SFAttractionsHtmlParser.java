package linkParsing;

import java.util.ArrayList;
import java.util.List;

/** Extract valid html links without the fragment from the given input html file.
 *  Please see touristInfo.html */
public class SFAttractionsHtmlParser {
    public static final String REGEX = ""; // regular expression for extracting the links

    /** Return a list of valid html links without the fragment (that starts with #)
     * @param filename input file
     * @return a list of valid links represented as strings
     */
    public static List<String> getValidLinks(String filename) {
        List<String> links = new ArrayList<>();
        // FILL IN CODE:

        return links;
    }

    /** Write a list of links to the html file, make each link clickable using the <a></a> tags
     *
     * @param links a list of valid links
     * @param outputFilename html file
     */
    public static void writeToHtmlFile(List<String> links, String outputFilename) {
        // FILL IN  CODE:

    }

    public static void main(String[] args) {
        List<String> links = getValidLinks("input/touristInfo.html");
        System.out.println(links);
        writeToHtmlFile(links, "result.html"); // output all the valid links (without the fragment) to another html file
        // The expected output is in expectedResult.html
    }
}
