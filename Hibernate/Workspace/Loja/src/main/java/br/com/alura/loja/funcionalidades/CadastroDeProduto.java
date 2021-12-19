package br.com.alura.loja.funcionalidades;

import br.com.alura.loja.modelo.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class CadastroDeProduto  {

    public static void main(String[] args) {

        Produto celular = new Produto();

        celular.setNome("Galaxy S7 Edge");
        celular.setDesc("Compacto, eficiente, portável, polido");
        celular.setPreco(new BigDecimal("2700"));

        //Recurso do JPA que estabelece uma interface de comunicação com o banco de dados
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("loja");
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(celular);
        entityManager.getTransaction().commit();
        entityManager.close();

        //OBS: através dos comandos de transação abaixo, é habilidado a conexão, e realizado no commit.
        //Necessário para realizar operações de escrita no banco... (insert, update e delete)

    }

}
