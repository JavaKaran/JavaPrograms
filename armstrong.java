import java.util.*;

public class armstrong {
	
	public static void main(String[] args) {
	
    int original,remainder;
    int result=0;
    System.out.println("----FINDING OUT ARMSTRONG NUMBER----");
    System.out.println("Please Enter Number-");
	try (Scanner sc = new Scanner(System.in)) {
		int num = sc.nextInt();
		original=num;
		while(original!=0) {
			remainder=original%10;
			result=(int) (result + Math.pow(remainder,raise(num)));
			original/=10;
		} 
		System.out.println("Value of number-"+num);
		System.out.println("length of number entered-"+raise(num));
		if(result==num) 
			System.out.println("Number entered is an armstrong number");
		else
			System.out.println("Number entered is not an armstrong number");
	}
}

public static int raise(int num){
	int count=0;
	while(num!=0) {
		count++; 
		num=num/10;
	 }
	
	 return count;
	}

}