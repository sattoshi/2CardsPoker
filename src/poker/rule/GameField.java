package poker.rule;

public class GameField {
//	PlayerInterface player;
	private Player player;
//	PlayerInterface dealer;
	private Dealer dealer;
	private Deck deck = null;

	 //コンストラクタ
	 public GameField() {
		 player = new Player();
		 dealer =new Dealer();
	 }

	 //ゲームスタート
	 public void startGame() {
		 init();


	 }

	 public void init() {
		deck = new Deck();
		//各プレイヤーが2枚引く
		for(int i = 0; i < 2; i++) {
			player.addCard(deck.draw());
			dealer.addCard(deck.draw());
		}
	 }

}
