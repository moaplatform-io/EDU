package sm;

public class MainTest {

	public static void main(String[] args) throws CloneNotSupportedException {

		
		
		HUmen hUmen=new HUmen();
		hUmen.setAge(111);
		hUmen.setName("ss");
		
		HUmen hUmen2=hUmen.clone();
	
		hUmen.clone();
		hUmen.setName("sdfsddsf");
		
		System.out.println(hUmen.equals(hUmen2));
		
		System.out.println(hUmen2);
		System.out.println(hUmen);
		
		
	}

}
