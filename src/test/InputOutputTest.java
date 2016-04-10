
import domain.InputOutput;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.BufferedWriter;
import java.io.FileWriter;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@RunWith(PowerMockRunner.class)
@PrepareForTest({InputOutput.class})
public class InputOutputTest {

    @Test
    public void test_files_write_with_expected_parameter_called_when_write_method_called() throws Exception {

        InputOutput io= new InputOutput();
        String someContent = "some content";
        String somePath = "some path";
        BufferedWriter mockedBufferWriter = PowerMockito.mock(BufferedWriter.class);

        PowerMockito.whenNew(BufferedWriter.class).withAnyArguments().thenReturn(mockedBufferWriter);
        io.write(someContent, somePath);
        verify(mockedBufferWriter,times(1)).write(someContent);
        verify(mockedBufferWriter,times(1)).close();
    }

    @Test
    public void test_when_get_writer_invoked_expected_FileWriter_and_buffer_writer_construct() throws Exception {

        String somePath = "some path";
        FileWriter mockedFileWriter = PowerMockito.mock(FileWriter.class);
        BufferedWriter mockedBufferWriter = PowerMockito.mock(BufferedWriter.class);
        InputOutput io = new InputOutput();

        PowerMockito.whenNew(FileWriter.class).withArguments(somePath).thenReturn(mockedFileWriter);
        PowerMockito.whenNew(BufferedWriter.class).withArguments(mockedFileWriter).thenReturn(mockedBufferWriter);
        assertEquals(mockedBufferWriter, io.getWriter(somePath));

    }

}