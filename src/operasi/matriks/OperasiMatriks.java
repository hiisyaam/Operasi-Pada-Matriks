package operasi.matriks;

/**
 *
 * @author hiisyaam
 */
import java.util.InputMismatchException;
import java.util.Scanner;
public class OperasiMatriks {

    /**
     * @param args the command line arguments
     */
    static Scanner in = new Scanner(System.in);
    static int pilih = 0;
    static int[][] matrix1;
    static int[][] matrix2;
    static byte barisMatrix1;
    static byte kolomMatrix1;
    static byte barisMatrix2;
    static byte kolomMatrix2;
    static int[][] hasilOperasi;
    static boolean cek = true;

    public static void main(String[] args) {
        do {
            try {
                menu();
                switch (pilih) {
                    case 1:
                        masukOperasi();
                        cekPenjumlahan();
                        break;
                    case 2:
                        masukOperasi();
                        cekPerkalian();
                        break;
                    case 0:
                        System.out.println("Terima Kasih.");
                        System.exit(0);
                    default:
                        System.out.println("Tidak Valid");
                        cek = false;
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Tidak valid");
                // System.out.println("");
                in.nextLine();
                cek = false;
            }
        } while (cek == false);
    }

    public static int menu() {
        System.out.println("Program Operasi pada Matriks.");
        System.out.println("Pilih salah satu.");
        System.out.println("1.Penjumlahan\n2.Perkalian\n0.Keluar");
        System.out.print("Masukan pilihan anda: ");
        pilih = in.nextInt();
        return pilih;
    }

    static void masukOperasi() {
        if (pilih == 1)
            System.out.println("Anda akan menjumlahkan matriks");
        if (pilih == 2)
            System.out.println("Anda akan melakukan operasi perkalian matrix");
        masukanIsiMatrix1();
        masukanIsiMatrix2();
    }

    static void masukanIsiMatrix1() {
        System.out.println("");
        System.out.println("MATRIKS PERTAMA");
        System.out.print("Masukan jumlah baris: ");
        barisMatrix1 = in.nextByte();
        System.out.print("Masukan jumlah kolom: ");
        kolomMatrix1 = in.nextByte();

        matrix1 = new int[barisMatrix1][kolomMatrix1];

        for (int a = 0; a < barisMatrix1; a++) {
            for (int b = 0; b < kolomMatrix1; b++) {
                System.out.print("Masukan nilai baris ke-" + (a + 1) + " kolom ke-" + (b + 1) + " : ");
                matrix1[a][b] = in.nextInt();
            }
        }

    }

    static void masukanIsiMatrix2() {
        System.out.println("MATRIKS KEDUA");
        System.out.print("Masukan jumlah baris: ");
        barisMatrix2 = in.nextByte();
        System.out.print("Masukan jumlah kolom: ");
        kolomMatrix2 = in.nextByte();

        matrix2 = new int[barisMatrix2][kolomMatrix2];

        for (int b = 0; b < barisMatrix2; b++) {
            for (int c = 0; c < kolomMatrix2; c++) {
                System.out.print("Masukan nilai baris ke-" + (b + 1) + " kolom ke-" + (c + 1) + " : ");
                matrix2[b][c] = in.nextInt();
            }
        }

    }

    static void cekPenjumlahan() {
        if (barisMatrix1 == barisMatrix2 && kolomMatrix1 == kolomMatrix2) {
            System.out.println("Matriks bisa di jumlahkan");
            operasiPenjumlahan();
        } else {
            System.out.println("");
            System.out.println("Matriks tak bisa di jumlahkan");
            cek = false;
        }
    }

    static void cekPerkalian() {
        if (kolomMatrix1 == barisMatrix2) {
            System.out.println("Matriks bisa melakukan operasi perkalian");
            perkalianMatriks();
        } else {
            System.out.println("");
            System.out.println("Matriks tidak memenuhi syarat untuk operasi perkalian");
            cek = false;
        }
    }

    static void operasiPenjumlahan() {
        for (int i = 0; i < barisMatrix1; i++) {
            for (int j = 0; j < kolomMatrix1; j++) {
                hasilOperasi = new int[barisMatrix1][kolomMatrix1];
                System.out.printf("%d%s", hasilOperasi[i][j] = (matrix1[i][j]) + (matrix2[i][j]), "\t");
            }
            System.out.println("");
        }
        cek = false;
    }

    static void perkalianMatriks() {
        int[][] hasilOperasi = new int[barisMatrix1][kolomMatrix2];

        for (int i = 0; i < barisMatrix1; i++) {
            for (int j = 0; j < kolomMatrix2; j++) {
                for (int k = 0; k < kolomMatrix1; k++) {
                    hasilOperasi[i][j] += (matrix1[i][k]) * (matrix2[k][j]);
                }
            }
        }

        for (int i = 0; i < barisMatrix1; i++) {
            for (int j = 0; j < kolomMatrix2; j++) {
                System.out.printf("%d%s", hasilOperasi[i][j], "\t");
            }
            System.out.println("");
        }
        cek = false;
    }
    
}
