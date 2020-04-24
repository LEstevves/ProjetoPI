package model;

public class Estufa {
	public int id;
	public String nome;
	public String tempMin;
	public String tempMax;
	public String umidArMin;
	public String umidArMax;
	public String umidSoloMin;
	public String umidSoloMax;
	
	public Estufa() {
		super();
	}



	@Override
	public String toString() {
		return "Estufa [id=" + id + ", nome=" + nome + ", tempMin=" + tempMin + ", tempMax=" + tempMax + ", umidArMin="
				+ umidArMin + ", umidArMax=" + umidArMax + ", umidSoloMin=" + umidSoloMin + ", umidSoloMax="
				+ umidSoloMax + "]";
	}



	public Estufa(int id, String nome, String tempMin, String tempMax, String umidArMin, String umidArMax,
			String umidSoloMin, String umidSoloMax) {
		super();
		this.id = id;
		this.nome = nome;
		this.tempMin = tempMin;
		this.tempMax = tempMax;
		this.umidArMin = umidArMin;
		this.umidArMax = umidArMax;
		this.umidSoloMin = umidSoloMin;
		this.umidSoloMax = umidSoloMax;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getTempMin() {
		return tempMin;
	}



	public void setTempMin(String tempMin) {
		this.tempMin = tempMin;
	}



	public String getTempMax() {
		return tempMax;
	}



	public void setTempMax(String tempMax) {
		this.tempMax = tempMax;
	}



	public String getUmidArMin() {
		return umidArMin;
	}



	public void setUmidArMin(String umidArMin) {
		this.umidArMin = umidArMin;
	}



	public String getUmidArMax() {
		return umidArMax;
	}



	public void setUmidArMax(String umidArMax) {
		this.umidArMax = umidArMax;
	}



	public String getUmidSoloMin() {
		return umidSoloMin;
	}



	public void setUmidSoloMin(String umidSoloMin) {
		this.umidSoloMin = umidSoloMin;
	}



	public String getUmidSoloMax() {
		return umidSoloMax;
	}



	public void setUmidSoloMax(String umidSoloMax) {
		this.umidSoloMax = umidSoloMax;
	}


}