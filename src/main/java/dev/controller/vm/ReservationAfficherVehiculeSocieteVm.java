package dev.controller.vm;

public class ReservationAfficherVehiculeSocieteVm {
	
	private Long id;
	private String url;
	private String marque;
	private String modele;
	private String immatriculation;
	private boolean dispo;
	
	public ReservationAfficherVehiculeSocieteVm(String image, Long id, String marque, String modele, String immatriculation,
			boolean dispo) {
		super();
		this.id = id;
		this.marque = marque;
		this.modele = modele;
		this.immatriculation = immatriculation;
		this.dispo = dispo;
	}
	public ReservationAfficherVehiculeSocieteVm() {
		// TODO Auto-generated constructor stub
	}
	
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String image) {
		this.url = image;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public String getModele() {
		return modele;
	}
	public void setModele(String modele) {
		this.modele = modele;
	}
	public String getImmatriculation() {
		return immatriculation;
	}
	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}
	public boolean isDispo() {
		return dispo;
	}
	public void setDispo(boolean dispo) {
		this.dispo = dispo;
	}
	
	
}