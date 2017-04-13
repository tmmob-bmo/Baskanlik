import java.util.List;
import java.util.ArrayList;

public class Cumhurbaskani {
	public static final boolean IS_PARTI_BASKANI = true;
	public static final int IKTIDAR_ICIN_MILLETVEKILI_YETER_SAYI =301;
	public static final int AYM_ATANACAK_UYE_SAYI = 13; 
	List<Milletvekili> yeniVekilList;
	private Meclis meclis;
	private AYM aym;
	private boolean isTekAdam;
	public static boolean IS_OHAL = false;
	public Cumhurbaskani(OY oyunRengi){
		if (OY.HAYIR == oyunRengi)
			isTekAdam = false;
		else{
			isTekAdam = true;
			degistirRejim();
		}
	}
	private void degistirRejim(){
		baslatSecim();
		sistemiDuzenle();
	}
	private void baslatSecim(){
		yeniVekilList = vekilAdayListesiBelirle();
	}
	private List<Milletvekili> vekilAdayListesiBelirle(){
		yeniVekilList = new ArrayList<Milletvekili>();
		for(int i =0; i<= IKTIDAR_ICIN_MILLETVEKILI_YETER_SAYI; i++){
			yeniVekilList.add(new Milletvekili("Baskan Sever", true));
		}
		return yeniVekilList;
	}

	private void sistemiDuzenle(){
		meclisiOlustur();
		aymBelirle();
	}
	private void meclisiOlustur(){
		meclis = new Meclis(this,yeniVekilList);
		meclis.start();
	}
	private void aymBelirle(){
		List<Uye> aymUyeList = new ArrayList<Uye>(); 
		for(int i =0; i<= AYM_ATANACAK_UYE_SAYI; i++){
			aymUyeList.add(new Uye("Baskan Atadi", true));
		}
		aym = new AYM(aymUyeList);
	}
	public String khkIlanEt()
	{
		try {
			meclis.wait();
		} catch (InterruptedException e) {
			System.out.println("Meclis biraz beklesin!!");
		}

		return "KHK Açýkladým. Meclise yol göründü!";
	}
	public String OHALIlanEt(){
		IS_OHAL = true;
		meclis.durdurYasama();
		return "OHAL Ilan Ettim. Bundan sonra yasama hep benim!";
	}
	public boolean onaylaYasa(String yasa){
		if (!IS_OHAL){
			if (yasa.contains("Baskan Sevgisi"))
				return true;
			else{
				try {
					meclis.wait();
				} catch (InterruptedException e) {
					System.out.println("Geri gönder gitsin!!");
				}
			}
		}
		return false;
	}
	public void feshetMeclis(){
		meclis.feshOl();
	}
}

