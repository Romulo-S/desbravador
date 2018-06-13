package br.com.biblioteca.pojo;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

@Entity
public class Projeto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	private int id;
	
	@Column(name = "name", nullable = false, length = 200)
	private String name;
	
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_inicio ", nullable = true, unique = false)
	private Date dataInicio;
	
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_previsao_fim ", nullable = true, unique = false)
	private Date dataPrevisaoFim;
	
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_fim  ", nullable = true, unique = false)
	private Date dataFim;
	
	@Column(name = "descricao", nullable = false, length = 5000)
	private String descricao;
	
	@Column(name = "status", nullable = false, length = 45)
	private String status;
	
	@Type(type = "org.hibernate.type.float")
	@Column(name = "orcamento", nullable = false)
	private float orcamento;
	
	@Column(name = "risco", nullable = false, length = 45)
	private String risco;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id", nullable = false)
	private Pessoa gerente;
	
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "membros", joinColumns = {@JoinColumn(name = "id", nullable = false, updatable = false)}, inverseJoinColumns = {
            @JoinColumn(name = "id", nullable = false, updatable = false)})
	private List<Pessoa> pessoas;
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataFim == null) ? 0 : dataFim.hashCode());
		result = prime * result + ((dataInicio == null) ? 0 : dataInicio.hashCode());
		result = prime * result + ((dataPrevisaoFim == null) ? 0 : dataPrevisaoFim.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + Float.floatToIntBits(orcamento);
		result = prime * result + ((risco == null) ? 0 : risco.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Projeto other = (Projeto) obj;
		if (dataFim == null) {
			if (other.dataFim != null)
				return false;
		} else if (!dataFim.equals(other.dataFim))
			return false;
		if (dataInicio == null) {
			if (other.dataInicio != null)
				return false;
		} else if (!dataInicio.equals(other.dataInicio))
			return false;
		if (dataPrevisaoFim == null) {
			if (other.dataPrevisaoFim != null)
				return false;
		} else if (!dataPrevisaoFim.equals(other.dataPrevisaoFim))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Float.floatToIntBits(orcamento) != Float.floatToIntBits(other.orcamento))
			return false;
		if (risco == null) {
			if (other.risco != null)
				return false;
		} else if (!risco.equals(other.risco))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Projeto [id=" + id + ", name=" + name + ", dataInicio=" + dataInicio + ", dataPrevisaoFim="
				+ dataPrevisaoFim + ", dataFim=" + dataFim + ", descricao=" + descricao + ", status=" + status
				+ ", orcamento=" + orcamento + ", risco=" + risco + "]";
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Date getDataPrevisaoFim() {
		return dataPrevisaoFim;
	}
	public void setDataPrevisaoFim(Date dataPrevisaoFim) {
		this.dataPrevisaoFim = dataPrevisaoFim;
	}
	public Date getDataFim() {
		return dataFim;
	}
	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public float getOrcamento() {
		return orcamento;
	}
	public void setOrcamento(float orcamento) {
		this.orcamento = orcamento;
	}
	public String getRisco() {
		return risco;
	}
	public void setRisco(String risco) {
		this.risco = risco;
	}

	public Pessoa getGerente() {
		return gerente;
	}

	public void setGerente(Pessoa gerente) {
		this.gerente = gerente;
	}

	
}
