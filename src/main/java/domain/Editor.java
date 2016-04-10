package domain;

import services.iInputOutput;

import java.io.IOException;

public class Editor {
    private iInputOutput io;

    public Editor(iInputOutput io) {
        this.io = io;
    }

    public void save(String someText,String path) throws IOException {
        io.write(someText,path);
    }
}
