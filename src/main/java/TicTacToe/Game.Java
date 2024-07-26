import java.util.*;

enum PieceType {
    X, O;
}

class PlayingPiece {
    PieceType type;

    public PlayingPiece(PieceType pieceType) {
        this.type = pieceType;
    }
}

class PlayingPieceX extends PlayingPiece {
    public PlayingPieceX() {
        super(PieceType.X);
    }
}

class PlayingPieceO extends PlayingPiece {
    public PlayingPieceO() {
        super(PieceType.O);
    }
}

class Player {
    String name;
    PlayingPiece piece;

    public Player(String name, PlayingPiece piece) {
        this.name = name;
        this.piece = piece;
    }
}

class Board {
    int size;
    PlayingPiece[][] board;

    public Board(int size) {
        this.size = size;
        this.board = new PlayingPiece[size][size];
    }

    public boolean addPiece(int x, int y, PlayingPiece piece) {
        if (freeSpace(x, y)) {
            board[x][y] = piece;
            return true;
        }
        return false;
    }

    public boolean freeSpace(int x, int y) {
        return board[x][y] == null;
    }

    public boolean checkWin(int x, int y, PlayingPiece piece) {
        // Check row
        boolean win = true;
        for (int i = 0; i < size; i++) {
            if (board[x][i] == null || board[x][i].type != piece.type) {
                win = false;
                break;
            }
        }
        if (win) return true;

        // Check column
        win = true;
        for (int i = 0; i < size; i++) {
            if (board[i][y] == null || board[i][y].type != piece.type) {
                win = false;
                break;
            }
        }
        if (win) return true;

        // Check diagonal
        if (x == y) {
            win = true;
            for (int i = 0; i < size; i++) {
                if (board[i][i] == null || board[i][i].type != piece.type) {
                    win = false;
                    break;
                }
            }
            if (win) return true;
        }

        // Check anti-diagonal
        if (x + y == size - 1) {
            win = true;
            for (int i = 0; i < size; i++) {
                if (board[i][size - i - 1] == null || board[i][size - i - 1].type != piece.type) {
                    win = false;
                    break;
                }
            }
            if (win) return true;
        }

        return false;
    }

    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == null) {
                    System.out.print("-");
                } else {
                    System.out.print(board[i][j].type);
                }
                if (j < size - 1) System.out.print(" | ");
            }
            System.out.println();
        }
    }
}

class Game {
    public Deque<Player> players;
    public Board board;

    public Game() {
        players = new LinkedList<>();

        PlayingPieceX crossPiece = new PlayingPieceX();
        Player player1 = new Player("player 1", crossPiece);

        PlayingPieceO zeroPiece = new PlayingPieceO();
        Player player2 = new Player("player 2", zeroPiece);

        players.add(player1);
        players.add(player2);

        board = new Board(3);
    }

    public void takeInput() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            board.printBoard();
            Player currentPlayer = players.removeFirst();
            System.out.println(currentPlayer.name + "'s turn. Enter row and column: ");
            String str = sc.nextLine();
            String[] arr = str.split(",");

            int posX = Integer.parseInt(arr[0].trim());
            int posY = Integer.parseInt(arr[1].trim());

            if (board.addPiece(posX, posY, currentPlayer.piece)) {
                if (board.checkWin(posX, posY, currentPlayer.piece)) {
                    board.printBoard();
                    System.out.println(currentPlayer.name + " wins!");
                    break;
                }
                players.addLast(currentPlayer);
            } else {
                System.out.println("Invalid move. Try again.");
                players.addFirst(currentPlayer);
            }
        }
    }

    public void startGame() {
        takeInput();
    }
}

public class Main {
    public static void main(String[] args) {
        Game game1 = new Game();
        game1.startGame();
    }
}
