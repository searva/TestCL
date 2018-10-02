package test;

public class LinkageErrorUtil {

	public void print() {
		System.out.println("Working!!!");
		
	}
	
	@Override
	public String toString() {
		return "Util, classloader " + this.getClass().getClassLoader();
	}

}
