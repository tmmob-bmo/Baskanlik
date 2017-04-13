
public class Milletvekili {
	private String ad;
	private boolean isBaskanaYakin;
	public Milletvekili(String ad, boolean baskanaYakin){
		this.ad = ad;
		this.isBaskanaYakin = baskanaYakin;
	}
	public boolean isMuhalif(){
		return !isBaskanaYakin;
	}
	public String getAd() {
		return ad;
	}
	public void setAd(String ad) {
		this.ad = ad;
	}
	
	public boolean isBaskanaYakin() {
		return isBaskanaYakin;
	}
	public void setBaskanaYakin(boolean baskanaYakin) {
		this.isBaskanaYakin = baskanaYakin;
	}
}


