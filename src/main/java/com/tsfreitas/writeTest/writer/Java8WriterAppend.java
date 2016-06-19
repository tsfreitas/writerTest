package com.tsfreitas.writeTest.writer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

import org.springframework.stereotype.Component;

//@Component
public class Java8WriterAppend implements Writer {

	@Override
	public void writeFile(String fileName, List<String> lines) throws IOException {

		Path path = Writer.createPath(fileName);
		
		Files.createFile(path);

		for (String line : lines) {
			Files.write(path, line.getBytes(), StandardOpenOption.APPEND);
		}

	}

}
