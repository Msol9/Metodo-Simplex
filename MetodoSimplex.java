import java.util.Scanner;
 class MetodoSimplex {
    public static void main (String [] args){
        Scanner lector= new Scanner (System.in);
        byte opcion;
        do{

        System.out.println("Metodo simplex:");
        System.out.println("1. Maximizacion");
        System.out.println("2. Minimizacion");
        System.out.println("3. Salir");
        opcion=lector.nextByte();

        switch (opcion){
            case 1->{
                System.out.println("Maximizacion");
            }
            case 2->{
                System.out.println("Minimizacion");
            }
            default->{
                if (opcion!=3) {
                    System.out.println("Opcion invalida, intenta nuevamente.");
                }
            }
        }
        } while (opcion !=3);
    }
}
