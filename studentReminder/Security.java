package studentReminder;

public class Security {

	private String chosenSecQuestion;
	private String secureAnswer;
	
	private static final String[] secureQuestions = {
		"What is your favorite food?",
		"Who is your bestfriend in highschool?",
		"What's the name of your pet?"
	};
	
	public Security (String chosenSecQuestion, 
			String secureAnswer) {
		this.chosenSecQuestion = chosenSecQuestion;
		this.secureAnswer = secureAnswer;
	}
	
	public void printSecureQuestions () {
		for (int i=0; i<secureQuestions.length; i++) 
			System.out.println(secureQuestions[i]);
	}
	
	//must figure out how this works, might make 
	//secureQuestions public
	public void setChosenSecQuestion(int questionNumber) {
		chosenSecQuestion = secureQuestions[questionNumber];
	}
	
	public String getChosenSecQuestion() {
		return chosenSecQuestion;
	}
	
	public void setSecureAnswer (String secureAnswer) {
		this.secureAnswer = secureAnswer;
	}
	
	public String getSecureAnswer () {
		return this.secureAnswer;
	}
	
	//compare the new input for security answer with
	//the previously set security answer
	public boolean validateUser (String secureAnswer) {
		if (this.secureAnswer.equals(secureAnswer)) 
			return true;
		else return false;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		else return false;
	}
	
}
