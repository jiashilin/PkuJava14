package gobangGame;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GobangGame {
	// 定义达到赢条件的棋子数目
	private final int WIN_COUNT = 5;
	// 定义用户输入的X坐标
	private int posX = 0;
	// 定义用户输入的Y坐标
	private int posY = 0;
	// 定义棋盘
	private Chessboard chessboard;

	/**
	 * 空构造器
	 */
	public GobangGame() {
	}

	/**
	 * 构造器，初始化棋盘和棋子属性
	 * 
	 * @param chessboard
	 *            棋盘类
	 */
	public GobangGame(Chessboard chessboard) {
		this.chessboard = chessboard;
	}

	/**
	 * 检查输入是否合法。
	 * 
	 * @param inputStr
	 *            由控制台输入的字符串。
	 * @return 字符串合法返回true,反则返回false。
	 */
	public boolean isValid(String inputStr) {
		// 将用户输入的字符串以逗号(,)作为分隔，分隔成两个字符串
		String[] posStrArr = inputStr.split(",");
		try {
			posX = Integer.parseInt(posStrArr[0]) - 1;
			posY = Integer.parseInt(posStrArr[1]) - 1;
		} catch (NumberFormatException e) {
			chessboard.printBoard();
			System.out.println("请以(数字,数字)的格式输入：");
			return false;
		}
		// 检查输入数值是否在范围之内
		if (posX < 0 || posX >= Chessboard.BOARD_SIZE || posY < 0 || posY >= Chessboard.BOARD_SIZE) {
			chessboard.printBoard();
			System.out.println("X与Y坐标只能大于等于1,与小于等于" + Chessboard.BOARD_SIZE + ",请重新输入：");
			return false;
		}
		// 检查输入的位置是否已经有棋子
		String[][] board = chessboard.getBoard();
		if (board[posX][posY] != "十") {
			chessboard.printBoard();
			System.out.println("此位置已经有棋子，请重新输入：");
			return false;
		}
		return true;
	}

	/**
	 * 开始下棋
	 */
	public void start() throws Exception {
		// true为游戏结束
		boolean isOver = false;
		chessboard.initBoard();
		chessboard.printBoard();
		// 获取键盘的输入
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputStr = null;
		// br.readLine:每当键盘输入一行内容按回车键，则输入的内容被br读取到
		while ((inputStr = br.readLine()) != null) {
			isOver = false;
			if (!isValid(inputStr)) {
				// 如果不合法，要求重新输入，再继续
				continue;
			}
			// 把对应的数组元素赋为"●"
			String chessman = Chessman.BLACK.getChessman();
			chessboard.setBoard(posX, posY, chessman);
			// 判断用户是否赢了
			if (isWon(posX, posY, chessman)) {
				isOver = true;

			} else {
				// 计算机随机选择位置坐标
				int[] computerPosArr = computerDo();
				chessman = Chessman.WHITE.getChessman();
				chessboard.setBoard(computerPosArr[0], computerPosArr[1], chessman);
				// 判断计算机是否赢了
				if (isWon(computerPosArr[0], computerPosArr[1], chessman)) {
					isOver = true;
				}
			}
			// 如果产生胜者，询问用户是否继续游戏
			if (isOver) {
				// 如果继续，重新初始化棋盘，继续游戏
				if (isReplay(chessman)) {
					chessboard.initBoard();
					chessboard.printBoard();
					continue;
				}
				// 如果不继续，退出程序
				break;
			}
			chessboard.printBoard();
			System.out.println("请输入您下棋的坐标，应以x,y的格式输入：");
		}
	}

	/**
	 * 是否重新开始下棋。
	 * 
	 * @param chessman
	 *            "●"为用户，"○"为计算机。
	 * @return 开始返回true，反则返回false。
	 */
	public boolean isReplay(String chessman) throws Exception {
		chessboard.printBoard();
		String message = chessman.equals(Chessman.BLACK.getChessman()) ? "恭喜您，您赢了，" : "很遗憾，您输了，";
		System.out.println(message + "再下一局？(y/n)");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		if (br.readLine().equals("y")) {
			// 开始新一局
			return true;
		}
		return false;

	}

	/**
	 * 计算机随机下棋
	 */
	public int[] computerDo() {
		// int posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		// int posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		// String[][] board = chessboard.getBoard();
		// while (board[posX][posY] != "十") {
		// posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		// posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		// }
		String[][] board = chessboard.getBoard();
		int[][] cgrades = new int[Chessboard.BOARD_SIZE][Chessboard.BOARD_SIZE];
		int[][] pgrades = new int[Chessboard.BOARD_SIZE][Chessboard.BOARD_SIZE];
		int cgrade = 0, pgrade = 0, x = 0, y = 0;
		String white = Chessman.WHITE.getChessman();
		String black = Chessman.BLACK.getChessman();
		for (int i = 0; i < Chessboard.BOARD_SIZE; i++) {
			for (int j = 0; j < Chessboard.BOARD_SIZE; j++) {
				cgrades[i][j] = -1;
				pgrades[i][j] = -1;
			}
		}
		for (int i = 0; i < Chessboard.BOARD_SIZE; i++) {
			for (int j = 0; j < Chessboard.BOARD_SIZE; j++) {
				if (board[i][j] == "十") {
					cgrades[i][j] = Calculation(i, j, white);
				}
			}
		}

		for (int i = 0; i < Chessboard.BOARD_SIZE; i++) {
			for (int j = 0; j < Chessboard.BOARD_SIZE; j++) {
				if (board[i][j] == "十") {
					pgrades[i][j] = Calculation(i, j, black);
				}
			}
		}

		for (int i = 0; i < Chessboard.BOARD_SIZE; i++)
			for (int j = 0; j < Chessboard.BOARD_SIZE; j++) {
				if (board[i][j] == "十") {
					if (cgrades[i][j] > cgrade) {
						cgrade = cgrades[i][j];
						posX = i;
						posY = j;
					}
					if (pgrades[i][j] > pgrade) {
						pgrade = pgrades[i][j];
						x = i;
						y = j;
					}
				}
				if (cgrade <= pgrade) {
					posX = x;
					posY = y;
				}
			}
		int[] result = { posX, posY };
		return result;
	}

	public int Calculation(int i, int j, String ico) {
		int grade = 0;
		int n = i;
		int n1 = j;
		int count = 0;
		int startX = 0, startY = 0;
		int endX = Chessboard.BOARD_SIZE - 1, endY = Chessboard.BOARD_SIZE - 1;
		int temp = 0;
		temp = i - WIN_COUNT + 1;
		startX = temp > 0 ? temp : 0;
		temp = j - WIN_COUNT + 1;
		startY = temp > 0 ? temp : 0;
		temp = i + WIN_COUNT - 1;
		endX = temp < chessboard.BOARD_SIZE - 1 ? temp : chessboard.BOARD_SIZE - 1;
		temp = j + WIN_COUNT - 1;
		endY = temp < chessboard.BOARD_SIZE - 1 ? temp : chessboard.BOARD_SIZE - 1;
		String[][] board = chessboard.getBoard();
		while (n > startX && board[n][j] == ico) {
			count++;
			n--;
		}
		n = i + 1;
		while (n < endX && board[n][j] == ico) {
			count++;
			n++;
		}
		grade += weight(count, ico);
		count = 0;
		while (n1 > startY && board[i][n1] == ico) {
			count++;
			n1--;
		}
		n1 = j + 1;
		while (n1 < endY && board[i][n1] == ico) {
			count++;
			n1++;
		}
		grade += weight(count, ico);
		n = i;
		n1 = j;
		count = 0;
		while (n > startX && n1 > startY && board[n][n1] == ico) {
			count++;
			n--;
			n1--;
		}
		n = i + 1;
		n1 = j + 1;
		while (n < endX && n1 < endY && board[n][n1] == ico) {
			count++;
			n++;
			n1++;
		}
		grade += weight(count, ico);
		count = 0;
		n = i;
		n1 = j;
		while (n < endX && n1 > startY && board[n][j] == ico) {
			count++;
			n++;
			n1--;
		}
		n = i - 1;
		n1 = j + 1;
		while (n > startX && n1 < endY && board[n][j] == ico) {
			count++;
			n--;
			n1++;
		}
		grade += weight(count, ico);
		return grade;
	}

	public int weight(int count, String ico) {
		int grade = 0;
		if (ico == "●") {
			switch (count) {
			case 1:
				grade = 5;
				break;
			case 2:
				grade = 50;
				break;
			case 3:
				grade = 500;
				break;
			case 4:
				grade = 5000;
				break;
			}
		} else if (ico == "○") {
			switch (count) {
			case 1:
				grade = 10;
				break;
			case 2:
				grade = 100;
				break;
			case 3:
				grade = 1000;
				break;
			case 4:
				grade = 10000;
				break;
			}
		}
		return grade;
	}

	/**
	 * 判断输赢
	 * 
	 * @param posX
	 *            棋子的X坐标。
	 * @param posY
	 *            棋子的Y坐标
	 * @param ico
	 *            棋子类型
	 * @return 如果有五颗相邻棋子连成一条直接，返回真，否则相反。
	 */
	public boolean isWon(int posX, int posY, String ico) {
		int startX = 0, startY = 0;
		int endX = Chessboard.BOARD_SIZE - 1, endY = Chessboard.BOARD_SIZE - 1;
		int count = 0, temp = 0;
		temp = posX - WIN_COUNT + 1;
		startX = temp > 0 ? temp : 0;
		temp = posY - WIN_COUNT + 1;
		startY = temp > 0 ? temp : 0;
		temp = posX + WIN_COUNT - 1;
		endX = temp < chessboard.BOARD_SIZE - 1 ? temp : chessboard.BOARD_SIZE - 1;
		temp = posY + WIN_COUNT - 1;
		endY = temp < chessboard.BOARD_SIZE - 1 ? temp : chessboard.BOARD_SIZE - 1;
		String[][] board = chessboard.getBoard();
		for (int i = startX; i < endX; i++) {
			if (board[i][posY] == ico && board[i + 1][posY] == ico) {
				count++;
			} else if (count != WIN_COUNT - 1) {
				count = 0;
			}
		}
		if (count == 0) {
			for (int i = startY; i < endY; i++) {
				if (board[posX][i] == ico && board[posX][i + 1] == ico) {
					count++;
				} else if (count != WIN_COUNT - 1) {
					count = 0;
				}
			}
		}
		if (count == 0) {
			for (int i = startX, j = startY; i < endX && j < endY; i++, j++) {
				if (board[i][j] == ico && board[i + 1][j + 1] == ico) {
					count++;
				} else if (count != WIN_COUNT - 1) {
					count = 0;
				}
			}
		}
		if (count == 0) {
			for (int i = endX, j = startY; i > startX && j < endY; i--, j++) {
				if (board[i][j] == ico && board[i - 1][j + 1] == ico) {
					count++;
				} else if (count != WIN_COUNT - 1) {
					count = 0;
				}
			}
		}
		if (count == WIN_COUNT - 1) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) throws Exception {

		GobangGame gb = new GobangGame(new Chessboard());
		gb.start();
	}
}
