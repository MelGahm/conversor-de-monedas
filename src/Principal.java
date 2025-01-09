import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConversorDeMonedas conversor = new ConversorDeMonedas();

        System.out.println("Bienvenido al Conversor de Monedas");
        boolean continuar = true;

        while (continuar) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Convertir de USD a ARS");
            System.out.println("2. Convertir de BRL a USD");
            System.out.println("3. Convertir de ARS a USD");  // Nueva opción
            System.out.println("4. Salir");
            int opcion = Integer.parseInt(lectura.nextLine());

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el monto en dólares: ");
                    double montoUSD = Double.parseDouble(lectura.nextLine());
                    double resultadoARS = conversor.convertirUSD_A_ARS(montoUSD);
                    System.out.println(montoUSD + " USD equivale a " + resultadoARS + " ARS.");
                    break;
                case 2:
                    System.out.print("Ingrese el monto en reales brasileños: ");
                    double montoBRL = Double.parseDouble(lectura.nextLine());
                    double resultadoUSD = conversor.convertirBRL_A_USD(montoBRL);
                    System.out.println(montoBRL + " BRL equivale a " + resultadoUSD + " USD.");
                    break;
                case 3:
                    System.out.print("Ingrese el monto en pesos argentinos: ");
                    double montoARSInput = Double.parseDouble(lectura.nextLine());
                    double resultadoUSDfromARS = conversor.convertirARS_A_USD(montoARSInput);
                    System.out.println(montoARSInput + " ARS equivale a " + resultadoUSDfromARS + " USD.");
                    break;
                case 4:
                    continuar = false;
                    System.out.println("Gracias por usar el conversor de monedas.");
                    break;
                default:
                    System.out.println("Opción no válida, por favor intente de nuevo.");
            }
        }
    }
}
