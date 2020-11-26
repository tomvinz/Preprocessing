import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Preprocessor {
    /**
     * The token used to indicate the beginning of a new sentence.
     */
    public static final String SENTENCE_START = "<s>";
    /**
     * The token used to indicate the end of a sentence.
     */
    public static final String SENTENCE_END = "</s>";

    /**
     * Preprocesses the given texts and returns the list of tokens.
     *
     * @param text the input text
     * @return the list of tokens extracted from the given text
     */
    public static List<String> preprocess(String text) {
        List<String> tokens = new ArrayList<String>();
        //List<String> textbeforeprocessed=new ArrayList<String>();
        String[] textbeforeprocessed=null;
        int index=0;
        int append=0;
        String textcopy=null;
        //textcopy = textcopy.replaceAll("[^a-zA-Z0-9]", "");
        // to get tokens of string


        textbeforeprocessed = text.split("[ |\"|\'|/|[^a-zA-Z0-9.?!]]");
        tokens.add(SENTENCE_START);
        while(index<textbeforeprocessed.length){
            textcopy=textbeforeprocessed[index].toLowerCase();
            while(textcopy.length()>0) {
                //System.out.println(Character.toString(textcopy.charAt(textcopy.length() - 1)));
                if (Character.toString(textcopy.charAt(textcopy.length() - 1)).equals(".") || Character.toString(textcopy.charAt(textcopy.length() - 1)).equals("!") || Character.toString(textcopy.charAt(textcopy.length() - 1)).equals("?")) {
                    append = 1;
                }
                textcopy = textcopy.replaceAll("[^a-zA-Z0-9]", "");

                tokens.add(textcopy);
                if (append == 1) {
                    tokens.add(SENTENCE_END);
                    append = 0;
                    if (index + 1 < textbeforeprocessed.length) {
                        tokens.add(SENTENCE_START);
                    }
                } else {
                    //System.out.println("There seems to be something wrong");
                }
               // index++;
                break;
            }
            index++;
        }
        //for(int i=0; i<textbeforeprocessed.length;i++)
        //System.out.println("The output is" + textbeforeprocessed[i]);
        System.out.println("The output is" + tokens);

        return tokens;

    }
}


// This line should make sure that compile errors are directly identified when executing this cell
// (the line itself does not produce any meaningful result)
//Preprocessor.preprocess("").clear();