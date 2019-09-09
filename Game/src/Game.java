import java.lang.Math;
import java.util.ArrayList;

class Point {

	int order = 0;
	int pointX = 0;
	int pointY = 0;
	Double distance = 0.0;

	Point(int _order) {

		this.order = _order;
		this.pointX = 0;
		this.pointY = 0;

		// 1~10까지 값만 들어가게 설정 해준 부분.(좌표X부분)
		this.pointX = (int) (Math.random() * 10 + 1);
		do {
			// 1~10까지 값만 들어가게 설정 해준 부분.(좌표Y부분)
			this.pointY = (int) (Math.random() * 10 + 1);
			// 조건문, X좌표와 Y좌표의 값이 같으면 안된다. 같다면 계속돌아가게
		} while (this.pointX == this.pointY);
	}

	// 점간의 거리를 구하는 메소드
	Double distanceToThirdPoint(Point _other) {
		// Double을 사용해서 소수점까지 계산가능하도록 만듬.
		Double dist = 0.0;
		dist = Math.sqrt(Math.pow(this.pointX - _other.pointX, 2) + Math.pow(this.pointY - _other.pointY, 2));

		return dist;
	}
}

public class Game {

	public static void main(String[] args) {

		Game game = new Game();
		ArrayList<Point> point = new ArrayList<Point>();

		for (int i = 0; i < 5; i++) {
			point.add(new Point(i + 1));
		}

		game.checkDistance(point);
		game.printPoints(point);
		game.descendingOrder(point);
		game.printPoints(point);

		System.out.println("첫 번째로 가까운 " + point.get(point.size() - 2).order + "번째 점" + "아 미사일 맞자.");
		System.out.println("두 번째로 가까운 " + point.get(point.size() - 3).order + "번째 점" + "아 미사일 맞자.");

	}

	void printPoints(ArrayList<Point> _point) {

		for (int i = 0; i < _point.size(); i++) {

			System.out.print(_point.get(i).order + "번째 점(" + _point.get(i).pointX + ", " + _point.get(i).pointY + ")"
					+ "dist:" + _point.get(i).distance + "   ");
		}
		System.out.println();
	}

	void descendingOrder(ArrayList<Point> _point) {

		Point temp = null;

		for (int i = 0; i < 3; i++) {
			for (int j = 1; j < _point.size() - i; j++) {
				if (_point.get(j - 1).distance < _point.get(j).distance) {
					temp = _point.get(j);
					_point.set(j, _point.get(j - 1));
					_point.set(j - 1, temp);
				}
			}
		}
	}

	void checkDistance(ArrayList<Point> _point) {
		for (int i = 0; i < _point.size(); i++) {
			_point.get(i).distance = _point.get(i).distanceToThirdPoint(_point.get(2));
		}
	}
}