import com.services.iInputOutput;

public class FakeInputOutput implements iInputOutput {
    String writtenContent;

    @Override
    public void write(String content, String path) {
        this.writtenContent = content;
    }
}
