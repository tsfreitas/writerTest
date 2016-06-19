package com.tsfreitas.writeTest.writer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import org.springframework.stereotype.Component;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

@Component
public class GuavaWriter implements Writer {

	@Override
	public void writeFile(String fileName, List<String> lines) throws IOException {

		Path path = Writer.createPath(fileName);
		File file = path.toFile();

		for (String line : lines) {
			Files.append(line, file, Charsets.UTF_8);
		}

	}

}
