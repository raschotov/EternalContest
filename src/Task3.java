import java.util.Scanner;

public class Task3 {
	public static void main(String[] args) {
		setEmployeesAndTimeout(5, 5);
		setEmployeesFloors(1, 4, 9, 16, 25);
		setNumberEmployeeToGo(2);
		System.out.println("Потребуется минут: " + findTimeToRoute());

		setEmployeesAndTimeout(6, 4);
		setEmployeesFloors(1, 2, 3, 6, 8, 25);
		setNumberEmployeeToGo(5);
		System.out.println("Потребуется минут: " + findTimeToRoute());
	}

	private static int employeesCount;
	private static int employeeTimeout;
	private static int[] employeesFloors;
	private static int numberEmployeeToGo;


	public static void setEmployeesAndTimeout (int count, int timeout){
		System.out.println("Количество сотрудников: " + count + "\nВремя, через которое один из них уйдёт: " + timeout);
		employeesCount = count;
		employeeTimeout = timeout;
		employeesFloors = new int[count];
	}

	public static void setEmployeesFloors(int... floors) {
		employeesFloors = floors;
	}

	public static void setNumberEmployeeToGo (int number){
		numberEmployeeToGo = number;
	}

	private static int getMoveStraightTime(int min, int max) {
		return max - min;
	}

	public static int findTimeToRoute() {
		int minFloorValue = employeesFloors[0];
		int maxFloorValue = employeesFloors[employeesCount - 1];
		int employeeToGoFloorValue = employeesFloors[numberEmployeeToGo - 1];

		//Уходящий сотрудник - на первом или последнем из нужных этажей
		if ((numberEmployeeToGo == 1) | (numberEmployeeToGo == employeesCount)) {
			System.out.println("Вы проходите этажи напрямую один за другим.");
			return getMoveStraightTime(minFloorValue, maxFloorValue);
		}

		//А успеем ли пройти напрямую?
		else if ((employeeToGoFloorValue - minFloorValue) <= employeeTimeout | (maxFloorValue - employeeToGoFloorValue) <= employeeTimeout) {
			System.out.println("Времени перед уходом сотрудника достаточно, чтобы успеть пройти напрямую");
			return getMoveStraightTime(minFloorValue, maxFloorValue);
		}

		// Если нет времени идти напрямую: выходим на этаже "уходящего", идём в одну или другую сторону, возвращаемся, и далее до последнего коллеги
		else {
			//Если ближе к нижним этажам
			if ((employeeToGoFloorValue - minFloorValue) < (maxFloorValue - employeeToGoFloorValue)) {
				System.out.println("Наш сотрудник ближе к нижним этажам");
				return ((maxFloorValue - employeeToGoFloorValue) + (employeeToGoFloorValue - minFloorValue) * 2);
			}
			//Если ближе к верхним этажам
			else {
				System.out.println("Наш сотрудник ближе к верхним этажам");
				return ((employeeToGoFloorValue - minFloorValue) -  + ((maxFloorValue - employeeToGoFloorValue) * 2));
			}
		}
	}
}

/*
Рабочая версия, требуется:
- проверить кейс когда сотрудник ближе к верхним
- когда одинаковое расстояние
- нет проверки на корректность вводимых данных
- можно добавить интерактива
 */