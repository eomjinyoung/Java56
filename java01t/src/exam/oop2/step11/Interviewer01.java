package exam.oop2.step11;

import java.util.Scanner;

public class Interviewer01 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String command = scanner.nextLine();
		MyInterviewee iv = new MyInterviewee();
		
		if (command.equals("hi")) {
			iv.hi();
		} else if (command.equals("bye")) {
			iv.bye();
		}
	}

}
