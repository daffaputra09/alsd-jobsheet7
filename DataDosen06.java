public class DataDosen06 {
    Dosen06[] dataDosen;
    int idx;

    public DataDosen06() {
        dataDosen = new Dosen06[10];
        idx = 0;
    }

    void tambah(Dosen06 dsn) {
        if (idx < dataDosen.length) {
            dataDosen[idx] = dsn;
            idx++;
        } else {
            System.out.println("Data sudah penuh!");
        }
    }

    void tampil() {
        if (idx == 0) {
            System.out.println("Belum ada data dosen!");
            return;
        }
        for (int i = 0; i < idx; i++) {
            dataDosen[i].tampil();
        }
    }

    void sortingASC() {
        for (int i = 0; i < idx - 1; i++) {
            for (int j = 0; j < idx - i - 1; j++) {
                if (dataDosen[j].usia > dataDosen[j + 1].usia) {
                    Dosen06 tmp = dataDosen[j];
                    dataDosen[j] = dataDosen[j + 1];
                    dataDosen[j + 1] = tmp;
                }
            }
        }
    }

    void sortingDSC() {
        for (int i = 0; i < idx - 1; i++) {
            int idxMax = i;
            for (int j = i + 1; j < idx; j++) {
                if (dataDosen[j].usia > dataDosen[idxMax].usia) {
                    idxMax = j;
                }
            }
            Dosen06 tmp = dataDosen[idxMax];
            dataDosen[idxMax] = dataDosen[i];
            dataDosen[i] = tmp;
        }
    }

    public void pencarianDataSequential06(String searchNama) {
        boolean found = false;
        int count = 0;
        System.out.println("\nHasil pencarian untuk nama: " + searchNama);
        
        for (int i = 0; i < dataDosen.length; i++) {
            if (dataDosen[i] != null && dataDosen[i].nama.toLowerCase().contains(searchNama.toLowerCase())) {
                System.out.println("\nData ditemukan pada indeks ke-" + i);
                System.out.println("=========================");
                dataDosen[i].tampil();
                System.out.println("=========================");
                found = true;
                count++;
            }
        }
        
        if (!found) {
            System.out.println("Data tidak ditemukan!");
        } else if (count > 1) {
            System.out.println("\nPeringatan: Ditemukan " + count + " data dengan nama yang mirip!");
        }
    }

    public void pencarianDataBinary06(int searchUsia) {
        sortingASC();
        
        boolean found = false;
        int count = 0;
        int left = 0;
        int right = 0;
        
        for (int i = 0; i < dataDosen.length; i++) {
            if (dataDosen[i] != null) {
                right++;
            }
        }
        right--; 
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (dataDosen[mid].usia == searchUsia) {
                found = true;
                
                System.out.println("\nHasil pencarian untuk usia: " + searchUsia);
                
                for (int i = 0; i < dataDosen.length; i++) {
                    if (dataDosen[i] != null && dataDosen[i].usia == searchUsia) {
                        System.out.println("\nData ditemukan pada indeks ke-" + i);
                        System.out.println("=========================");
                        dataDosen[i].tampil();
                        System.out.println("=========================");
                        count++;
                    }
                }
                break;
            }
            
            if (dataDosen[mid].usia < searchUsia) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        if (!found) {
            System.out.println("Data tidak ditemukan!");
        } else if (count > 1) {
            System.out.println("\nPeringatan: Ditemukan " + count + " data dengan usia yang sama!");
        }
    }
}