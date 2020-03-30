package com.wyk.jpaexample.model;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;

/**
 * 
 * No bd não tem a tabela person, mas sim tenant e customer
 * Quando for feita "from person" trara os resultados de tenant e customer e mais a coluna pertence_a_classe que indica
 * o nome no mapeamento @DiscriminatorValue
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "pertence_a_classe")
public abstract class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //SEQUENCE tem suporte postgree e oracle, IDENTITY tem suporte mysql e sqlserver
	private Long id;
	
	@Column(name = "name", length = 150, unique = true) //Necessario 'name' somente se o nome no banco for diferente
	@Basic(optional = false) //Torna campo obrigatorio
	private String name;

//	@Column(
//			name = "LAST_NAME",
//			length = 100,
//			unique = true,
//			nullable = false,
//			columnDefinition = "VARCHAR(45)",
//			insertable = true,
//			updatable = true,
//			precision = 2,
//			scale = 2,
//			table = "other_table")
//	private Double balance;
	
	@ElementCollection(targetClass = Profile.class)
	@Enumerated(EnumType.STRING)
	private List<Profile> profile;
	
	@Lob //Define que o campo pode ser um grande objeto
	@Basic(fetch = FetchType.LAZY) //Só carrega se chamado o get
	private byte[] photo;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Profile> getProfile() {
		return profile;
	}

	public void setProfile(List<Profile> profile) {
		this.profile = profile;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	
}
