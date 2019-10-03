package com.br.zup.Models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
//import lombok.Data;

//@Data
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

	@ManyToOne(fetch=FetchType.LAZY)
	  @JoinColumn(name="idEstablishment")
	  private Establishment establishment;
	
	@NotBlank(message ="Store code cannot be blank")
	private String establishmentCode;

	@NotBlank(message ="the mechanics can't be blank")
	@Column(name="mechanics")
	private String mechanics;

	@NotNull
    @Min(100)
	@Column(name="valorMinimo")
	private double minimumValue;

	@NotNull
	@Column(name="maximumValue")
	@Max(10000)
	private double maximumValue;

	@NotBlank(message ="start date cannot be blank")
	@Column(name="startDate")
	private String startDate;

	@NotBlank(message ="description cannot be blank")
	@Column(name="description")
	private String description;

	@NotBlank(message ="campaign end date must not be blank")
	@Column(name="endDate")
	private String endDate;

//	DescontoEnum descontoEnum = DescontoEnum.FLAT;
//	DescontoEnum descontoEnum2 = DescontoEnum.ACIMA_DO_VALOR;
//	DescontoEnum descontoEnum3 = DescontoEnum.BRINDE;
	
	public Campaign() {
	}

	public Integer getId() {
		return idCampaign;
	}

	public void setId(Integer idCampaign) {
		this.idCampaign = idCampaign;
	}

	public String getCampaignName() {
		return campaignName;
	}

	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}

	public String getEstablishmentCode() {
		return establishmentCode;
	}

	public void setEstablishmentCode(String establishmentCode) {
		this.establishmentCode = establishmentCode;
	}

	public String getMechanics() {
		return mechanics;
	}

	public void setMechanics(String mechanics) {
		this.mechanics = mechanics;
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
	
//	public double getDesconto() {
//		return desconto;
//	}
//	
//	public void setDesconto(double desconto) {
//		this.desconto = desconto;
//	}

//	public double desconto() {
//		if(desconto == 100) {
//			return desconto-10;
//		}
//		return desconto;
//	}	
}