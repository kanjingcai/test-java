package com.test.proxy.my;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MyClassLoader extends ClassLoader {

	private File dir;

	public MyClassLoader(String path) {
		dir = new File(path);
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		FileInputStream fis = null;
		ByteArrayOutputStream baos = null;
		try {
			if (dir != null) {
				File clazzFile = new File(dir, name + ".class");
				if (clazzFile.exists()) {
					fis = new FileInputStream(clazzFile);
					baos = new ByteArrayOutputStream();

					byte[] buffer = new byte[1024];
					int len;
					while ((len = fis.read(buffer)) != -1) {
						baos.write(buffer, 0, len);
					}

					return defineClass("com.test.proxy.my" +"."+ name,
							baos.toByteArray(), 0, baos.size());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (baos != null) {
				try {
					baos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
}
