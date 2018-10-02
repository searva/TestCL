package test;

import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class LinkageError {
	
	
	public static void main(String[] args) {
	
		String path = System.getProperty("user.dir");
		path = path.concat("/target");
		try {
			URLClassLoader clejb = new URLClassLoader(new URL[] {new URL("file:///".concat(path).concat("/TestCL-0.0.1-SNAPSHOT.jar"))}) {
				@Override
				public Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
					Class<?> c = findLoadedClass(name);
					if (c == null && name.startsWith("test")) {
						 c = findClass(name);
					}else {
						c = super.loadClass(name, resolve);
					}
					return c;
				}
			};
			
			URLClassLoader clweb = new URLClassLoader(new URL[] {new URL("file:///".concat(path).concat("/TestCL-0.0.1-SNAPSHOT.jar"))}, clejb) {
				@Override
				public Class<?> loadClass(String name) throws ClassNotFoundException {
					Class<?> c = findLoadedClass(name);
					if (c == null &&  ("test.LinkageErrorServlet".equals(name)) || ("test.LinkageErrorUtil".equals(name))) {
						 c = findClass(name);
					}else {
						c = super.loadClass(name);
					}
					return c;
				}
			};
			
			Class<?> clazz = clweb.loadClass("test.LinkageErrorServlet");
			//test.LinkageErrorServlet<clweb>
			
			Object servlet = clazz.newInstance();
			
			
			servlet.getClass().getMethod("doSomething").invoke(servlet);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		

	}
}
