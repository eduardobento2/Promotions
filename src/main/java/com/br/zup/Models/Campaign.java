package com.br.zup.Models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
//import lombok.Data;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;

import lombok.Data;

@Data
@Entity(name = "campaign")
public class Campaign implements Serializable{
	private final static long serialVersionUID = 1L;

	@Id
	@Column(name="idCampaign")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCampaign;

	@NotBlank(message ="Campaign may not be blank")
	@Column(name="CampaignName")
	private String campaignName;

	
	@JoinColumn(name="idEstablishment")
	@ManyToOne(cascade =CascadeType.ALL)
	private Establishment establishment;
	
	private  Mechanics mechanics;
	
	public  Mechanics getMechanics() {
		return mechanics;
	}

	public  void setMechanics(Mechanics mechanics) {
		this.mechanics = mechanics;
	}

	
	@NotBlank(message ="start date cannot be blank")
	@Column(name="startDate")
	private String startDate;

	//@NotBlank(message ="description cannot be blank")
	@Column(name="description")
	private String description;

	@NotBlank(message ="campaign end date must not be blank")
	@Column(name="endDate")
	private String endDate;


	@NotNull
	public enum Mechanics {
		FLAT,PERCENTUAL,BRINDE;
//		private String text;
//		 Mechanics(String text) {
//			 this.text = text;
//		}
//		 public String getText() {
//			 return text;
//		 }
//		 @Override
//		 public String toString() {
//			 return text;
//		 }
//		 @JsonCreator
//		 public  Mechanics fromText(String text) {
//			 for (Mechanics mechanics  : Mechanics.values()) {
//				if(mechanics.getText().equals(text)) {
//					return mechanics;
//				}
//				System.out.println(mechanics);
//			}
//			 throw new IllegalArgumentException();
//		 }
	}

	
	private double minimumValue;

	
	private double maximumValue;

	public Campaign() {
	}

	public Integer getIdCampaign() {
		return idCampaign;
	}

	public void setIdCampaign(Integer idCampaign) {
		this.idCampaign = idCampaign;
	}

	public String getCampaignName() {
		return campaignName;
	}

	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}

	public Establishment getEstablishment() {
		return establishment;
	}

	public void setEstablishment(Establishment establishment) {
		this.establishment = establishment;
	}

//	public String getEstablishmentCode() {
//		return establishmentCode;
//	}
//
//	public void setEstablishmentCode(String establishmentCode) {
//		this.establishmentCode = establishmentCode;
//	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}


	public double getMinimumValue() {
		return minimumValue;
	}

	public void setMinimumValue(double minimumValue) {
		this.minimumValue = minimumValue;
	}

	public double getMaximumValue() {
		return maximumValue;
	}

	public void setMaximumValue(double maximumValue) {
		this.maximumValue = maximumValue;
	}

	
	@Override
	public String toString() {
		return "Campaign [idCampaign=" + idCampaign + ", campaignName=" + campaignName + ", establishment="
				+ establishment + ", startDate=" + startDate + ", description=" + description + ", endDate=" + endDate
				+ ", minimumValue=" + minimumValue + ", maximumValue=" + maximumValue + "]";
	}

}