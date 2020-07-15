package poker.main;
import poker.rule.GameField;

public class RunGame {

	public static void main(String[] args) {
		GameField gameField;
		gameField = new GameField();
		gameField.startGame();
		System.out.println("ゲームを終了します。");

	}
}
