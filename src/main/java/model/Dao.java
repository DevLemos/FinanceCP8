package model;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;

public class Dao {

    private EntityManager manager;


    private void conectar() {
        try{
            manager = Persistence.createEntityManagerFactory("finance").createEntityManager();
        }catch (Exception erro){
            System.out.println("Deu erro:" + erro.getMessage());
        }
    }


    public int salvarCurso(Cliente cliente) {
        conectar();
        try {
            manager.getTransaction().begin();
            manager.persist(cliente); //salva os dados na tabela do BD
            manager.getTransaction().commit();
            System.out.println("Cliente criado com ID: " + cliente.getId());
            return 1; //se salvou
        } catch (RollbackException erro) { //duplicação de chave primária
            return 2; //curso já cadastrado
        } catch (Exception erro) { //se deu um erro qualquer
            return 0;
        }
    }



    /*public int alterarCurso(String codigo, String nome, String duracao) {
        conectar();
        try {
            Curso curso = manager.find(Curso.class, codigo);
            curso.setNome(nome);
            curso.setDuracao(duracao);
            manager.getTransaction().begin();
            manager.merge(curso); //UPDATE
            manager.getTransaction().commit();
            return 1;
        } catch (Exception erro) {
            return 0;
        }
    }

    public int excluirCurso(String codigo) {
        conectar();
        //Busca o curso pelo código na tabela curso do BD
        Curso curso = manager.find(Curso.class, codigo);
        if (curso == null) { //Não localizou o curso
            return 0;
        } else { //Localizou o curso
            manager.getTransaction().begin();
            manager.remove(curso); //Apaga o curso
            manager.getTransaction().commit();
            return 1;
        }
    }

    public List<Curso> listarCursos() {
        conectar();
        return manager.createNamedQuery("Curso.findAll", Curso.class).getResultList();
    }*/

}
