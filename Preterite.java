public class Preterite {
	public static String conjugate (int subject, String question) {
		String correct = "";
		String ending = question.substring(question.length()-2);
		String ending3 = question.substring(question.length()-3);
		String ending4 = question.substring(question.length()-4);
		String stem = question.substring(0, question.length()-2);
		String shortStem = stem.substring(0, stem.length()-1);
		
		// Verbs ending in -Car, -Gar, or -Zar
		if (subject==0) {
			if (ending3.equals("car")) {
				return shortStem + "qu�";
			}
			else if (ending3.equals("gar")) {
				return shortStem + "gu�";
			}
			else if (ending3.equals("zar")) {
				return shortStem + "c�";
			}
		}
		
		// Spelling changes for verbs ending in -caer, -eer, -oer, -o�r, or -uir
		if (subject==2||subject==5) {
			
			if (ending4.equals("caer")) {
				if (subject==2) return shortStem + "ay�";
				return shortStem + "ayeron";
			}
			
			else if (ending3.equals("eer")) {
				if (subject==2) return shortStem + "ey�";
				return shortStem + "eyeron";
			}
			
			else if (ending3.equals("oer")||ending3.equals("o�r")) {
				if (subject==2) return shortStem + "oy�";
				return shortStem + "oyeron";
			}
			else if (ending3.equals("u�r")) {
				if (subject==2) return shortStem + "uy�";
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
			String add[] = {"�","aste","�","amos","asteis","aron"};
			correct += add[subject];
			return correct;
		}
		if (ending.equals("er") || ending.equals("ir")){
			String add[] = {"�","iste","i�","imos","isteis","ieron"};
			correct += add[subject];
			return correct;
		}
		return "Error";
	}
}
