package br.com.alura.loja.modelo;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name= "produtos") //Anotação evidenciando um diferença entre o nome da classe e o nome da tabelas(produtos)
public class Produto {

    @Id // Anotação para representar um primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Geração do valor realizado no banco de dados!
    private Long id;

    private String nome;

    @Column(name = "descricao") // Parâmetro name, distinguindo o nome dos atributos (no caso de divergência)
    private String desc;

    private BigDecimal preco;



    //Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
}
