package br.com.alura.loja.funcionalidades;

import br.com.alura.loja.DAO.CategoriaDAO;
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

        Categoria celulares = new Categoria();


        Produto celular = new Produto("Galaxy S7 Edge", "Compacto, eficiente, portável, polido",
                new BigDecimal("2700"), celulares);

        //Recurso do JPA que estabelece uma interface de comunicação com o banco de dados abastraída em JPAUtil
        EntityManager entityManager = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(entityManager);
        CategoriaDAO categoriaDAO = new CategoriaDAO(entityManager);

        entityManager.getTransaction().begin();

        categoriaDAO.cadastrar(celulares);
        produtoDao.cadastrar(celular);

        entityManager.getTransaction().commit();
        entityManager.close();

        //OBS: através dos comandos de transação abaixo, é habilitado a conexão, e realizado no commit.
        //Necessário para realizar operações de escrita no banco... (insert, update e delete)

    }

}
