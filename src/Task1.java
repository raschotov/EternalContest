public class Task1 {
	public static void main(String[] args) throws Exception {
		System.out.println(internetPrice(100, 10, 12,15));
		System.out.println(internetPrice(100, 10, 12, 1));
		System.out.println(internetPrice(0, 10, 0, -100));
	}

	public static int internetPrice(int tariffPricePerMonth, int tariffMegabytesValue, int extraMegabyteCost, int megabytesGonnaWaste) throws Exception{
		//Проверка на ввод отрицательных значений
		if (tariffMegabytesValue < 0 | tariffMegabytesValue < 0 | extraMegabyteCost < 0 | megabytesGonnaWaste < 0) {
			throw new Exception("Введены отрицательные значения!");
		}

		if (megabytesGonnaWaste <= tariffMegabytesValue) {
			return tariffPricePerMonth;
		}
		else {
			return (megabytesGonnaWaste - tariffMegabytesValue) * extraMegabyteCost + tariffPricePerMonth;
		}
	}
}