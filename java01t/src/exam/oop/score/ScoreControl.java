/* Control 역할
 * - 바운더리와 엔티티의 중계역할
 * - 사용자가 입력한 명령에 따라 바운더리를 연결해줌
 * 
 */
package exam.oop.score;

import java.util.Scanner;

public class ScoreControl {
	Scanner scanner;
	ScoreInput scoreInput;
	ScoreDao scoreDao;
	
	public ScoreControl() {
		scanner = new Scanner(System.in); 
		scoreDao = new ScoreDao();
		scoreInput = new ScoreInput(scoreDao);
		
	}
	
	public void execute() {
		String command;
		System.out.print(">");
		command = scanner.nextLine();
		if (command.equals("new")) {
			scoreInput.service(scanner);
		}
	}
	
	public void printScoreAll() {
		Score[] scores = scoreDao.toArray();
		int size = scoreDao.size;
		
		for (int i = 0; i < size; i++) {
			System.out.println(scores[i].name + ":" + scores[i].kor);
		}
	}
	
	public static void main(String[] args) {
		ScoreControl sc = new ScoreControl();
		sc.execute();
		sc.printScoreAll();
	}
	
}











