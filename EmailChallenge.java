import java.net.*;
import java.io.*;
import java.util.Scanner;

public class EmailChallenge {

    public static void main(String[] args){
        System.out.println(" - Press Enter to stop");
        Scanner read = new Scanner(System.in);
        String emailID;
        String startURL = "https://www.ecs.soton.ac.uk/people/";
        String fullURL;
        String page;

        System.out.print("Enter the email ID: ");//Get email ID
        emailID = read.nextLine();

        while(!emailID.equals("")){
            fullURL = startURL + emailID;//Create full URL

            try {
                URL webpage = new URL(fullURL);
                BufferedReader reader = new BufferedReader(new InputStreamReader(webpage.openStream()));
                do{
                    page = reader.readLine();
                }while(!page.contains("property=\"name\">"));
                
                int index = page.indexOf("property=\"name\">");
                page = page.substring(index);
                int first = page.indexOf(">") + 1;
                int last = page.indexOf("<") - 1;
                page = page.substring(first,last);
                System.out.println(page);

            }
            catch(Exception MalformedURLException){
                System.out.println("Invalid email ID");
            }

            System.out.print("Enter the email ID: ");//Get email ID
            emailID = read.nextLine();

        }
    }
}
