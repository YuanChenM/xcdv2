package com.framework.create.tools.utils;

import java.io.File;
import java.util.List;

public class FileUtils {

	private FileUtils() {
	}

	public static boolean mkdir(String path) {
		File file = new File(path);
		file = new File(getParentPath(path));

		return file.mkdirs();
	}

	public static String getParentPath(String path) {
		File file = new File(path);
		return file.getParent();
	}

	public static void findAllFile(File file, String fileSuffix, List<File> javaFiles) {
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			for (int i = 0; i < files.length; i++) {
				findAllFile(files[i], fileSuffix, javaFiles);
			}
		}
		else {
			if (file.getName().endsWith(fileSuffix)) {
				javaFiles.add(file);
			}
		}
	}
	
}
