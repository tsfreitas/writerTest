package com.tsfreitas.writeTest.writer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public interface Writer {

	public static final String BASE_PATH = "/Users/tsfreitas/Documents/workspace/concepts/dataTest";

	public void writeFile(String fileName, List<String> lines) throws IOException;
	
	static void deleteFile(String fileName) throws IOException {
		Path path = createPath(fileName);
		
		Files.delete(path);
	}

	static Path createPath(String fileName) {
		return Paths.get(BASE_PATH, fileName);
	}

}
