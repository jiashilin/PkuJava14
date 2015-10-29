import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GobangGame {
	// 定义达到赢条件的棋子数目
	private final int WIN_COUNT = 5;
	// 定义用户输入的X坐标
	private int posX = 0;
	// 定义用户输入的X坐标
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
		if (posX < 0 || posX >= Chessboard.BOARD_SIZE || posY < 0
				|| posY >= Chessboard.BOARD_SIZE) {
			chessboard.printBoard();
			System.out.println("X与Y坐标只能大于等于1,与小于等于" + Chessboard.BOARD_SIZE
					+ ",请重新输入：");
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
				chessboard.setBoard(computerPosArr[0], computerPosArr[1],
						chessman);
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
		String message = chessman.equals(Chessman.BLACK.getChessman()) ? "恭喜您，您赢了，"
				: "很遗憾，您输了，";
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
	/*public int[] computerDo() {

		int posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		int posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		String[][] board = chessboard.getBoard();
		while (board[posX][posY] != "十") {
			posX = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
			posY = (int) (Math.random() * (Chessboard.BOARD_SIZE - 1));
		}
		int[] result = { posX, posY };
		return result;
	}	
	*/
	
	/**
	 * 计算机下棋 根据评分表对棋盘的每个空格进行打分 打分分为两种情况：黑棋和白棋 电脑为白棋，人为黑棋
	 * 分别打分后找出两张评分结果的最大值，进行比较
	 * 选择较大的一方的位置作为电脑落子的位置，这样可以做到攻守兼备
	 */

	public int[] computerDo() {
		String[][] board = chessboard.getBoard();
		int[][] ComScore=new int[chessboard.BOARD_SIZE][chessboard.BOARD_SIZE];
		int[][] PerScore=new int[chessboard.BOARD_SIZE][chessboard.BOARD_SIZE];
		int posX = 0,posY = 0;
		for(int i=0;i<chessboard.BOARD_SIZE;i++){
			for(int j=0;j<chessboard.BOARD_SIZE;j++){
				if(board[i][j]=="十"){
					ComScore[i][j]=CalScore(i,j,"○");
					PerScore[i][j]=CalScore(i,j,"●");
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
	//计算每个空格位置的分数
	public int CalScore(int posX, int posY, String ico) {
		int score = 0;
		String[][] board = chessboard.getBoard();
		int i = 1;
		int j = 1;
		// 从横、纵、右斜、左斜四个方向进行判断，分别判断每个方向的连子情况，根据评分表打分
		// 判断横向
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
		// 判断纵向

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
		// 判断右斜

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
		// 判断左斜

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
	//对于黑白两种情况，所设的分值不同。由于电脑为白棋，以电脑攻击为先，所设的分值要大于黑棋
	public int Score(int count, String ico) {
		int score = 0;
		if (ico == "○") {
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
		} else if (ico == "●") {
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
		String[][] board = chessboard.getBoard();
		int s = posX, e = posX;
		int i = 1;
		int j = 1;
		while (true) {// 判断横向

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
		while (true) {// 判断纵向

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
		while (true) {// 判断右斜

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
		while (true) {// 判断左斜

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
