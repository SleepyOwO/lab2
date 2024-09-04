import java.util.regex.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Pattern reg = Pattern.compile("^#([a-fA-F0-9]{6})");

        while(true){
            String test = in.next();

            Matcher match = reg.matcher(test);
            Boolean res = match.matches();

            System.out.println(res);
        }
    }
}