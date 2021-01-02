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
		String ending3 = question.substring(question.length()-3);
		String ending4 = question.substring(question.length()-4);
		String stem = question.substring(0, question.length()-2);
		String shortStem = stem.substring(0, stem.length()-1);
		
		// Verbs ending in -Car, -Gar, or -Zar
		if (subject==0) {
			if (ending3.equals("car")) {
				return shortStem + "qué";
			}
			if (ending3.equals("gar")) {
				return shortStem + "gué";
			}
			else if (ending3.equals("zar")) {
				return shortStem + "cé";
			}
		}
		
		// Spelling changes for verbs ending in -caer, -eer, -oer, -oír, or -uir
		if (subject==2||subject==5) {
			
			if (ending4.equals("caer")) {
				if (subject==2) return shortStem + "ayó";
				return shortStem + "ayeron";
			}
			
			if (ending3.equals("eer")) {
				if (subject==2) return shortStem + "eyó";
				return shortStem + "eyeron";
			}
			
			if (ending3.equals("oer")||ending3.equals("oír")) {
				if (subject==2) return shortStem + "oyó";
				return shortStem + "oyeron";
			}
			if (ending3.equals("uír")) {
				if (subject==2) return shortStem + "uyó";
				return shortStem + "uyeron";
			}
			
		}
		
		// -ir ending verbs that stem change in present also change in third person singular and plural forms (o-->ue, e-->i, e-->ie)	
		
		/* UJI group verbs (decided to put ser and ir with completely irregular ones)
		 * 
		  U Group: andar->anduv, estar->estuv, caber->cup, poder->pud, poner->pus, saber->sup, tener->tuv, haber->hub.
		  J group: verbs ending in -cir may have that part truncated and replaced by a j, traer->traj.
		  I group: querer->quis-, venir->vin-.
		  
		  Special endings for U and I groups and special endings for J groups.
		  */
		
		// Completely irregular (ser, ir, dar, ver, hacer)
		
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
