package model.bean;

public class LuotXem {
	private  int ma;
	private  long thoiGianVao;
	private int luotXem;
	private  boolean lanDau;

	public int getLuotXem() {
		return luotXem;
	}

	public void setLuotXem(int luotXem) {
		this.luotXem = luotXem;
	}

	public int getMa() {
		return ma;
	}

	public void setMa(int ma) {
		this.ma = ma;
	}

	public long getThoiGianVao() {
		return thoiGianVao;
	}

	public void setThoiGianVao(long thoiGianVao) {
		this.thoiGianVao = thoiGianVao;
	}

	public boolean isLanDau() {
		return lanDau;
	}

	public void setLanDau(boolean lanDau) {
		this.lanDau = lanDau;
	}
	
}
