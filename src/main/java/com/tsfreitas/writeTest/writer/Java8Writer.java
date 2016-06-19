package com.tsfreitas.writeTest.writer;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

@Component
public class Java8Writer implements Writer {

    @Override
    public void writeFile(String fileName, List<String> lines) throws IOException {

        Path path = Writer.createPath(fileName);

        if (!path.toFile().exists()) {
            Files.createFile(path);

        }

        Files.write(path, lines, StandardOpenOption.APPEND);

    }

}
