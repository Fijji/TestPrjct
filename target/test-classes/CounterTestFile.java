import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class CounterTestFile {
    // TestLine
    /*
    *TestLine
    * TestLine
    */
    public static Long getNumberOfLines(String absolutePath) {
       Stream<String> streamFromFile = openFileLinesStream(getFilePath(absolutePath));
        return streamFromFile
                .filter(getPredicates().stream().reduce(x -> true, Predicate::and))
                .count();
    }

    private static List<Predicate<String>> getPredicates() {
        List<Predicate<String>> allPredicates = new ArrayList<>();
        allPredicates.add(line -> !line.trim().startsWith("//"));
        allPredicates.add(line -> !line.trim().startsWith("/*"));
        allPredicates.add(line -> !line.trim().endsWith("*/"));
        allPredicates.add(line -> !line.trim().startsWith("*"));
        allPredicates.add(line -> !line.isEmpty());
        return allPredicates;
    }

    private static Stream<String> openFileLinesStream(Path filePath) {
        try {
            return Files.lines(filePath);
        } catch (IOException e) {
            throw new FileReaderException("Cannot create stream of file lines!", e);
        }
    }

    public static Path getFilePath(String fileName)  {
        Objects.requireNonNull(fileName);
        return Paths.get(fileName);
    }
}