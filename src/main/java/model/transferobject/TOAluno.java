package model.transferobject;

import java.util.Objects;

public class TOAluno {

    private String id;
    private String nome;
    private String dataNascimento;
    private Boolean ativo;
    private String celular;
    private String email;
    private String cidade;
    private String CEP;
    private String rua;
    private String numero;
    private String bairro;
    private String genero;
    private String estado;
    private String dataVencimento;
    private Double valorMensalidade;
    private int vezesSemana;
    
    public TOAluno() {
    }

    public TOAluno(String id, String nomeAluno, String dataNascimento, Boolean ativo, String celular, String email,
			String cidade, String cEP, String rua, String numero, String bairro, String genero, String estado,
			String dataVencimento, Double valorMensalidade, int vezesSemana) {
		super();
		this.id = id;
		this.nome = nomeAluno;
		this.dataNascimento = dataNascimento;
		this.ativo = ativo;
		this.celular = celular;
		this.email = email;
		this.cidade = cidade;
		CEP = cEP;
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
		this.genero = genero;
		this.estado = estado;
		this.dataVencimento = dataVencimento;
		this.valorMensalidade = valorMensalidade;
		this.vezesSemana = vezesSemana;
	}


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * Obtém o nome do aluno
     *
     * @return nome do aluno
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do aluno
     *
     * @param nomeAluno
     */
    public void setNome(String nomeAluno) {
        this.nome = nomeAluno;
    }

    /**
     * Obtém a data de nascimento do aluno
     *
     * @return data de nascimento do aluno
     */
    public String getDataNascimento() {
        return dataNascimento;
    }

    /**
     * Define a data de nascimento do aluno
     *
     * @param dataNascimento
     */
    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    /**
     * Obtém o status do aluno (ativo ou inativo)
     *
     * @return status do aluno
     */
    public Boolean getAtivo() {
        return ativo;
    }

    /**
     * Define o status do aluno (ativo ou inativo)
     *
     * @param ativo
     */
    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    /**
     * Obtém o número de celular do aluno
     *
     * @return número de celular do aluno
     */
    public String getCelular() {
        return celular;
    }

    /**
     * Define o número de celular do aluno
     *
     * @param celular
     */
    public void setCelular(String celular) {
        this.celular = celular;
    }

    /**
     * Obtém o endereço de e-mail do aluno
     *
     * @return endereço de e-mail do aluno
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define o endereço de e-mail do aluno
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCEP() {
		return CEP;
	}

	public void setCEP(String cEP) {
		CEP = cEP;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return  nome + ", " + dataNascimento;
	}
	
	public String getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(String dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Double getValorMensalidade() {
		return valorMensalidade;
	}

	public void setValorMensalidade(Double valorMensalidade) {
		this.valorMensalidade = valorMensalidade;
	}

	public int getVezesSemana() {
		return vezesSemana;
	}

	public void setVezesSemana(int vezesSemana) {
		this.vezesSemana = vezesSemana;
	}

	@Override
	public int hashCode() {
		return Objects.hash(CEP, ativo, bairro, celular, cidade, dataNascimento, email, estado, genero, id, nome,
				numero, rua);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TOAluno other = (TOAluno) obj;
		return  Objects.equals(celular, other.celular)
				&& Objects.equals(dataNascimento, other.dataNascimento)
				&& Objects.equals(email, other.email)
				&& Objects.equals(nome, other.nome);
	}

}