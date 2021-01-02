public class Imperfect {
	public static String conjugate (int subject, String question) {
		String correct = "";
		String ending = question.substring(question.length()-2);
		
		//totally irregular
		String irregulars[][] = {{"ser","era","eras","era","�ramos","erais","eran"},{"ir","iba","ibas","iba","�bamos","ibais","iban"},{"ver","ve�a","ve�as","ve�a","ve�amos","ve�ais","ve�an"}};
		for (int i = 0; i < irregulars.length; i++) {
			if (question.equals(irregulars[i][0])) {
				correct = irregulars[i][subject+1];
				return correct;
			}
		}
		
		//regular
		correct = question.substring(0, question.length()-2);
		if (ending.equals("ar")) { 
			String add[] = {"aba","abas","aba","�bamos","abais","aban"};
			correct += add[subject];
			return correct;
		}
		if (ending.equals("er") || ending.equals("ir")) {
			String add[] = {"�a","�as","�a","�amos","�ais","�an"};
			correct += add[subject];
			return correct;
		}
		return "Error";
	}
}
