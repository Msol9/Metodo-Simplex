import java.util.Scanner;
 class MetodoSimplex {
    public static void main (String [] args){
        Scanner lector= new Scanner (System.in);
        byte opcion;
        double X1, X2, menorCociente, cociente, pivote, multiplicador, solucionX1, solucionX2, solucionZ;
        byte restricciones, fila, filaUno, contadorUno;
        double [][] tablaSimplex = new double[6][8];
        byte columnaPivote, filaPivote=0, numeroColumnas=0;

        do{

        System.out.println("Metodo simplex:");
        System.out.println("1. Maximizacion");
        System.out.println("2. Minimizacion");
        System.out.println("3. Salir");
        opcion=lector.nextByte();

        switch (opcion){
            case 1->{
                System.out.println("\nMaximizacion");
                System.out.println("Ingresa el coeficiente de X1:");
                X1=lector.nextDouble();
                System.out.println("Ingresa el coeficiente de X2:");
                X2=lector.nextDouble();

                System.out.println("\nIngresa el numero de restricciones (Max. 5):");
                restricciones= lector.nextByte();

                numeroColumnas = (byte) (2 + restricciones + 1);

                for(fila = 0;fila < restricciones; fila++){
                    System.out.println("\nRestriccion " + (fila + 1));
                    System.out.println("Coeficiente X1: ");
                    tablaSimplex[fila][0]=lector.nextDouble();
                    System.out.println("Coeficiente X2: ");
                    tablaSimplex[fila][1]=lector.nextDouble();
                    
                    tablaSimplex[fila][2 + fila] = 1.0;
                    System.out.println("<= : ");
                    tablaSimplex[fila][numeroColumnas - 1] = lector.nextDouble();
                }
                tablaSimplex[restricciones][0]=(-1)*X1;
                tablaSimplex[restricciones][1]=(-1)*X2;
                for(int j = 2; j < numeroColumnas - 1; j++){
                    tablaSimplex[restricciones][j] = 0.0;
                }
                tablaSimplex[restricciones][numeroColumnas-1]=0;

                while(tablaSimplex[restricciones][0]<0 || tablaSimplex[restricciones][1]<0){
                    if(tablaSimplex [restricciones][0]< tablaSimplex[restricciones][1]){
                        columnaPivote=0;
                    }else{
                        columnaPivote=1;
                    }
                

                menorCociente=Double.MAX_VALUE;
                filaPivote = -1;
                for(fila=0;fila<restricciones;fila++){
                    if (tablaSimplex[fila][columnaPivote]>0) {
                        cociente = tablaSimplex[fila][numeroColumnas-1]/tablaSimplex [fila][columnaPivote];
                        if(cociente<menorCociente){
                            menorCociente=cociente;
                            filaPivote=fila;
                        }
                        
                    }
                }
                if (filaPivote==-1) {
                    break;
                }
                pivote= tablaSimplex[filaPivote][columnaPivote];
                for(int i=0; i<numeroColumnas; i++){
                    tablaSimplex [filaPivote][i]/=pivote;
                
                }
                for(fila=0;fila<=restricciones;fila++){
                    if(fila!= filaPivote){
                        multiplicador=tablaSimplex[fila][columnaPivote];
                        for(int i=0;i<numeroColumnas;i++){
                            tablaSimplex[fila][i]-=multiplicador*tablaSimplex[filaPivote][i];
                    }
                }
            }
        }
            solucionX1=0;
            solucionX2=0;
            for(int i=0; i<2;i++){
                filaUno=-1;
                contadorUno=0;
                for(int j=0;j<restricciones;j++){
                    if(tablaSimplex[j][i]==1){
                        filaUno=(byte) j;
                        contadorUno++;
                    }else if(tablaSimplex[j][i]!=0){
                        contadorUno=99;
                        break;
                    }
                }
                if (contadorUno==1) {
                    if (i==0) {
                        solucionX1=tablaSimplex[filaUno][numeroColumnas-1];
                    }else{
                        solucionX2=tablaSimplex[filaUno][numeroColumnas-1];
                    }
                }
            }
            solucionZ=tablaSimplex[restricciones][numeroColumnas-1];

            System.out.println("\nResultados finales: ");
            System.out.println("X1 = " + solucionX1);
            System.out.println("X2 = " + solucionX2);
            System.out.println("Z = "+ solucionZ);
        }
            case 2->{
                System.out.println("\n");
                System.out.println("Ingresa el coeficiente de X1:");
                X1=lector.nextDouble();
                System.out.println("Ingresa el coeficiente de X2:");
                X2=lector.nextDouble();


                System.out.println("\nIngresa el numero de restricciones (Max. 5):");
                restricciones= lector.nextByte();

                for(fila = 0;fila < restricciones; fila++){
                    System.out.println("\nRestriccion " + (fila + 1));
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

                while(tablaSimplex[restricciones][0]<0 || tablaSimplex[restricciones][1]<0){
                    if(tablaSimplex [restricciones][0]< tablaSimplex[restricciones][1]){
                        columnaPivote=0;
                    }else{
                        columnaPivote=1;
                    }
                
                menorCociente=Double.MAX_VALUE;
                for(fila=0;fila<restricciones;fila++){
                    if (tablaSimplex[fila][columnaPivote]>0) {
                        cociente = tablaSimplex[fila][2]/tablaSimplex [fila][columnaPivote];
                        if(cociente<menorCociente){
                            menorCociente=cociente;
                            filaPivote=fila;
                        }
                        
                    }
                }
                pivote= tablaSimplex[filaPivote][columnaPivote];
                for(int i=0; i<3; i++){
                    tablaSimplex [filaPivote][i]/=pivote;
                }
                
                for(fila=0;fila<=restricciones;fila++){
                    if(fila!= filaPivote){
                        multiplicador=tablaSimplex[fila][columnaPivote];
                        for(int i=0;i<3;i++){
                            tablaSimplex[fila][i]-=multiplicador*tablaSimplex[filaPivote][i];
                    }
                }
                }
            }   
            solucionX1=tablaSimplex[0][2];
            solucionX2=tablaSimplex[1][2];
            solucionZ=tablaSimplex[restricciones][2];

            System.out.println("\nResultados finales: ");
            System.out.println("X1 = " + solucionX1);
            System.out.println("X2 = " + solucionX2);
            System.out.println("Z = "+ solucionZ);
            }
        
            default->{
                if (opcion!=3) {
                    System.out.println("Opcion invalida, intenta nuevamente.");
                }
            }
        }
    }while (opcion !=3);
    
    }
}