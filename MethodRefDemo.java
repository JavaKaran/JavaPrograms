interface StringFunc{
	String func(String n);
}
class MyStringOps {
	static String strReverse(String str) {
		String result = "";
		int i;
		for(i=str.length()-1;i>=0;i--) {
			result += str.charAt(i);
			
		}
		return result;
	}
	
}
public class MethodRefDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String instr = "Lambdas add power to java";
		String outstr;
		
		MyStringOps stringops = new MyStringOps();
		outstr = stringops.strReverse(instr);
		
		System.out.println("Original String:"+instr);
		System.out.println("String Reversed:"+outstr);
		
	}

}
