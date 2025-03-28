public class SinemaSistemi {
    private static final int MAX_FILM = 10;
    private static final int MAX_MUSTERI = 20;
    
    private String[] filmAdlari;
    private int[] filmSureleri;
    private String[] filmTurleri;
    private int filmSayisi;
    
    private String[] musteriAdlari;
    private String[] musteriEmailleri;
    private int musteriSayisi;
    
    private int[] biletler; // müşteri indeksi ile eşleşen film indekslerini tutar
    
    public SinemaSistemi() {
        filmAdlari = new String[MAX_FILM];
        filmSureleri = new int[MAX_FILM];
        filmTurleri = new String[MAX_FILM];
        filmSayisi = 0;
        
        musteriAdlari = new String[MAX_MUSTERI];
        musteriEmailleri = new String[MAX_MUSTERI];
        musteriSayisi = 0;
        
        biletler = new int[MAX_MUSTERI];
        for (int i = 0; i < MAX_MUSTERI; i++) {
            biletler[i] = -1; // -1 bilet almamış müşterileri gösterir
        }
    }
    
    public boolean filmEkle(String ad, int sure, String tur) {
        if (filmSayisi >= MAX_FILM) {
            return false;
        }
        
        filmAdlari[filmSayisi] = ad;
        filmSureleri[filmSayisi] = sure;
        filmTurleri[filmSayisi] = tur;
        filmSayisi++;
        return true;
    }
    
    public boolean musteriEkle(String ad, String email) {
        if (musteriSayisi >= MAX_MUSTERI) {
            return false;
        }
        
        musteriAdlari[musteriSayisi] = ad;
        musteriEmailleri[musteriSayisi] = email;
        musteriSayisi++;
        return true;
    }
    
    public boolean biletOlustur(int musteriIndex, int filmIndex) {
        if (musteriIndex >= musteriSayisi || filmIndex >= filmSayisi) {
            return false;
        }
        
        biletler[musteriIndex] = filmIndex;
        return true;
    }
    
    public void filmleriListele() {
        System.out.println("\nFilmler:");
        for (int i = 0; i < filmSayisi; i++) {
            System.out.printf("%d- %s (%d dk) - %s%n", 
                i, filmAdlari[i], filmSureleri[i], filmTurleri[i]);
        }
    }
    
    public void musterileriListele() {
        System.out.println("\nMüşteriler:");
        for (int i = 0; i < musteriSayisi; i++) {
            System.out.printf("%d- %s (%s)%n", 
                i, musteriAdlari[i], musteriEmailleri[i]);
        }
    }
    
    public void biletleriListele() {
        System.out.println("\nBiletler:");
        for (int i = 0; i < musteriSayisi; i++) {
            if (biletler[i] != -1) {
                System.out.printf("Müşteri: %s - Film: %s%n", 
                    musteriAdlari[i], filmAdlari[biletler[i]]);
            }
        }
    }
}
