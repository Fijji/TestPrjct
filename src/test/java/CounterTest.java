
import org.junit.*;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Tests for {@link Counter}
 * @author Kyryl Potapenko
 */
public class CounterTest extends Assert{

    Path filePath;
    String testfilename;
    String absolutePath;
    Long rowsExpected;

    public CounterTest() {
    testfilename = "src\\test\\resources\\CounterTestFile.java";
    filePath = Paths.get(testfilename);
    absolutePath = filePath.toAbsolutePath().toString();
    rowsExpected = 37L;
    }

    @Test
   public void getNumberOfLines(){
    Long result = Counter.getNumberOfLines(absolutePath);

    assertEquals(rowsExpected, result);
    }

    @Test
    public void getFilePath() {
     Path path = Counter.getFilePath(testfilename);

     assertEquals(path, filePath);
    }


}