package br.com.alura.loja.funcionalidades;

import br.com.alura.loja.DAO.ProdutoDao;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class CadastroDeProduto  {

    public static void main(String[] args) {



        Produto celular = new Produto("Galaxy S7 Edge", "Compacto, eficiente, portável, polido",
                new BigDecimal("2700"), Categoria.CELULAR);

        //Recurso do JPA que estabelece uma interface de comunicação com o banco de dados abastraída em JPAUtil
        EntityManager entityManager = JPAUtil.getEntityManager();

        ProdutoDao produtoDao = new ProdutoDao(entityManager);

        entityManager.getTransaction().begin();
        produtoDao.cadastrar(celular);
        entityManager.getTransaction().commit();
        entityManager.close();

        //OBS: através dos comandos de transação abaixo, é habilidado a conexão, e realizado no commit.
        //Necessário para realizar operações de escrita no banco... (insert, update e delete)

    }

}
