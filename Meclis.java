import java.util.List;
import java.util.ArrayList;
import java.lang.IllegalStateException;

public class Meclis extends Thread{
	public static int YUCE_DIVAN_ICIN_YETER_SAYI = 400;
	public static int KANUN_KABUL_ICIN_YETER_SAYI = 301;
	private List<Milletvekili> vekilList = new ArrayList<Milletvekili>();
	private AYM aym;
	private boolean yasamaIsOn;
	private Cumhurbaskani baskan;
	public Meclis (Cumhurbaskani baskan, List<Milletvekili> newVekilList){
		this.baskan = baskan;
		vekilList.addAll(newVekilList);
		
	}
	
	@Override
	public void run() {
		while (yasamaIsOn){
			kanunHazirla();
		}
	}
	
	public void kanunHazirla()
	{
		String kanunTeklifi = "Hazýrladýk ama baskan sevmeyebilir";
		boolean isYasaOnaylandi = baskan.onaylaYasa(kanunTeklifi);
		if (!isYasaOnaylandi){
			try {
				checkYeterSayi();
			} catch (IllegalStateException e) {
				// TODO: nothing to do
			}
		}
	}
	
	private boolean checkYeterSayi() throws IllegalStateException{
		List<Milletvekili> muhalifVekilList = getBaskanTarafindanBelirlenmeyenVekilList();
		if (muhalifVekilList.size() < KANUN_KABUL_ICIN_YETER_SAYI){
			throw new IllegalStateException ("Ikna Turlarina Basla");
		}
		return true;
	}
	
	public void yuceDivanaGonder(){
		if (isYargilanabilir(baskan)){
			aym.yuceDivandaYargila(baskan);
		}
	}
	
	private boolean isYargilanabilir(Cumhurbaskani baskan)throws IllegalStateException{
		List<Milletvekili> muhalifVekilList = getBaskanTarafindanBelirlenmeyenVekilList();
		if (muhalifVekilList.size()>= YUCE_DIVAN_ICIN_YETER_SAYI)
			return true;
		else
			throw new IllegalStateException("Cok beklersin");
		
	}
	private List<Milletvekili> getBaskanTarafindanBelirlenmeyenVekilList(){
		List<Milletvekili> muhalifVekilList = new ArrayList<Milletvekili>();
		for(Milletvekili vekil:vekilList){
			if (vekil.isMuhalif()){
				muhalifVekilList.add(vekil);
			}
		}
		return muhalifVekilList;
	}
	public void durdurYasama(){
		yasamaIsOn = false;
	}
	
	public void feshOl(){
		yasamaIsOn = false;
		vekilList.clear();
	}
}


