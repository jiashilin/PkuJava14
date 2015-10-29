import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GobangGame {
	// ����ﵽӮ������������Ŀ
	private final int WIN_COUNT = 5;
	// �����û������X����
	private int posX = 0;
	// �����û������X����
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
		if (posX < 0 || posX >= Chessboard.BOARD_SIZE || posY < 0
				|| posY >= Chessboard.BOARD_SIZE) {
			chessboard.printBoard();
			System.out.println("X��Y����ֻ�ܴ��ڵ���1,��С�ڵ���" + Chessboard.BOARD_SIZE
					+ ",���������룺");
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
				chessboard.setBoard(computerPosArr[0], computerPosArr[1],
						chessman);
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
		String message = chessman.equals(Chessman.BLACK.getChessman()) ? "��ϲ������Ӯ�ˣ�"
				: "���ź��������ˣ�";
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
	/*public int[] computerDo() {

		int posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		int posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		String[][] board = chessboard.getBoard();
		while (board[posX][posY] != "ʮ") {
			posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
			posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		}
		int[] result = { posX, posY };
		return result;
	}	
	*/
	
	/**
	 * ��������� �������ֱ�����̵�ÿ���ո���д�� ��ַ�Ϊ�������������Ͱ��� ����Ϊ���壬��Ϊ����
	 * �ֱ��ֺ��ҳ��������ֽ�������ֵ�����бȽ�
	 * ѡ��ϴ��һ����λ����Ϊ�������ӵ�λ�ã����������������ؼ汸
	 */

	public int[] computerDo() {
		String[][] board = chessboard.getBoard();
		int[][] ComScore=new int[chessboard.BOARD_SIZE][chessboard.BOARD_SIZE];
		int[][] PerScore=new int[chessboard.BOARD_SIZE][chessboard.BOARD_SIZE];
		int posX = 0,posY = 0;
		for(int i=0;i<chessboard.BOARD_SIZE;i++){
			for(int j=0;j<chessboard.BOARD_SIZE;j++){
				if(board[i][j]=="ʮ"){
					ComScore[i][j]=CalScore(i,j,"��");
					PerScore[i][j]=CalScore(i,j,"��");
				}else{
					ComScore[i][j]=-1;
					PerScore[i][j]=-1;
				}
				
			}
		}
		
		int ComMax=0,PerMax=0;
		int ComPosX = 0,ComPosY=0,PerPosX=0,PerPosY=0;
		for(int i=0;i<chessboard.BOARD_SIZE;i++){
			for(int j=0;j<chessboard.BOARD_SIZE;j++){
				if(ComMax<ComScore[i][j]){
					ComMax=ComScore[i][j];
					ComPosX=i;
					ComPosY=j;
				}
				if(PerMax<PerScore[i][j]){
					PerMax=PerScore[i][j];
					PerPosX=i;
					PerPosY=j;
				}
			}
		}
		
		if(ComMax>=PerMax){
			posX=ComPosX;
			posY=ComPosY;
		}else{
			posX=PerPosX;
			posY=PerPosY;
		}
		int[] result = { posX, posY };
		return result;
	}
	//����ÿ���ո�λ�õķ���
	public int CalScore(int posX, int posY, String ico) {
		int score = 0;
		String[][] board = chessboard.getBoard();
		int i = 1;
		int j = 1;
		// �Ӻᡢ�ݡ���б����б�ĸ���������жϣ��ֱ��ж�ÿ�����������������������ֱ���
		// �жϺ���
		int s = posX, e = posX;
		while (posX - i >= 0 && board[posX - i][posY] == ico && i < 5) {
			s = posX - i;
			i++;
		}
		while (posX + j < 22 && board[posX + j][posY] == ico && j < 5) {
			e = posX + j;
			j++;
		}
		score += Score(e - s, ico);

		i = j = 1;
		e = s = posY;
		// �ж�����

		while (posY - i >= 0 && board[posX][posY - i] == ico && i < 5) {
			s = posY - i;
			i++;
		}

		while (posY + j < 22 && board[posX][posY + j] == ico && j < 5) {
			e = posY + j;
			j++;
		}
		score += Score(e - s, ico);

		i = j = 1;
		e = s = posX;
		// �ж���б

		while (posX - i >= 0 && posY - i >= 0
				&& board[posX - i][posY - i] == ico && i < 5) {
			s = posX - i;
			i++;
		}

		while (posX + j < 22 && posY + j < 22
				&& board[posX + j][posY + j] == ico && j < 5) {
			e = posX + j;
			j++;
		}
		score += Score(e - s, ico);

		i = j = 1;
		e = s = posX;
		// �ж���б

		while (posX - i >= 0 && posY + i < 22
				&& board[posX - i][posY + i] == ico && i < 5) {
			s = posX - i;
			i++;
		}

		while (posX + j < 22 && posY - j >= 0
				&& board[posX + j][posY - j] == ico && j < 5) {
			e = posX + j;
			j++;
		}
		score += Score(e - s, ico);

		return score;
	}
	//���ںڰ��������������ķ�ֵ��ͬ�����ڵ���Ϊ���壬�Ե��Թ���Ϊ�ȣ�����ķ�ֵҪ���ں���
	public int Score(int count, String ico) {
		int score = 0;
		if (ico == "��") {
			switch (count) {
			case 0:
				score = 0;
				break;
			case 1:
				score = 10;
				break;
			case 2:
				score = 100;
				break;
			case 3:
				score = 1000;
				break;
			case 4:
				score = 10000;
				break;
			}
		} else if (ico == "��") {
			switch (count) {
			case 0:
				score = 0;
				break;
			case 1:
				score = 5;
				break;
			case 2:
				score = 50;
				break;
			case 3:
				score = 500;
				break;
			case 4:
				score = 5000;
				break;
			}
		}
		return score;
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
		String[][] board = chessboard.getBoard();
		int s = posX, e = posX;
		int i = 1;
		int j = 1;
		while (true) {// �жϺ���

			while (posX - i >= 0 && board[posX - i][posY] == ico && i < 5) {
				s = posX - i;
				i++;
			}

			while (posX + j < 22 && board[posX + j][posY] == ico && j < 5) {
				e = posX + j;
				j++;
			}
			if (e - s >= 4) {
				return true;
			} else {
				break;
			}
		}
		i = j = 1;
		e = s = posY;
		while (true) {// �ж�����

			while (posY - i >= 0 && board[posX][posY - i] == ico && i < 5) {
				s = posY - i;
				i++;
			}

			while (posY + j < 22 && board[posX][posY + j] == ico && j < 5) {
				e = posY + j;
				j++;
			}
			if (e - s >= 4) {
				return true;
			} else {
				break;
			}
		}

		i = j = 1;
		e = s = posX;
		while (true) {// �ж���б

			while (posX - i >= 0 && posY - i >= 0
					&& board[posX - i][posY - i] == ico && i < 5) {
				s = posX - i;
				i++;
			}

			while (posX + j < 22 && posY + j < 22
					&& board[posX + j][posY + j] == ico && j < 5) {
				e = posX + j;
				j++;
			}
			if (e - s >= 4) {
				return true;
			} else {
				break;
			}
		}

		i = j = 1;
		e = s = posX;
		while (true) {// �ж���б

			while (posX - i >= 0 && posY + i < 22
					&& board[posX - i][posY + i] == ico && i < 5) {
				s = posX - i;
				i++;
			}

			while (posX + j < 22 && posY - j >= 0
					&& board[posX + j][posY - j] == ico && j < 5) {
				e = posX + j;
				j++;
			}
			if (e - s >= 4) {
				return true;
			} else {
				break;
			}
		}

		return false;
	}

	public static void main(String[] args) throws Exception {

		GobangGame gb = new GobangGame(new Chessboard());
		gb.start();
	}
}
