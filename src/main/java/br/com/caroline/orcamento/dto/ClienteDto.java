package br.com.caroline.orcamento.dto;

public class ClienteDto {
    private String nome;

    private String endereco;

    private String numero;


    public ClienteDto(Long id, String nome, String endereco, String numero, String bairro, String telefone, String celular, String municipio){
        this.nome = nome;
        this.endereco = endereco;
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

}

