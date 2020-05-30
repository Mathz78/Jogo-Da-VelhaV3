package Projetos.JogoDaVelha;


import java.util.Arrays;
import java.util.Scanner;

public class JogoDaVelhaV3 {

    static void printTabuleiro(char tabuleiro[][]) {
        for (int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                System.out.print(tabuleiro[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int verifyWinner (char tabuleiro[][], int winner) {
        do {
            int i = 1;
        }


       return winner;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char tabuleiro[][] = new char[3][3];
        int posicaoLinha, posicaoColuna, jogador = 1;


        System.out.println("=================== Bem vindo ao Jogo da Velha ===================");
        //For para preencher o tabuleiro com " - ".
        for (char[] tab : tabuleiro) {
            Arrays.fill(tab , '-');
        }

        printTabuleiro(tabuleiro);

        do {
            if (jogador == 1) {
                System.out.println("Informe a Linha: ");
                posicaoLinha = scan.nextInt();
                System.out.println("Informe a Coluna: ");
                posicaoColuna = scan.nextInt();

                if (posicaoColuna > 2 || posicaoLinha > 2) {
                    System.out.println("Informe um valor de linha e coluna entre 0 e 2.");
                } else {
                    jogador = 2;
                    tabuleiro[posicaoLinha][posicaoColuna] = 'X';
                }
            } else {
                System.out.println("Informe a Linha: ");
                posicaoLinha = scan.nextInt();
                System.out.println("Informe a Coluna: ");
                posicaoColuna = scan.nextInt();

                if (posicaoColuna > 2 || posicaoLinha > 2) {
                    System.out.println();
                    System.out.println("Informe um valor de linha e coluna entre 0 e 2.");
                } else {
                    jogador = 1;
                    tabuleiro[posicaoLinha][posicaoColuna] = 'o';
                }
            }

            printTabuleiro(tabuleiro);
            verifyWinner(tabuleiro);
        } while (true);
    }
}
