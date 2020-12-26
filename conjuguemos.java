import java.util.*;
public class conjuguemos {
	
static String Pronouns[] = {"Yo","Tú","Él, Ella, Ustedes","Nosotros","Vosotros","Ellos, Ellas, Ustedes"};

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("***Welcome to the Spanish verb conjugation trainer!***\nType a number from the menu to continue.\n");
		String Menu[] = {"Quit","Present Indicative","Preterite","Imperfect"};
		
		String next;
		do {
			for (int i = 0; i < Menu.length; i++) System.out.println(i + ". " + Menu[i]);
			next = input.nextLine();
			if (next.equals("1")) PresentIndicative();
			if (next.equals("2")) Preterite();
			if (next.equals("3")) Imperfect();
			
		} while (!next.equals("0"));
		System.out.println("Thank you for playing Spanish verb conjugation trainer. Practice makes Permanent!");
		
	}
	
	public static void PresentIndicative() {
			
		
	}
	public static void Preterite() {
		
		
		
	}
	public static void Imperfect() {
		System.out.println("---Imperfect Mode---\nRespond 0 to Quit");
		
		while (true) {
			
			
		}
		
	}

}
