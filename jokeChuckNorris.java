import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

public class jokeChuckNorris {
    public static void main(String[] args) {

        StringBuilder builder = new StringBuilder();

        System.out.println("Welcome to Chuck Norris joke generator. \nAuthor of the program Krystian Rybicki");
        Scanner in = new Scanner(System.in);
        for( ; ; ){
        System.out.println("Do you want to hear a joke?");
                String answer = in.nextLine();
            if( answer.equalsIgnoreCase("quit"))break;


            if (answer.equals("yes")) {

                try {

                    URL url = new URL("https://api.chucknorris.io/jokes/random");
                    InputStream is = url.openStream();
                    BufferedReader bufferedReader = new BufferedReader(
                            new InputStreamReader(is)
                    );

                    String line = new String();

                    while ((line = bufferedReader.readLine()) != null) {
                        builder.append(line);
                        int index = builder.indexOf("value");
                        builder.delete(0, index + 8);
                        builder.delete(builder.length() - 2, builder.length());


                        System.out.println("Random joke by Chuck Norris: \n" + builder.toString());
                        break;
                    }


                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (answer.equals("no")) {
                System.out.println("Maybe another time");
            } else {
                System.out.println("write yes or no");
            }
            System.out.println("if you want to quit, type quit");

            }
        }

    }
