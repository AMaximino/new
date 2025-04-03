
import java.util.Scanner;



public class Matriz{
    int l;
    int c;
    private double[][] Valores;

    public static Scanner sc = new Scanner (System.in);

    public Matriz(int nlinhas, int ncolunas){
        l = nlinhas; c= ncolunas;
        Valores = new double[nlinhas][ncolunas];
    }

    public void leMatriz (){
        for (int i = 0; i < l; i++)
            for (int j = 0; j < c; j++){
                System.out.println("digite o valor a recebido:");
                Valores[i][j] = sc.nextDouble();
            }
    }

    public static Matriz MultMatriz (Matriz A, Matriz B){
        Matriz C = new Matriz (A.l, B.c);
        for (int i = 0; i < A.l; i++){
            for (int j = 0; j < B.c; j++){
                C.Valores[i][j] = 0;
                for (int k = 0; k < A.l; k++)
                    C.Valores[i][j] = C.Valores[i][j] + (A.Valores[i][k] * B.Valores[k][j]);
            }
        }
        return C;
    }

    public void imprimeMatriz (){
        for (int i = 0; i < l; i++){
            System.out.print("\n");
            for (int j = 0; j < c; j++)
                System.out.print(Valores[i][j] + " ");
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

        Matriz A = new Matriz(ax, ay);
        Matriz B = new Matriz(bx, by);
        Matriz C = new Matriz(ax, by);

        A.leMatriz();
        B.leMatriz();
        C = MultMatriz(A, B);
        C.imprimeMatriz();
    }
}