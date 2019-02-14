package array;

import java.util.Arrays;
import java.util.List;

/*import java.util.*;

public class MapEQ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<ToDos, String> m = new HashMap<ToDos, String>();
		ToDos t1 = new ToDos("Monday");
		ToDos t2 = new ToDos("Monday");
		ToDos t3 = new ToDos("Tuesday");
		m.put(t1, "Dolaundary");
		m.put(t2, "paybills");
		m.put(t3, "cleanattic");
	}
}

class ToDos{
	String day;
	ToDos(String d){day=d;}
	public boolean equals(Objects o) {
		return((ToDos)o).day==this.day;
	}
	//public int hashCode(){return 9;}
}}*/
class MapEQ {
	public static double sumOfList(List<? extends Number> list) {
		double s = 0.0;
		for (Number n : list)
			s += n.doubleValue();
		return s;
	}

	public static void main(String args[]) {
		List<Double> ld = Arrays.asList(1.2, 2.3, 3.5);
		System.out.println(sumOfList(ld));
	}
}
