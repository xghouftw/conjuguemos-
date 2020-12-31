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
					if (response.equals(answer)) System.out.println("Correct!");
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
					if (response.equals(answer)) System.out.println("Correct!");
					else System.out.println("Incorrect! The correct conjugation is: " + answer + ".");
				} while(!response.equals("0"));	
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
	
	public static String PresentIndicative(int subject, String question) {
		String correct = "";
		String ending = question.substring(question.length()-2);
		
		//totally irregular
		String irregulars[][] = {{"ser","soy","eres","es","somos","sois","son"},{"estar","estoy","estás","está","estamos","estáis","están"},{"ir","voy","vas","va","vamos","vais","van"},{"haber","he","has","hay","hemos","habéis","han"}};
		for (int i = 0; i < irregulars.length; i++) {
			if (question.equals(irregulars[i][0])) {
				correct = irregulars[i][subject+1];
				return correct;
			}
		}
		/*All the stupid exceptions...
		 * 
		 */
		
		//regular
		if (ending.equals("ar")){
			String add[] = {"o","as","a","amos","áis","an"};
			correct += add[subject];
			return correct;
		}
		if (ending.equals("er")){
			String add[] = {"o","es","e","emos","éis","en"};
			correct += add[subject];
			return correct;
		}
		if (ending.equals("ar")){
			String add[] = {"o","es","e","imos","ís","en"};
			correct += add[subject];
			return correct;
		}
		return "Error";
	}
	public static String Preterite(int subject, String question) {
		String correct = "";
		String ending = question.substring(question.length()-2);
		
		/*All the stupid exceptions...
		 * 
		 */
		
		//regular
		correct = question.substring(0, question.length()-2);
		if (ending.equals("ar")){
			String add[] = {"é","aste","ó","amos","asteis","aron"};
			correct += add[subject];
			return correct;
		}
		if (ending.equals("er") || ending.equals("ir")){
			String add[] = {"í","iste","ió","imos","isteis","ieron"};
			correct += add[subject];
			return correct;
		}
		return "Error";
	}
	
	public static String Imperfect(int subject, String question) {
			String correct = "";
			String ending = question.substring(question.length()-2);
			
			//totally irregular
			String irregulars[][] = {{"ser","era","eras","era","éramos","erais","eran"},{"ir","iba","ibas","iba","íbamos","ibais","iban"},{"ver","veía","veías","veía","veíamos","veíais","veían"}};
			for (int i = 0; i < irregulars.length; i++) {
				if (question.equals(irregulars[i][0])) {
					correct = irregulars[i][subject+1];
					return correct;
				}
			}
			
			//regular
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
