package model.bean;

public class DiaDiem {
	private String ten,diaChi,sdt, loai,mota, thoiGian;
	private int maDiaDiem;
	private String tenDangNhap;
	
	public String getMota() {
		return mota;
	}
	public void setMota(String mota) {
		this.mota = mota;
	}
	public String getThoiGian() {
		return thoiGian;
	}
	public void setThoiGian(String thoiGian) {
		this.thoiGian = thoiGian;
	}
	public int getMaDiaDiem() {
		return maDiaDiem;
	}
	public void setMaDiaDiem(int maDiaDiem) {
		this.maDiaDiem = maDiaDiem;
	}
	private float longi,lati;
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getLoai() {
		return loai;
	}
	public void setLoai(String loai) {
		this.loai = loai;
	}
	public float getLongi() {
		return longi;
	}
	public void setLongi(float longi) {
		this.longi = longi;
	}
	public float getLati() {
		return lati;
	}
	public void setLati(float lati) {
		this.lati = lati;
	}
	public String getTenDangNhap() {
		return tenDangNhap;
	}
	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}
}
