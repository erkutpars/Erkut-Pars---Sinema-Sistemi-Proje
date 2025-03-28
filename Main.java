import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SinemaSistemi sistem = new SinemaSistemi();
        
        while (true) {
            System.out.println("\n=== Sinema Müşteri Kayıt Sistemi ===");
            System.out.println("1- Film İşlemleri");
            System.out.println("2- Müşteri İşlemleri");
            System.out.println("3- Bilet İşlemleri");
            System.out.println("4- Çıkış");
            System.out.print("Seçiminiz: ");
            
            int secim = scanner.nextInt();
            scanner.nextLine(); // Buffer temizleme
            
            switch (secim) {
                case 1:
                    filmIslemleri(scanner, sistem);
                    break;
                case 2:
                    musteriIslemleri(scanner, sistem);
                    break;
                case 3:
                    biletIslemleri(scanner, sistem);
                    break;
                case 4:
                    System.out.println("Program sonlandırılıyor...");
                    return;
                default:
                    System.out.println("Geçersiz seçim!");
            }
        }
    }
    
    private static void filmIslemleri(Scanner scanner, SinemaSistemi sistem) {
        System.out.println("\n=== Film İşlemleri ===");
        System.out.println("1- Film Ekle");
        System.out.println("2- Filmleri Listele");
        System.out.print("Seçiminiz: ");
        
        int secim = scanner.nextInt();
        scanner.nextLine();
        
        if (secim == 1) {
            System.out.print("Film Adı: ");
            String ad = scanner.nextLine();
            System.out.print("Film Süresi (dakika): ");
            int sure = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Film Türü: ");
            String tur = scanner.nextLine();
            
            if (sistem.filmEkle(ad, sure, tur)) {
                System.out.println("Film başarıyla eklendi.");
            } else {
                System.out.println("Film eklenemedi! Maksimum film sayısına ulaşıldı.");
            }
        } else if (secim == 2) {
            sistem.filmleriListele();
        }
    }
    
    private static void musteriIslemleri(Scanner scanner, SinemaSistemi sistem) {
        System.out.println("\n=== Müşteri İşlemleri ===");
        System.out.println("1- Müşteri Ekle");
        System.out.println("2- Müşterileri Listele");
        System.out.print("Seçiminiz: ");
        
        int secim = scanner.nextInt();
        scanner.nextLine();
        
        if (secim == 1) {
            System.out.print("Müşteri Adı: ");
            String ad = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();
            
            if (sistem.musteriEkle(ad, email)) {
                System.out.println("Müşteri başarıyla eklendi.");
            } else {
                System.out.println("Müşteri eklenemedi! Maksimum müşteri sayısına ulaşıldı.");
            }
        } else if (secim == 2) {
            sistem.musterileriListele();
        }
    }
    
    private static void biletIslemleri(Scanner scanner, SinemaSistemi sistem) {
        System.out.println("\n=== Bilet İşlemleri ===");
        System.out.println("1- Bilet Oluştur");
        System.out.println("2- Biletleri Listele");
        System.out.print("Seçiminiz: ");
        
        int secim = scanner.nextInt();
        scanner.nextLine();
        
        if (secim == 1) {
            sistem.musterileriListele();
            System.out.print("Müşteri numarası: ");
            int musteriNo = scanner.nextInt();
            
            sistem.filmleriListele();
            System.out.print("Film numarası: ");
            int filmNo = scanner.nextInt();
            
            if (sistem.biletOlustur(musteriNo, filmNo)) {
                System.out.println("Bilet başarıyla oluşturuldu.");
            } else {
                System.out.println("Bilet oluşturulamadı! Geçersiz müşteri veya film numarası.");
            }
        } else if (secim == 2) {
            sistem.biletleriListele();
        }
    }
}
