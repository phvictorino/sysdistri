import java.util.Scanner;

public class Aula {

	public static void main(String[] args) {

		double lado1, lado2, lado3;

		Scanner s = new Scanner(System.in);

		System.out.println("Digite o primeiro lado: ");
		lado1 = s.nextDouble();
		System.out.println("Digite o segundo lado: ");
		lado2 = s.nextDouble();
		System.out.println("Digite o terceiro lado: ");
		lado3 = s.nextDouble();

		if (lado1 == lado2 && lado2 == lado3 && lado1 == lado3) {
			System.out.println("Equilátero");
		} else if (lado1 == lado2 || lado2 == lado3 || lado1 == lado3) {
			System.out.println("Isóceles");
		} else {
			System.out.println("Escaleno");
		}

	}

}
