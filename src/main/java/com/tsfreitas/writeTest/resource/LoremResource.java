package com.tsfreitas.writeTest.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class LoremResource {

	private String line = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Done lreet laci volpat. Phases eu auctor tortor. Vestibulum tempor, mi vitae pulvinar molestie, sem sapien egestas ipsum, a congue velit enim eget urna. Pellentesque habitant morbi tristi"
			+ System.lineSeparator();

	public List<String> giveMeALotOfText(int megabytes) {
		List<String> oneMega = giveMeOneMegaByte();
		
		List<String> fullFile = new ArrayList<>();
		
		for (int i = 0; i < megabytes; i++) {
			fullFile.addAll(oneMega);
		}

		return fullFile;
	}

	public List<String> giveMeOneMegaByte() {
		// 4 lines = 1 kiloByte
		List<String> oneMegaByte = new ArrayList<>();
		for (int i = 0; i < 4 * (1024); i++) {
			oneMegaByte.add(line);
		}

		return oneMegaByte;
	}

}
