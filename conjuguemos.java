import java.util.*;
import java.io.*;
public class conjuguemos {
	
static String Pronouns[] = {"Yo","Tú","Él, Ella, Usted","Nosotros","Vosotros","Ellos, Ellas, Ustedes"};
static ArrayList<String> Verbs = new ArrayList<String>();
static Scanner input = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("VerbBank.txt"));
		String verb = "";
		while ((verb = br.readLine()) != null) Verbs.add(verb);
	
		String Menu[] = {"Quit","Present Indicative","Preterite","Imperfect"};	
		String next;
		int mode;
		System.out.println("***Welcome to the Spanish verb conjugation lookup!***");
		
		do {
			System.out.println("Type a number from the menu to continue");
			for (int i = 0; i < Menu.length; i++) System.out.println(i + ". " + Menu[i]);
			next = input.nextLine();
			mode = Integer.parseInt(next.trim());
			
			while (true) {
				System.out.println("---Conjugation Lookup---\nType a verb, or 0 to quit");
				next = input.nextLine();
				String question = next.trim().toLowerCase();
				if (question.equals("0")) break;
				System.out.print("In the " + Menu[mode] + " tense, " + question + " is conjugated as: ");
				if (mode == 1) for (int i = 0; i < 6; i++) System.out.print(PresentIndicative.conjugate(i, question) + " ");;
				if (mode == 2) for (int i = 0; i < 6; i++) System.out.print(Preterite.conjugate(i, question) + " ");
				if (mode == 3) for (int i = 0; i < 6; i++) System.out.print(Imperfect.conjugate(i, question) + " ");
				System.out.println();
			}
		} while (mode != 0);
		
		System.out.println("Thank you for playing Spanish verb conjugation trainer. Practice makes Permanent!");

	}
}