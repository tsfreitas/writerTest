package com.tsfreitas.writeTest.business;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tsfreitas.writeTest.resource.LoremResource;
import com.tsfreitas.writeTest.writer.Writer;

@Component
public class MyBusiness {

	private LoremResource resource;

	private Map<String, Writer> writers;

	@Autowired
	public MyBusiness(LoremResource resource, Map<String, Writer> writers) throws IOException {
		this.resource = resource;
		this.writers = writers;
		createFile();
	}

	public void createFile() throws IOException {

		// Cria conteúdo
		List<String> content = createContent(2048);

		// Grava arquivo
		writeIt(content);

	}

	private List<String> createContent(int megaBytesInSize) {
		long aTime = System.currentTimeMillis();
		List<String> content = resource.giveMeALotOfText(megaBytesInSize);
		long seconds = TimeUnit.MILLISECONDS.toSeconds((System.currentTimeMillis() - aTime));

		System.out.println(String.format("%d MB de dados criados em %d segundos", megaBytesInSize, seconds));

		return content;
	}

	private void writeIt(List<String> content) throws IOException {
		for (Entry<String, Writer> entry : writers.entrySet()) {
			long aTime = System.currentTimeMillis();
			String writerName = entry.getKey();
			System.out.println("Testando writer: " + writerName);

			entry.getValue().writeFile(writerName, content);

			long seconds = TimeUnit.MILLISECONDS.toSeconds((System.currentTimeMillis() - aTime));
			System.out.println(String.format("Writer %s tempo %d segundos", writerName, seconds));

			// Apaga arquivo ... não tenho tanto espaço assim em disco ;)
			Writer.deleteFile(writerName);
		}
	}

}
