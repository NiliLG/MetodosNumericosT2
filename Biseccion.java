package biseccion;

import java.util.Scanner;

public class Biseccion {
    public static double funcion(double x, int opc){
        double f = 0;
        switch (opc){
            case 1:
                //(x^10)-1
                f = recortarDecimales(Math.pow(x, 10),9);
                f = f - 1;
                break;
            case 2: 
                //(x^4)-x+2
                f = recortarDecimales(Math.pow(x, 4),9);
                f = f - x + 2;
                break;
            case 3: 
                //(x^2)+2x-1
                f = recortarDecimales(Math.pow(x, 2),9);
                f = f + 2*x -1;
                break;
            case 4: 
                //4x+(x^2)+(x^3)
                f = recortarDecimales(Math.pow(x, 2),9);
                f = 4*x + f + recortarDecimales(Math.pow(x, 3),9);
                break;
            case 5: 
                //3x+x^5
                f = 3*x + recortarDecimales(Math.pow(x, 5),9);
                break;
            default: f=0;
        }
        return f;
    }
    private static double recortarDecimales(double numero, int decimales) {
        double factor = Math.pow(10, decimales);
        return ((int) (numero * factor)) / factor;
    }
    public  double biseccion(double a, double b, double porcentaje, int opc) {
        double c = 0;

        do {
            c = (a + b) / 2;

            if (funcion(c,opc) == 0.0) {
                break;
            } else if (funcion(c,opc) * funcion(a,opc) < 0) {
                b = c;
            } else {
                a = c;
            }
        } while (Math.abs(b - a) / b >= porcentaje);

        return c;
    }
    public static void main(String[] args) {
        Biseccion var = new Biseccion();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Método de Bisección");
        System.out.println("\nFunciones: ");
        System.out.println("1.  f(x) = (x^10) - 1");
        System.out.println("2.  f(x) = (x^4) - x + 2");
        System.out.println("3.  f(x) = (x^2) + 2x - 1");
        System.out.println("4.  f(x) = 4x + (x^2) + (x^3)");
        System.out.println("5.  f(x) = 3x + x^5");
        System.out.print("\nIngresa el número de función que deseas resolver: ");
        int opc = scanner.nextInt();
        System.out.print("Límite inferior: ");
        double a = scanner.nextDouble();
        System.out.print("Límite superior: ");
        double b = scanner.nextDouble();
        System.out.print("Porcentaje de error aceptable: ");
        double porcentaje = scanner.nextDouble() / 100;
        
        double root = var.biseccion(a, b, porcentaje, opc);
        System.out.print("\nLa raíz aproximada con el Método de bisección es: "+ root);
        System.out.println("");
        scanner.close();
    }
    
}
