public class Preterite {
	
	static String[] doubleVowelEndings = {"í", "íste", "yó", "ímos", "ísteis", "yeron"};
	static String[][] UIVerbs = {{"andar", "anduv"}, {"estar", "estuv"}, {"caber", "cup"}, {"poder", "pud"}, {"poner", "pus"}, {"saber", "sup"}, {"tener", "tuv"}, {"haber", "hub"}, {"querer", "quis"}, {"venir", "vin"}};
	static String[][] JVerbs = {{"traer", "traj"}, {"decir", "dij"}, {"cir", "j"}};
	static String[] uIGroupEndings = {"e", "iste", "o", "imos", "isteis", "ieron"};
	static String[] JGroupEndings = {"e", "iste", "o", "imos", "isteis", "eron"};
	
	
	
	/* U Group: andar->anduv, estar->estuv, caber->cup, poder->pud, poner->pus, saber->sup, tener->tuv, haber->hub.
	  J group: verbs ending in -cir may have that part truncated and replaced by a j, traer->traj.
	  I group: querer->quis-, venir->vin-.
	*/
	public static String conjugateAll(String question) {
		
		String answer = "";
		
		for (int i = 0; i <= 5; i++) {
			answer += conjugate(i, question);
			answer += ", ";
		}
		return answer;
	}
	
	public static String conjugate (int subject, String question) {
		String correct = "";
		String ending = question.substring(question.length()-2);
		String ending3 = question.substring(question.length()-3);
		String stem = question.substring(0, question.length()-2);
		String shortStem = stem.substring(0, stem.length()-1);
		int verbIndex = 0;
		boolean isUIVerb = false;
		boolean isJVerb = false;
		
		for (int i =0; i < UIVerbs.length; i++) {
			isUIVerb = (UIVerbs[i][0].equals(question)||question.endsWith(UIVerbs[i][0]));
			
			if (isUIVerb) {
				verbIndex = i;
				break;
			}
		}
		
		for (int i =0; i < JVerbs.length; i++) {
			isJVerb = (JVerbs[i][0].equals(question)||question.endsWith(JVerbs[i][0]));
			if (isJVerb) {
				verbIndex = i;
				break;
			}
		}
		
		if (isUIVerb) {
			
			return question.substring(0, question.lastIndexOf(UIVerbs[verbIndex][0])) + UIVerbs[verbIndex][1] + uIGroupEndings[subject];
			
		}
		
		if (isJVerb) {
			return question.substring(0, question.lastIndexOf(JVerbs[verbIndex][0])) + JVerbs[verbIndex][1] + JGroupEndings[subject];
		}
		
		// Verbs ending in -Car, -Gar, or -Zar
		if (subject==0) {
			if (ending3.equals("car")) {
				return shortStem + "qué";
			}
			else if (ending3.equals("gar")) {
				return shortStem + "gué";
			}
			else if (ending3.equals("zar")) {
				return shortStem + "cé";
			}
		}
		
		// Spelling changes for verbs ending in -caer, -eer, -oer, -oír, or -uir
		
		if (stem.endsWith("a")||stem.endsWith("e")||stem.endsWith("i")||stem.endsWith("o")||stem.endsWith("u")) {
			
			correct = stem + doubleVowelEndings[subject];
			return correct;
			
		}
		
		
		
		
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
}
