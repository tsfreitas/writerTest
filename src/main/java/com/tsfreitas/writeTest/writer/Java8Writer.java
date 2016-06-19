package com.tsfreitas.writeTest.writer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Java8Writer implements Writer {

	@Override
	public void writeFile(String fileName, List<String> lines) throws IOException {

		Path path = Writer.createPath(fileName);

		Files.write(path, lines);

	}

}
