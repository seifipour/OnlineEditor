import domain.Editor;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;


public class EditorTest {

    @Test
    public void test_save_content_into_file() throws IOException {
        FakeInputOutput io =new FakeInputOutput();
        Editor editor = new Editor(io);
        String someText = "some text";
        String somePath = "C:\\Project\\EditorText.txt";
        editor.save(someText, somePath);
        assertEquals(io.writtenContent,someText);
    }

}