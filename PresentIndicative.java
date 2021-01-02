public class PresentIndicative {
	public static String conjugate (int subject, String question) {
		String correct = "";
		String ending = question.substring(question.length()-2);
		
		//totally irregular
		String irregulars[][] = {{"ser","soy","eres","es","somos","sois","son"},{"estar","estoy","est�s","est�","estamos","est�is","est�n"},{"ir","voy","vas","va","vamos","vais","van"},{"haber","he","has","hay","hemos","hab�is","han"}};
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
			String add[] = {"o","as","a","amos","�is","an"};
			correct += add[subject];
			return correct;
		}
		if (ending.equals("er")){
			String add[] = {"o","es","e","emos","�is","en"};
			correct += add[subject];
			return correct;
		}
		if (ending.equals("ar")){
			String add[] = {"o","es","e","imos","�s","en"};
			correct += add[subject];
			return correct;
		}
		return "Error";
	}
}
