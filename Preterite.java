public class Preterite {
	
	static String[] doubleVowelEndings = {"í", "íste", "yó", "ímos", "ísteis", "yeron"};
	static String[][] UIVerbs = {{"andar", "anduv"}, {"estar", "estuv"}, {"caber", "cup"}, {"poder", "pud"}, {"poner", "pus"}, {"saber", "sup"}, {"tener", "tuv"}, {"haber", "hub"}, {"querer", "quis"}, {"venir", "vin"}};
	static String[][] JVerbs = {{"traer", "traj"}, {"decir", "dij"}, {"cir", "j"}};
	static String[] UIGroupEndings = {"e", "iste", "o", "imos", "isteis", "ieron"};
	static String[] JGroupEndings = {"e", "iste", "o", "imos", "isteis", "eron"};
	static String[][] irregulars = {{"ser", "fui", "fuiste", "fue", "fuimos", "fuisteis", "fueron"}, {"ir",  "fui", "fuiste", "fue", "fuimos", "fuisteis", "fueron"}, {"dar", "di", "diste", "dio", "dimos", "disteis", "dieron"}, {"ver", "vi", "viste", "vio", "vimos", "visteis", "vieron"}, {"hacer", "hice", "hiciste", "hizo", "hicimos", "hicisteis", "hicieron"}};
	
	public static String conjugate (int subject, String question) {
		String correct = "";
		String ending = question.substring(question.length()-2);
		String stem = question.substring(0, question.length()-2);
		boolean stemmed = false;
		
		//completely irregular
		for (int i = 0; i < irregulars.length; i++) {
			if (question.equals(irregulars[i][0])) return irregulars[i][subject+1];
			else if (question.endsWith("hacer")&&i==4) return question.substring(0, (question.length()-irregulars[4][0].length())) + irregulars[4][subject+1];
		}
		
		//UJI group irregular verbs
		for (int i =0; i < UIVerbs.length; i++) if (question.endsWith(UIVerbs[i][0])) return question.substring(0, question.lastIndexOf(UIVerbs[i][0])) + UIVerbs[i][1] + UIGroupEndings[subject];
		for (int i =0; i < JVerbs.length; i++) if (question.endsWith(JVerbs[i][0])) return question.substring(0, question.lastIndexOf(JVerbs[i][0])) + JVerbs[i][1] + JGroupEndings[subject];
		
		// -Car, -Gar, -Zar verbs in first person singular
		if (subject==0) {
			String ending3 = question.substring(question.length()-3);
			String shortStem = stem.substring(0, stem.length()-1);
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
		
		// Verbs ending in -aer, -eer, -oer, -oír, or -uir have spelling changes
		if (question.endsWith("aer")||question.endsWith("eer")||question.endsWith("oer")||question.endsWith("oír")||question.endsWith("uir")) return stem + doubleVowelEndings[subject];
		
		// -ir stem changing verbs
		String isuffix[] = {"entir","ertir","erir","venir", "edir","etir","egir","eñir","decir"};
		for (int i = 0; i < isuffix.length; i++) if (question.endsWith(isuffix[i])) {
			stem = question.substring(0, question.lastIndexOf("e")) + "i" + question.substring(question.lastIndexOf("e")+1, question.length()-2);
			stemmed = true;
			}
	
		if (question.endsWith("dormir") || question.endsWith("morir")) {
		stem = question.substring(0, question.lastIndexOf("o")) + "u" + question.substring(question.lastIndexOf("o")+1, question.length()-2);
		stemmed = true;
	}
		
		//regular
		correct = question.substring(0, question.length()-2);
		if (ending.equals("ar")){
			String add[] = {"é","aste","ó","amos","asteis","aron"};
			correct += add[subject];
			return correct;
		}
		if (ending.equals("er") || ending.equals("ir")){
			String add[] = {"í","iste","ió","imos","isteis","ieron"};
			if (stemmed && subject==2||subject==5) {
				return stem + add[subject];
			}
			correct += add[subject];
			return correct;
		}
		return "Error";
	}
}
