package com.domain;


import com.services.iInputOutput;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class InputOutput implements iInputOutput {

    public Writer getWriter(String path) throws IOException {
        return new BufferedWriter(new FileWriter(path));
    }

    @Override
    public void write(String content, String path) {
        try{
            Writer writer = getWriter(path);
            writer.write(content);
            writer.close();
        }catch (Exception e){
            System.err.println("Error: " + e.getMessage());
        }
    }
}
