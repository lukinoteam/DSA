package puzzle;

public class NodeFind implements Comparable<NodeFind> {
	private Board board;
	private int move;
	private NodeFind prev;

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public int getMove() {
		return move;
	}

	public void setMove(int move) {
		this.move = move;
	}

	public NodeFind getPrev() {
		return prev;
	}

	public void setPrev(NodeFind prev) {
		this.prev = prev;
	}

	public NodeFind(Board board, int move) {
		this.board = board;
		this.move = move;
		this.prev = null;
	}

	@Override
	public int compareTo(NodeFind o) {

		if (this.board.manhattan() + this.move > o.getBoard().manhattan() + o.getMove())
			return 1;
		else if (this.board.manhattan() + this.move < o.getBoard().manhattan() + o.getMove())
			return -1;
		else
			return 0;
	}

}
