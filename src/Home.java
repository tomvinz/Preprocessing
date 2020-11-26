import java.util.List;

public class Home {

    public static void main(String[] args) {
        System.out.println("Hello World, I am back.");

        String text1 = ":I do not eat this soup. No, I will not eat this soup. Soup is not what I like to eat 24/7.";
        List<String> preProcResult = Preprocessor.preprocess(text1);
    }
}
