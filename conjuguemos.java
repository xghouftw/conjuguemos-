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
		
		System.out.print("***Welcome to the Spanish verb conjugation trainer!***\nType a number from the menu to continue.\n");
		String Menu[] = {"Quit","Present Indicative","Preterite","Imperfect"};
		
		String next;
		do {
			for (int i = 0; i < Menu.length; i++) System.out.println(i + ". " + Menu[i]);
			next = input.nextLine();
			if (next.equals("1")) {
				System.out.println("---Present Indicative Mode---\nRespond 0 to Quit to main menu");
				String response;
				
				do {
					String question = Verbs.get((int)(Math.random()*Verbs.size()));
					int subject = (int)(Math.random()*6);
					System.out.println(Pronouns[subject] + " (" + question + ")");
					response = input.nextLine();
					String answer = PresentIndicative(subject, question);
					if (response.equalsIgnoreCase(answer)) System.out.println("Correct!");
					else System.out.println("Incorrect! The correct conjugation is: " + answer + ".");
				} while(!response.equals("0"));
			}
			
			if (next.equals("2")) {
				System.out.println("---Preterite Mode---\nRespond 0 to Quit to main menu");
				String response;
				
				do {
					String question = Verbs.get((int)(Math.random()*Verbs.size()));
					int subject = (int)(Math.random()*6);
					System.out.println(Pronouns[subject] + " (" + question + ")");
					response = input.nextLine();
					String answer = Preterite(subject, question);
					if (response.equalsIgnoreCase(answer)) System.out.println("Correct!");
					else System.out.println("Incorrect! The correct conjugation is: " + answer + ".");
				} while(!response.equals("0"));	
			}
			
			if (next.equals("3")) {
				System.out.println("---Imperfect Mode---\nRespond 0 to Quit to main menu");
				String response;
				
				do {
					String question = Verbs.get((int)(Math.random()*Verbs.size()));
					int subject = (int)(Math.random()*6);
					System.out.println(Pronouns[subject] + " (" + question + ")");
					response = input.nextLine();
					String answer = Imperfect(subject, question);
					if (response.equalsIgnoreCase(answer)) System.out.println("Correct!");
					else System.out.println("Incorrect! The correct conjugation is: " + answer + ".");
				} while(!response.equals("0"));
			}
			
		} while (!next.equals("0"));
		
		System.out.println("Thank you for playing Spanish verb conjugation trainer. Practice makes Permanent!");

	}
	
}
