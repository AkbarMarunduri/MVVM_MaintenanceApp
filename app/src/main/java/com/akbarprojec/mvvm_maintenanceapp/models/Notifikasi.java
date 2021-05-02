package com.akbarprojec.mvvm_maintenanceapp.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.squareup.moshi.Json;

public class Notifikasi implements Parcelable {

	@Json(name = "crtdate")
	private String crtdate;

	@Json(name = "sts_notif")
	private String stsNotif;

	@Json(name = "no_mesin")
	private String noMesin;

	@Json(name = "created")
	private String created;

	@Json(name = "jam")
	private String jam;

	@Json(name = "plant")
	private String plant;

	@Json(name = "no_notifikasi")
	private String noNotifikasi;

	@Json(name = "tgl")
	private String tgl;

	@Json(name = "catatan")
	private String catatan;

	@Json(name = "pelapor")
	private String pelapor;

	@Json(name = "desc_notifikasi")
	private String descNotifikasi;

	public boolean isSelected = false;


	protected Notifikasi(Parcel in) {
		crtdate = in.readString();
		stsNotif = in.readString();
		noMesin = in.readString();
		created = in.readString();
		jam = in.readString();
		plant = in.readString();
		noNotifikasi = in.readString();
		tgl = in.readString();
		catatan = in.readString();
		pelapor = in.readString();
		descNotifikasi = in.readString();
		isSelected = in.readByte() != 0;
	}

	public static final Creator<Notifikasi> CREATOR = new Creator<Notifikasi>() {
		@Override
		public Notifikasi createFromParcel(Parcel in) {
			return new Notifikasi(in);
		}

		@Override
		public Notifikasi[] newArray(int size) {
			return new Notifikasi[size];
		}
	};

	public void setCrtdate(String crtdate){
		this.crtdate = crtdate;
	}

	public String getCrtdate(){
		return crtdate;
	}

	public void setStsNotif(String stsNotif){
		this.stsNotif = stsNotif;
	}

	public String getStsNotif(){
		return stsNotif;
	}

	public void setNoMesin(String noMesin){
		this.noMesin = noMesin;
	}

	public String getNoMesin(){
		return noMesin;
	}

	public void setCreated(String created){
		this.created = created;
	}

	public String getCreated(){
		return created;
	}

	public void setJam(String jam){
		this.jam = jam;
	}

	public String getJam(){
		return jam;
	}

	public void setPlant(String plant){
		this.plant = plant;
	}

	public String getPlant(){
		return plant;
	}

	public void setNoNotifikasi(String noNotifikasi){
		this.noNotifikasi = noNotifikasi;
	}

	public String getNoNotifikasi(){
		return noNotifikasi;
	}

	public void setTgl(String tgl){
		this.tgl = tgl;
	}

	public String getTgl(){
		return tgl;
	}

	public void setCatatan(String catatan){
		this.catatan = catatan;
	}

	public String getCatatan(){
		return catatan;
	}

	public void setPelapor(String pelapor){
		this.pelapor = pelapor;
	}

	public String getPelapor(){
		return pelapor;
	}

	public void setDescNotifikasi(String descNotifikasi){
		this.descNotifikasi = descNotifikasi;
	}

	public String getDescNotifikasi(){
		return descNotifikasi;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeString(crtdate);
		parcel.writeString(stsNotif);
		parcel.writeString(noMesin);
		parcel.writeString(created);
		parcel.writeString(jam);
		parcel.writeString(plant);
		parcel.writeString(noNotifikasi);
		parcel.writeString(tgl);
		parcel.writeString(catatan);
		parcel.writeString(pelapor);
		parcel.writeString(descNotifikasi);
		parcel.writeByte((byte) (isSelected ? 1 : 0));
	}
}