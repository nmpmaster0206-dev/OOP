package Bai9;

public class CongNhan {
	private int maCN=0;
	private String mHo="";
	private String mTen="";
	private int mSoSP=0;
	public int getMaCN() {
		return maCN;
	}
	public void setMaCN(int maCN) {
		this.maCN = maCN;
	}
	public String getmHo() {
		return mHo;
	}
	public void setmHo(String mHo) {
		this.mHo = mHo;
	}
	public String getmTen() {
		return mTen;
	}
	public void setmTen(String mTen) {
		this.mTen = mTen;
	}
	public int getmSoSP() {
		if (mSoSP<0)
		{System.out.println("So SP pha lo hon khong");}
		else
			return mSoSP;
		return mSoSP;
	}
	public void setmSoSP(int mSoSP) {
		this.mSoSP = mSoSP;
	}
	public CongNhan(int maCN, String mHo, String mTen, int mSoSP) {
		super();
		this.maCN = maCN;
		this.mHo = mHo;
		this.mTen = mTen;
		this.mSoSP = mSoSP;
	}

	public double TinhLuong(int mSoSP)
	{
		double luong=0;
		if(mSoSP >=1 && mSoSP<=199)
			luong = mSoSP*0.5;
		else if(mSoSP >=200 && mSoSP<=399)
			luong = ((mSoSP-199)*0.55)+199*0.5;
		else if(mSoSP >=400 && mSoSP<=599)
			luong = ((mSoSP-399)*0.6)+((200)*0.55)+(199*0.5);
		else if(mSoSP >= 600)
			luong = ((mSoSP-599)*0.65)+((200)*0.6)+((200)*0.55)+(199*0.5);
		return luong;
	}
	@Override
	public String toString() {
		return "Ma cong nhan: " + this.maCN 
				+"\n"+"Ho Ten: " + this.mHo + this.mTen 
				+"\n"+"Luong:" + TinhLuong(this.mSoSP) ;

	}
}
