import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    public static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString() throws IOException {
        String line;
        try {
            line = bufferedReader.readLine();
            return line;
        }catch (FileNotFoundException e){
            ConsoleHelper.writeMessage("Please retry.");
           line = readString();
        }
        return null;
    }


}
