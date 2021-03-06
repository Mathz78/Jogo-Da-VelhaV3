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

    static int verifyWinner (char tabuleiro[][]) {
        int vencedor = 0; // 1 == 'X' venceu.     2 == 'O' venceu.

        for (int i = 0; i < 3; i++) {
            //Verify horizontally 0 / 1 / 2   -   3 / 4 / 5   -   6 / 7 / 8
            if (tabuleiro[i][0] == tabuleiro[i][1] && tabuleiro[i][1] == tabuleiro[i][2]) {
                if (tabuleiro[i][0] == 'X') {
                    vencedor = 1;
                } else if (tabuleiro[i][0] == 'o'){
                    vencedor = 2;
                }
            }

            //Verify vertically
            if (tabuleiro[0][i] == tabuleiro[1][i] && tabuleiro[1][i] == tabuleiro[2][i]){
                if (tabuleiro[0][i] == 'X') {
                    vencedor = 1;
                } else if (tabuleiro[0][i] == 'o'){
                    vencedor = 2;
                }
            }

            //Verify diagonally
            if (tabuleiro[0][0] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][2] ||
                    tabuleiro[0][2] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][0]) {

                if (tabuleiro[1][1] == 'X') {
                    vencedor = 1;
                } else if (tabuleiro[1][1] == 'o'){
                    vencedor = 2;
                }
            }
        }

        if (vencedor == 1) {
            System.out.println("Parabéns, jogador X venceu!!");
        } else if (vencedor == 2) {
            System.out.println("Parabéns, jogador O venceu!!");
        } else {
            System.out.println("Nenhum jogador venceu!! Deu empate");
        }

        return (vencedor);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char tabuleiro[][] = new char[3][3];
        int posicaoLinha, posicaoColuna, jogador = 1, jogadas = 1, vencedor = 3;


        System.out.println("=================== Bem vindo ao Jogo da Velha ===================");
        //For para preencher o tabuleiro com " - ".
        for (char[] tab : tabuleiro) {
            Arrays.fill(tab , '-');
        }

        printTabuleiro(tabuleiro);

        do {
            if (jogador == 1) {
                System.out.println("Vez do jogador 1!!");
                System.out.println("Informe a Linha: ");
                posicaoLinha = scan.nextInt();
                System.out.println("Informe a Coluna: ");
                posicaoColuna = scan.nextInt();
                System.out.println();

                if (posicaoColuna > 2 || posicaoLinha > 2 || tabuleiro[posicaoLinha][posicaoColuna] != '-') {
                    System.out.println("Informe um valor diferente, entre 0 e 2!!");
                } else {
                    jogadas++;
                    jogador = 2;
                    tabuleiro[posicaoLinha][posicaoColuna] = 'X';
                }
            } else {
                System.out.println("Vez do jogador 2!!");
                System.out.println("Informe a Linha: ");
                posicaoLinha = scan.nextInt();
                System.out.println("Informe a Coluna: ");
                posicaoColuna = scan.nextInt();
                System.out.println();

                if (posicaoColuna > 2 || posicaoLinha > 2 || tabuleiro[posicaoLinha][posicaoColuna] != '-') {
                    System.out.println();
                    System.out.println("Informe um valor diferente, entre 0 e 2!!");
                } else {
                    jogadas++;
                    jogador = 1;
                    tabuleiro[posicaoLinha][posicaoColuna] = 'o';
                }
            }

            printTabuleiro(tabuleiro);

            if (jogadas > 5) {
                vencedor = verifyWinner(tabuleiro);
            }
        } while (jogadas < 9 && vencedor == 3);
    }
}