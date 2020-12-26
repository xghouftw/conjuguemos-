import java.util.*;
import java.io.*;
public class conjuguemos {
	
static String Pronouns[] = {"Yo","Tú","Él, Ella, Ustedes","Nosotros","Vosotros","Ellos, Ellas, Ustedes"};
static ArrayList<String> Verbs = new ArrayList<String>();
static Scanner input = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("VerbBank.txt"));
		String verb = "";
		while ((verb = br.readLine()) != null) Verbs.add(verb);
		
		
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
		System.out.println("---Imperfect Mode---\nRespond 0 to Quit to the main menu");

		while (true) {
			String question = Verbs.get((int)(Math.random()*Verbs.size()));
			int pron = (int)(Math.random()*6);
			
			System.out.println(Pronouns[pron] + " (" + question + ")");
			String response = input.nextLine();
			if (response.equals("0")) return;
			
			String correct = question;
			correct = question.substring(0,question.length()-2);
			String ending = question.substring(question.length()-2);
			if (ending.equals("ar")) {
				if (pron == 0) correct += "aba";
				if (pron == 1) correct += "abas";
				if (pron == 2) correct += "aba";
				if (pron == 3) correct += "ábamos";
				if (pron == 4) correct += "abais";
				if (pron == 5) correct += "aban";
			}
			if (ending.equals("er") || ending.equals("ir")) {
				if (pron == 0) correct += "ía";
				if (pron == 1) correct += "ías";
				if (pron == 2) correct += "ía";
				if (pron == 3) correct += "íamos";
				if (pron == 4) correct += "íais";
				if (pron == 5) correct += "ían";
			}
			if (response.equals(correct)) System.out.println("Correct!");
			else System.out.println("Incorrect!");
		}
		
	}

}
