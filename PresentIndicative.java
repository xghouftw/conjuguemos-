public class PresentIndicative {
	public static String conjugate (int subject, String question) {
		String correct = "";
		
		//totally irregular
		String irregulars[][] = {{"ser","soy","eres","es","somos","sois","son"},{"estar","estoy","estás","está","estamos","estáis","están"},{"ir","voy","vas","va","vamos","vais","van"},{"haber","he","has","hay","hemos","habéis","han"}};
		for (int i = 0; i < irregulars.length; i++) {
			if (question.equals(irregulars[i][0])) {
				correct = irregulars[i][subject+1];
				return correct;
			}
		}
		
		//Pattern to -ir stem changing verbs
		String stem = question.substring(0,question.length()-2);
		boolean stemmed = false;
		String iesuffix[] = {"entir","ertir","erir","venir"};
		for (int i = 0; i < iesuffix.length; i++) if (question.endsWith(iesuffix[i])) {
			stem = question.substring(0, question.lastIndexOf("e")) + "ie" + question.substring(question.lastIndexOf("e")+1, question.length()-2);
			stemmed = true;
		}
		String isuffix[] = {"edir","etir","egir","eñir","decir"}; 
		for (int i = 0; i < isuffix.length; i++) if (question.endsWith(isuffix[i])) {
			stem = question.substring(0, question.lastIndexOf("e")) + "i" + question.substring(question.lastIndexOf("e")+1, question.length()-2);
			stemmed = true;
		}
		if (question.endsWith("dormir") || question.endsWith("morir")) {
			stem = question.substring(0, question.lastIndexOf("o")) + "ue" + question.substring(question.lastIndexOf("o")+1, question.length()-2);
			stemmed = true;
		}
		if (question.endsWith("eír")) {
			correct = question.substring(0,question.length()-3);
			String add[] = {"ío","íes","íe","eímos","eís","íen"};
			correct += add[subject];
			return correct;
		}
		if (question.endsWith("uir") && !question.endsWith("guir")) {
			stem = question.substring(0, question.length()-2) + "y";
			stemmed = true;
		}
		
		//Pattern to -ar/-er stem changing verbs 
		//O-ue
		String[] ueSuffix = {"olver", "cordar", "orzar", "probar", "colgar", "over", "contar", "ostar", "contrar", "morder", "mostrar", "poder", "torcer", "sonar", "tronar", "soñar", "volar", "cocer", "oler"};
		for (int i = 0; i < ueSuffix.length; i++) if (question.endsWith(ueSuffix[i])) {
			stem = question.substring(0, question.lastIndexOf("o")) + "ue" + question.substring(question.lastIndexOf("o")+1, question.length() -2);
			if (stem.equalsIgnoreCase("uel")) stem = "h" + stem;
			if ((stem.endsWith("uec"))&&subject==0) stem = stem.substring(0, stem.length()-1) + "z" + stem.substring(stem.length()-1);
			stemmed = true;
		}
		
		//regular
		correct = question.substring(0, question.length()-2);
		if (question.endsWith("ar")){
			String add[] = {"o","as","a","amos","áis","an"};
			if (stemmed && (subject == 5 || subject < 3)) {
				correct = stem;
			}
			correct += add[subject];
			return correct;
		}
		if (question.endsWith("er")){
			String add[] = {"o","es","e","emos","éis","en"};
			if (stemmed && subject == 5 || subject < 3) {
				correct = stem;
			}
			correct += add[subject];
			return correct;
		}
		if (question.endsWith("ir")){
			String add[] = {"o","es","e","imos","ís","en"};
			if (stemmed && subject == 5 || subject < 3) {
				correct = stem;
			}
			correct += add[subject];
			return correct;
		}
		return "Error";
	}
}
