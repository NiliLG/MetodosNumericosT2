package secante;

import java.util.Scanner;

public class Secante {
    public static double funcion(double x, int opc){
        double f = 0;
        switch (opc){
            case 1:
                //(x^10) - 1
                f = recortarDecimales(Math.pow(x, 10),9);
                f = f - 1;
                break;
            case 2: 
                //x - 1
                f =  x - 1;
                break;
            case 3: 
                //16 * (x^2) + 11
                f = 16 * recortarDecimales(Math.pow(x, 2),9) + 11;
                break;
            case 4: 
                //x + (x^2) + (x^3)
                f = x + recortarDecimales(Math.pow(x, 2),9) + recortarDecimales(Math.pow(x, 3),9);
                break;
            case 5: 
                //2 + x^5
                f = 2 + recortarDecimales(Math.pow(x, 5),9);
                break;
            default: f=0;
        }
        return f;
    }
    private static double recortarDecimales(double numero, int decimales) {
        double factor = Math.pow(10, decimales);
        return ((int) (numero * factor)) / factor;
    }
    
    public static void main(String[] args) {
        Secante var = new Secante();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Método de la Regla Falsa");
        System.out.println("\nFunciones: ");
        System.out.println("1.  f(x) = (x^10) - 1");
        System.out.println("2.  f(x) = x - 1");
        System.out.println("3.  f(x) = 16 * (x^2) + 11");
        System.out.println("4.  f(x) = x + (x^2) + (x^3)");
        System.out.println("5.  f(x) = 2 + x^5");
        System.out.print("\nIngresa el número de función que deseas resolver: ");
        int opc = scanner.nextInt();
        System.out.print("Límite inferior: ");
        double a = scanner.nextDouble();
        System.out.print("Límite superior: ");
        double b = scanner.nextDouble();
        System.out.print("Porcentaje de error aceptable: ");
        double porcentaje = scanner.nextDouble() / 100;
        double x0 = a;
        double x1 = b;
        double x2 = 0;
        double error = 1;
        
        while(error > porcentaje) {
            x2 = x1 - (funcion(x1, opc) * (x1 - x0)) / (funcion(x1, opc) - funcion(x0, opc));
            error = Math.abs((x2 - x1) / x2);
            x0 = x1;
            x1 = x2;
        }
        
        System.out.println("La raíz aproximada con el Método de la secante: " + x2);
    }
    
}
