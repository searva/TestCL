package test;

public class LinkageErrorServlet {
	
	LinkageErrorEJB ejb = new LinkageErrorEJB();
	//test.LinkageErrorEJB<clEJB>
	
	public void doSomething() {
		
		System.out.println("LinkageErrorServlet::doSomething reolved by CL = " + this.getClass().getClassLoader());
		
		LinkageErrorUtil util = new LinkageErrorUtil();
		
		//util.LinkageErrorUtil<clWeb>
		ejb.doSimething(util);
	}
	
	
}
