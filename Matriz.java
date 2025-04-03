
import java.util.Scanner;



public class Matriz{

    public static Scanner sc = new Scanner (System.in);

    public static double[][] leMatriz (int numLinhas, int numColunas){
        double[][] M =  new double[numLinhas][numColunas];
        for (int i = 0; i < numLinhas; i++)
            for (int j = 0; j < numColunas; j++){
                System.out.println("digite o valor a recebido:");
                M[i][j] = sc.nextDouble();
            }
        return M;
    }
    public static double[][] MultMatriz (double[][]A, double[][]B){
        int numLinhasA = A.length;
        int numLinhasB = B.length;
        int numColunasB = B[0].length;
        double[][] resultado = new double[numLinhasA][numLinhasB];
        for (int i = 0; i < numLinhasA; i++){
            for (int j = 0; j < numColunasB; j++){
                resultado[i][j] = 0;
                for (int k = 0; k < numLinhasB; k++)
                    resultado[i][j] = resultado[i][j] + (A[i][k] * B[k][j]);
            }
        }
        return resultado;
    }

    public static void imprimeMatriz (double[][] M){
        int numLinhas = M.length;
        int numColunas = M[0].length;
        for (int i = 0; i < numLinhas; i++){
            System.out.print("\n");
            for (int j = 0; j < numColunas; j++)
                System.out.print(M[i][j] + " ");
        }
    }


    public static void main (String[] args) {
        if (args.length < 4){
            System.out.println("Digite as dimensões da matriz");
            return;
        }
        int ax = Integer.parseInt(args[0]);
        int ay = Integer.parseInt(args[1]);
        int bx = Integer.parseInt(args[2]);
        int by = Integer.parseInt(args[3]);

        double[][]A;
        double[][]B;
        double[][]C;


        A = leMatriz(ax, ay);
        B = leMatriz(bx, by);
        C = MultMatriz(A, B);
        
        imprimeMatriz(C);
    }
}