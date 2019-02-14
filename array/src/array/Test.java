package array;

public class Test {

	public static void main(String[] args) {
		int i = 5;
		int temp = 1;
		for (int j = i; j > 0; i--) {
			temp = temp * j;
		}
		System.out.println("factorial of" + i + "=" + temp);
	}

}