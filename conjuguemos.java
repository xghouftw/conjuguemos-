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
			if (next.equals("1")) {
				
				PresentIndicative();
			}
			if (next.equals("2")) {
				Preterite();
			}
			if (next.equals("3")) {
				System.out.println("---Imperfect Mode--\nRespond 0 to Quit to main menu");
				String response;
				do {
					String question = Verbs.get((int)(Math.random()*Verbs.size()));
					int subject = (int)(Math.random()*6);
					System.out.println(Pronouns[subject] + " (" + question + ")");
					response = input.nextLine();
					String answer = Imperfect(subject, question);
					if (response.equals(answer)) System.out.println("Correct!");
					else System.out.println("Incorrect! The correct conjugation is: " + answer + ".");
				} while(!response.equals("0"));
			}
			
		} while (!next.equals("0"));
		System.out.println("Thank you for playing Spanish verb conjugation trainer. Practice makes Permanent!");

	}
	
	public static void PresentIndicative() {

	}
	public static void Preterite() {
		
	}
	
	public static String Imperfect(int subject, String question) {
			String correct = "";
			String ending = question.substring(question.length()-2);
			
			String irregulars[][] = {{"ser","era","eras","era","éramos","erais","eran"},{"ir","iba","ibas","iba","íbamos","ibais","iban"},{"ver","veía","veías","veía","veíamos","veíais","veían"}};
			for (int i = 0; i < irregulars.length; i++) {
				if (question.equals(irregulars[i][0])) {
					correct = irregulars[i][subject+1];
					return correct;
				}
			}
			
			correct = question.substring(0, question.length()-2);
			if (ending.equals("ar")) {
				String add[] = {"aba","abas","aba","ábamos","abais","aban"};
				correct += add[subject];
				return correct;
			}
			if (ending.equals("er") || ending.equals("ir")) {
				String add[] = {"ía","ías","ía","íamos","íais","ían"};
				correct += add[subject];
				return correct;
			}
			return "Error";
		}
	}
