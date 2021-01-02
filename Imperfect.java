public class Imperfect {
	public static String conjugate (int subject, String question) {
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
