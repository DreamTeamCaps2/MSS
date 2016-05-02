package model.bean;

public class ThongBao {
	private String noiDung,thoiGian,chuDe;

	private int loaiThongBao,maGopY,loaiGopY;
	private int tinhTrang;
	
	
	
	public int getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(int tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	public int getLoaiGopY() {
		return loaiGopY;
	}

	public void setLoaiGopY(int loaiGopY) {
		this.loaiGopY = loaiGopY;
	}

	public int getMaGopY() {
		return maGopY;
	}

	public void setMaGopY(int maGopY) {
		this.maGopY = maGopY;
	}

	public String getChuDe() {
		return chuDe;
	}

	public void setChuDe(String chuDe) {
		this.chuDe = chuDe;
	}

	public int getLoaiThongBao() {
		return loaiThongBao;
	}

	public void setLoaiThongBao(int loaiThongBao) {
		this.loaiThongBao = loaiThongBao;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public String getThoiGian() {
		return thoiGian;
	}

	public void setThoiGian(String thoiGian) {
		this.thoiGian = thoiGian;
	}
}
