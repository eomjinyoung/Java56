package exam.oop2.step11;

import java.util.Scanner;

public class Interviewer {
	Interviewee interviewee;
	
	void addInterviewee(Interviewee interviewee) {
		this.interviewee = interviewee;
	}
	
	void interview() {
		Scanner scanner = new Scanner(System.in);
		String command = scanner.nextLine();

		if (command.equals("hi")) {
			interviewee.hi();
		} else if (command.equals("bye")) {
			interviewee.bye();
		}
		scanner.close();
	}
}












