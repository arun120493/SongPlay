package array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex {
	public static void main(String[] args) throws Exception {

		int n = 0;
		System.out.println("enter a no:");

		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in)))

		{
			n = Integer.parseInt(br.readLine());

		}
		System.out.println(n);
	}
}
