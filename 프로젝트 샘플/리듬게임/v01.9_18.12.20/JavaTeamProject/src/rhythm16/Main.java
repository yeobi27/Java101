package rhythm16;

import login.Start;

public class Main {

	public static final int SCREEN_WIDTH = 1280; // 가로
	public static final int SCREEN_HEIGHT = 720; // 세로
	public static final int NOTE_SPEED = 7; // 노드 하강스피드
	public static final int SLEEP_TIME = 10;
	public static final int REACH_TIME = 2; // 노드 생성 후 도착하기까지 시간

	public static void main(String[] args) {

		new Start();

	}
}
