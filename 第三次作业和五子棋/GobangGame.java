package gobangGame;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GobangGame {
	// ����ﵽӮ������������Ŀ
	private final int WIN_COUNT = 5;
	// �����û������X����
	private int posX = 0;
	// �����û������Y����
	private int posY = 0;
	// ��������
	private Chessboard chessboard;

	/**
	 * �չ�����
	 */
	public GobangGame() {
	}

	/**
	 * ����������ʼ�����̺���������
	 * 
	 * @param chessboard
	 *            ������
	 */
	public GobangGame(Chessboard chessboard) {
		this.chessboard = chessboard;
	}

	/**
	 * ��������Ƿ�Ϸ���
	 * 
	 * @param inputStr
	 *            �ɿ���̨������ַ�����
	 * @return �ַ����Ϸ�����true,���򷵻�false��
	 */
	public boolean isValid(String inputStr) {
		// ���û�������ַ����Զ���(,)��Ϊ�ָ����ָ��������ַ���
		String[] posStrArr = inputStr.split(",");
		try {
			posX = Integer.parseInt(posStrArr[0]) - 1;
			posY = Integer.parseInt(posStrArr[1]) - 1;
		} catch (NumberFormatException e) {
			chessboard.printBoard();
			System.out.println("����(����,����)�ĸ�ʽ���룺");
			return false;
		}
		// ���������ֵ�Ƿ��ڷ�Χ֮��
		if (posX < 0 || posX >= Chessboard.BOARD_SIZE || posY < 0 || posY >= Chessboard.BOARD_SIZE) {
			chessboard.printBoard();
			System.out.println("X��Y����ֻ�ܴ��ڵ���1,��С�ڵ���" + Chessboard.BOARD_SIZE + ",���������룺");
			return false;
		}
		// ��������λ���Ƿ��Ѿ�������
		String[][] board = chessboard.getBoard();
		if (board[posX][posY] != "ʮ") {
			chessboard.printBoard();
			System.out.println("��λ���Ѿ������ӣ����������룺");
			return false;
		}
		return true;
	}

	/**
	 * ��ʼ����
	 */
	public void start() throws Exception {
		// trueΪ��Ϸ����
		boolean isOver = false;
		chessboard.initBoard();
		chessboard.printBoard();
		// ��ȡ���̵�����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputStr = null;
		// br.readLine:ÿ����������һ�����ݰ��س���������������ݱ�br��ȡ��
		while ((inputStr = br.readLine()) != null) {
			isOver = false;
			if (!isValid(inputStr)) {
				// ������Ϸ���Ҫ���������룬�ټ���
				continue;
			}
			// �Ѷ�Ӧ������Ԫ�ظ�Ϊ"��"
			String chessman = Chessman.BLACK.getChessman();
			chessboard.setBoard(posX, posY, chessman);
			// �ж��û��Ƿ�Ӯ��
			if (isWon(posX, posY, chessman)) {
				isOver = true;

			} else {
				// ��������ѡ��λ������
				int[] computerPosArr = computerDo();
				chessman = Chessman.WHITE.getChessman();
				chessboard.setBoard(computerPosArr[0], computerPosArr[1], chessman);
				// �жϼ�����Ƿ�Ӯ��
				if (isWon(computerPosArr[0], computerPosArr[1], chessman)) {
					isOver = true;
				}
			}
			// �������ʤ�ߣ�ѯ���û��Ƿ������Ϸ
			if (isOver) {
				// ������������³�ʼ�����̣�������Ϸ
				if (isReplay(chessman)) {
					chessboard.initBoard();
					chessboard.printBoard();
					continue;
				}
				// ������������˳�����
				break;
			}
			chessboard.printBoard();
			System.out.println("����������������꣬Ӧ��x,y�ĸ�ʽ���룺");
		}
	}

	/**
	 * �Ƿ����¿�ʼ���塣
	 * 
	 * @param chessman
	 *            "��"Ϊ�û���"��"Ϊ�������
	 * @return ��ʼ����true�����򷵻�false��
	 */
	public boolean isReplay(String chessman) throws Exception {
		chessboard.printBoard();
		String message = chessman.equals(Chessman.BLACK.getChessman()) ? "��ϲ������Ӯ�ˣ�" : "���ź��������ˣ�";
		System.out.println(message + "����һ�֣�(y/n)");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		if (br.readLine().equals("y")) {
			// ��ʼ��һ��
			return true;
		}
		return false;

	}

	/**
	 * ������������
	 */
	public int[] computerDo() {
		// int posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		// int posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		// String[][] board = chessboard.getBoard();
		// while (board[posX][posY] != "ʮ") {
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
				if (board[i][j] == "ʮ") {
					cgrades[i][j] = Calculation(i, j, white);
				}
			}
		}

		for (int i = 0; i < Chessboard.BOARD_SIZE; i++) {
			for (int j = 0; j < Chessboard.BOARD_SIZE; j++) {
				if (board[i][j] == "ʮ") {
					pgrades[i][j] = Calculation(i, j, black);
				}
			}
		}

		for (int i = 0; i < Chessboard.BOARD_SIZE; i++)
			for (int j = 0; j < Chessboard.BOARD_SIZE; j++) {
				if (board[i][j] == "ʮ") {
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
		if (ico == "��") {
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
		} else if (ico == "��") {
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
	 * �ж���Ӯ
	 * 
	 * @param posX
	 *            ���ӵ�X���ꡣ
	 * @param posY
	 *            ���ӵ�Y����
	 * @param ico
	 *            ��������
	 * @return ��������������������һ��ֱ�ӣ������棬�����෴��
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
