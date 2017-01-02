package com.test.proxy.my;

import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

public class MyProxy {

	protected MyInvocationHandler h;
	
	private static String rt = "\r\t";
	
	public MyProxy(){}
	
	protected MyProxy(MyInvocationHandler h) {
		this.h = h;
	}
	
	//创建一个内存当中的$Proxy0实例
	public static Object createProxyInstance(ClassLoader loader, Class<?> interf,MyInvocationHandler h) throws Exception{
		if(h == null) {
			throw new NullPointerException();
		}
		
		//构造代理类对象
		Method[] methods = interf.getMethods();
		StringBuilder sb = new StringBuilder("package com.test.proxy.my;").append(rt);
		sb.append("import java.lang.reflect.Method;").append(rt);
		sb.append("public class $Proxy0 implements ").append(interf.getName()).append("{").append(rt);
		sb.append("MyInvocationHandler h;").append(rt);
		sb.append("public $Proxy0(MyInvocationHandler h){").append(rt);
		sb.append("this.h = h;").append(rt).append("}");
		sb.append(getMethodString(methods, interf)).append(rt).append("}");
		
		//写入自定义类到文件目录
		String fileName = MyProxy.class.getResource("").getPath()+ "$Proxy0.java";
		File file = new File(fileName);
		FileWriter fw = new FileWriter(file);
		fw.write(sb.toString());
		fw.flush();
		fw.close();
		
		//编译Java类
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
		Iterable<? extends JavaFileObject> units = fileManager.getJavaFileObjects(file);
		CompilationTask task = compiler.getTask(null, fileManager, null, null, null, units);
		task.call();
		fileManager.close();
		
		//编译好的文件加载到内存当中
		MyClassLoader loader2 = new MyClassLoader(MyProxy.class.getResource("").getPath());
		Class<?> proxy0Class = loader2.findClass("$Proxy0");
		Constructor<?> constructor = proxy0Class.getConstructor(MyInvocationHandler.class);
		Object obj = constructor.newInstance(h);
		return obj;
	}

	private static Object getMethodString(Method[] methods, Class<?> interf) {
		StringBuffer sb = new StringBuffer();
		for (Method method : methods) {
			sb.append("public void ").append(method.getName()).append("() throws Throwable {").append(rt);
			sb.append("Method md = ").append(interf.getName()).append(".class.getMethod(\"");
			sb.append(method.getName()).append("\",new Class[]{});").append(rt);
			sb.append(" this.h.invoke(this, md, null);").append(rt).append("}").append(rt);
		}
		return sb.toString();
	}
}
