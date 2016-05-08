import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * 自定义类加载器
 * 
 * @author Administrator
 * 
 */
public class MyClassLoader extends ClassLoader {

	private String name; // 类加载器的名字

	private String path = "d:\\"; // 类加载的路径

	private final String fileType = ".class"; // class文件的扩展名

	public MyClassLoader(String name) {
		super(); // 让系统类加载器称为该类加载的父加载器

		this.name = name;
	}

	public MyClassLoader(ClassLoader parent, String name) {
		super(parent); // 显示指定该类加载器的父加载器

		this.name = name;
	}

	@Override
	public String toString() {
		return this.name;
	}

	private byte[] loadClassData(String name) {
		InputStream is = null;
		byte[] data = null;
		ByteArrayOutputStream baos = null;
		try {

			this.name = this.name.replace(".", "\\");

			is = new FileInputStream(new File(path + name + fileType));
			baos = new ByteArrayOutputStream();

			int ch = 0;
			while (-1 != (ch = is.read())) {
				baos.write(ch);
			}

			data = baos.toByteArray();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				is.close();
				baos.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return data;
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		byte[] data = this.loadClassData(name);  
		return defineClass(name, data, 0, data.length);
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public static void main(String[] args) throws Exception {

		MyClassLoader loader1 = new MyClassLoader("loader1");
		loader1.setPath("d:\\myapp\\serverlib\\");

		MyClassLoader loader2 = new MyClassLoader(loader1, "loader2");
		loader2.setPath("d:\\myapp\\clientlib\\");

		MyClassLoader loader3 = new MyClassLoader(null, "loader3");
		loader3.setPath("d:\\myapp\\otherlib\\");

		test(loader2);
		test(loader3);
	}

	public static void test(ClassLoader loader) throws Exception {
		Class<?> clazz = loader.loadClass("Sample");
		Object object = clazz.newInstance();
	}

}
