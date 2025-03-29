import java.util.Scanner;

public class DosenMain06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DataDosen06 data = new DataDosen06();
        int menu;

        do {
            System.out.println("\n=========================");
            System.out.println("SISTEM PENDATAAN DOSEN");
            System.out.println("=========================");
            System.out.println("1. Tambah Data");
            System.out.println("2. Tampil Data");
            System.out.println("3. Sorting ASC (Bubble Sort)");
            System.out.println("4. Sorting DSC (Selection Sort)");
            System.out.println("5. Cari Data by Nama");
            System.out.println("6. Cari Data by Usia");
            System.out.println("0. Keluar");
            System.out.println("=========================");
            System.out.print("Pilih menu: ");
            menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {
                case 1:
                    System.out.println("\nTambah Data Dosen");
                    System.out.print("Masukkan Kode: ");
                    String kode = sc.nextLine();
                    System.out.print("Masukkan Nama: ");
                    String nama = sc.nextLine();
                    System.out.print("Jenis Kelamin (1: Laki-laki, 0: Perempuan): ");
                    boolean jk = sc.nextInt() == 1;
                    System.out.print("Masukkan Usia: ");
                    int usia = sc.nextInt();
                    
                    Dosen06 dsn = new Dosen06(kode, nama, jk, usia);
                    data.tambah(dsn);
                    break;
                
                case 2:
                    System.out.println("\nData Dosen:");
                    data.tampil();
                    break;
                
                case 3:
                    System.out.println("\nData setelah diurutkan berdasarkan usia (ASC):");
                    data.sortingASC();
                    data.tampil();
                    break;
                
                case 4:
                    System.out.println("\nData setelah diurutkan berdasarkan usia (DSC):");
                    data.sortingDSC();
                    data.tampil();
                    break;
                
                case 5:
                    System.out.println("\nPencarian Data Dosen berdasarkan Nama");
                    System.out.print("Masukkan Nama yang dicari: ");
                    String searchNama = sc.nextLine();
                    data.pencarianDataSequential06(searchNama);
                    break;
                
                case 6:
                    System.out.println("\nPencarian Data Dosen berdasarkan Usia");
                    System.out.print("Masukkan Usia yang dicari: ");
                    int searchUsia = sc.nextInt();
                    data.pencarianDataBinary06(searchUsia);
                    break;
                
                case 0:
                    System.out.println("Terima kasih!");
                    break;
                
                default:
                    System.out.println("Menu tidak valid!");
            }
        } while (menu != 0);

        sc.close();
    }
}