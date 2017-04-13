import java.util.List;
import java.util.ArrayList;
import java.lang.IllegalArgumentException;

public class AYM {
	public static final int TOPLAM_UYE_SAYISI = 15;
	public static final int BASKAN_TARAFINDAN_ATANAN_UYE_SAYISI = 12;
	private List<Uye> uyeList = new ArrayList<Uye>();
	
	public AYM(List<Uye> yeniUyeList){
		uyeList.addAll(uyeList);
	}
	public boolean yuceDivandaYargila(Cumhurbaskani baskan) throws IllegalArgumentException{
		boolean cezaVer = false;
		if (BASKAN_TARAFINDAN_ATANAN_UYE_SAYISI < (TOPLAM_UYE_SAYISI - BASKAN_TARAFINDAN_ATANAN_UYE_SAYISI)){
			cezaVer = true;
		}
		
		else
			throw new IllegalArgumentException("Bizi O atadý , biz O'nu nasýl atalým!!!");
		return cezaVer;
	}
}
		
	



