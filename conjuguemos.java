import java.util.*;
public class conjuguemos {
	
static String Pronouns[] = {"Yo","T�","�l, Ella, Ustedes","Nosotros","Vosotros","Ellos, Ellas, Ustedes"};

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("Welcome to the Spanish verb conjugation trainer!\nType a number from the menu to continue.\n");
		String Menu[] = {"Quit","Present Indicative","Preterite","Imperfect"};
		
		String next;
		do {
			for (int i = 0; i < Menu.length; i++) System.out.println(i + ". " + Menu[i]);
			next = input.nextLine();
			if (next.equals("1")) PresentIndicative();
			if (next.equals("2")) Preterite();
			if (next.equals("3")) Imperfect();
			
		} while (!next.equals("0"));
		
		
	}
	
	public static void PresentIndicative() {
			
		
	}
	public static void Preterite() {
		
		
		
	}
	public static void Imperfect() {
		
		
		
	}

}
