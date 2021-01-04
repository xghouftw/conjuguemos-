public class PresentIndicative {
	public static String conjugate (int subject, String question) {
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
		if (question.endsWith("eír")) {
			correct = question.substring(0,question.length()-3);
			String add[] = {"ío","íes","íe","eímos","eís","íen"};
			correct += add[subject];
			return correct;
		}
		
		//regular
		correct = question.substring(0, question.length()-2);
		if (ending.equals("ar")){
			String add[] = {"o","as","a","amos","áis","an"};
			if (stemmed && (subject == 5 || subject < 3)) {
				correct = stem;
			}
			correct += add[subject];
			return correct;
		}
		if (ending.equals("er")){
			String add[] = {"o","es","e","emos","éis","en"};
			if (stemmed && subject == 5 || subject < 3) {
				correct = stem;
			}
			correct += add[subject];
			return correct;
		}
		if (ending.equals("ir")){
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
