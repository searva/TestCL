package test;

public class LinkageErrorEJB {

	public void doSimething(LinkageErrorUtil util) {
		System.out.println("LinkageErrorEJB::doSomething resolved by CL = " + this.getClass().getClassLoader() + "; Util resolved by CL = " +util.getClass().getClassLoader());
		util.print();
	}
	
	

}
