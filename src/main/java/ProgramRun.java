import java.io.IOException;

public class ProgramRun {
    public static void main(String[] args) throws IOException{
        ConsoleHelper.writeMessage("Welcome!");
        ConsoleHelper.writeMessage("Enter|Paste your link(absolute path) below:" +"\n");

        String readFileName = ConsoleHelper.readString();
        Long result = Counter.getNumberOfLines(readFileName);

        ConsoleHelper.writeMessage(Counter.getFilePath(readFileName).getFileName()
                           + " contain rows with code: "  + result);

        ConsoleHelper.writeMessage("Have a good day!");
        }

}
