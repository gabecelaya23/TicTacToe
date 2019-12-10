
public class FactoryPiece {
	
	public GamePieces  setTurn(int turn) {
		if (turn%2 == 0) {
		return new XButton();
		} else {
		return new OButton();
		}
		}
}
