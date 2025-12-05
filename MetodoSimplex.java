import java.util.Scanner;
 class MetodoSimplex {
    public static void main (String [] args){
        Scanner lector= new Scanner (System.in);
        byte opcion;
        double X1, X2, menorCociente, cociente;
        byte restricciones, fila;
        double [][] tablaSimplex = new double[6][3];
        byte columnaPivote, filaPivote;
        do{

        System.out.println("Metodo simplex:");
        System.out.println("1. Maximizacion");
        System.out.println("2. Minimizacion");
        System.out.println("3. Salir");
        opcion=lector.nextByte();

        switch (opcion){
            case 1->{
                System.out.println("Maximizacion");
                System.out.println("Ingresa el coeficiente de X1:");
                X1=lector.nextDouble();
                System.out.println("Ingresa el coeficiente de X2:");
                X2=lector.nextDouble();

                System.out.println("Ingresa el numero de restricciones (Max. 5):");
                restricciones= lector.nextByte();

                for(fila = 0;fila < restricciones; fila++){
                    System.out.println("Restriccion " + (fila + 1));
                    System.out.println("Coeficiente X1: ");
                    tablaSimplex[fila][0]=lector.nextDouble();
                    System.out.println("Coeficiente X2: ");
                    tablaSimplex[fila][1]=lector.nextDouble();
                    System.out.println("<= : ");
                    tablaSimplex[fila][2]=lector.nextDouble();
                }
                tablaSimplex[restricciones][0]=(-1)*X1;
                tablaSimplex[restricciones][1]=(-1)*X2;
                tablaSimplex[restricciones][2]=0;

                while(tablaSimplex[restricciones][0] < 0 || tablaSimplex[restricciones][1] < 0){
                    if(tablaSimplex [restricciones][0]< tablaSimplex[restricciones][1]){
                        columnaPivote=0;
                    }else{
                        columnaPivote=1;
                    }
                }

                menorCociente=Double.MAX_VALUE;
                for(fila=0;fila<restricciones;fila++){
                    if (tablaSimplex[fila][columnaPivote]<0) {
                        cociente = tablaSimplex[fila][2]/tablaSimplex [fila][columnaPivote];
                        if(cociente<menorCociente){
                            menorCociente=cociente;
                            filaPivote=fila;
                        }
                        
                    }
                }
            }
            case 2->{
                System.out.println("Minimizacion");
                System.out.println("Ingresa el coeficiente de X1:");
                X1=lector.nextDouble();
                System.out.println("Ingresa el coeficiente de X2:");
                X2=lector.nextDouble();


                System.out.println("Ingresa el numero de restricciones (Max. 5):");
                restricciones= lector.nextByte();

                for(fila = 0;fila < restricciones; fila++){
                    System.out.println("Restriccion " + (fila + 1));
                    System.out.println("Coeficiente X1: ");
                    tablaSimplex[fila][0]=lector.nextDouble();
                    System.out.println("Coeficiente X2: ");
                    tablaSimplex[fila][1]=lector.nextDouble();
                    System.out.println("<= : ");
                    tablaSimplex[fila][2]=lector.nextDouble();
                }
                tablaSimplex[restricciones][0]=X1;
                tablaSimplex[restricciones][1]=X2;
                tablaSimplex[restricciones][2]=0;

                while(tablaSimplex[restricciones][0] < 0 || tablaSimplex[restricciones][1] < 0){
                    if(tablaSimplex [restricciones][0]< tablaSimplex[restricciones][1]){
                        columnaPivote=0;
                    }else{
                        columnaPivote=1;
                    }
                }
                

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
