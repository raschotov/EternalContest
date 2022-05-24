public class Task2 {
	public static void main(String[] args) throws Exception{
		System.out.println(minimumSlices(6));
		System.out.println(minimumSlices(5));
	}
	public static int minimumSlices(int people) throws Exception {
		if (people == 0) {
			throw new Exception("Введено нулевое количество людей. Не для кого разрезать торт.");
		}

		if (people == 1) {
			throw new Exception("Указан один человек. Разрезать торт не надо.");
		}

		if (people < 0) {
			throw new Exception("Некорректное значение: указано отрицательное количество людей");
		}

		int slicesCount = 0;
		int partsToSliceLeft = people;

		if (people % 2 == 1) {
			while (partsToSliceLeft != 0) {
				partsToSliceLeft = partsToSliceLeft / 2;
				slicesCount++;
			}
			return slicesCount;
		}

		else {
			while (partsToSliceLeft != 1) {
				partsToSliceLeft = partsToSliceLeft / 2;
				slicesCount++;
			}
			return slicesCount + 1;
		}
	}
}
