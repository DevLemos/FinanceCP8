package controllers;

import model.Cliente;
import model.Dao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controleCliente", urlPatterns = {"/controleCliente"})
public class controleCliente extends HttpServlet {


    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.service(request, response);

        String flag,mensagem;

        //Recebe o conteúdo da variável flag que veio do formulario HMTL
        flag = request.getParameter("flag");

        if(flag.equals("cadastrar")){
            String codigo,nome,sobrenome, email, celular, senha, genero;

            codigo = request.getParameter("codigo");
            nome = request.getParameter("firstname");
            sobrenome = request.getParameter("lastname");
            email = request.getParameter("email");
            celular = request.getParameter("number");
            senha = request.getParameter("confirmPassword");
            genero = request.getParameter("gender");

            Cliente cliente = new Cliente(nome,sobrenome,email,celular,senha,genero,codigo);

            int resultado = new Dao().salvarCurso(cliente);

            switch (resultado) {
                case 1:
                    mensagem = "Cadastro realizado com sucesso";
                    break;
                case 2:
                    mensagem = "Código do cliente já cadastrado";
                    break;
                default:
                    mensagem = "Erro ao tentar salvar o cliente";
                    break;
            }

            //Carrega a mensagem em uma variável "mensagem"
            request.setAttribute("mensagem", mensagem);

            //Indica para qual arquivo JSP a mensage será enviada
            RequestDispatcher disp = request.getRequestDispatcher("mensagens.jsp");
            //Envia a mensagem para o arquivo mensagens.jsp
            disp.forward(request, response);

        }


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }



}


 /*protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //Aqui você recebe os dados que vem da camada View (formulários)
        String flag, mensagem;
        //Recebe o conteúdo da variável flag que veio do forulário HTML
        flag = request.getParameter("flag");
        if (flag.equals("cadastro")) {
            // Receber os dados digitados no formulário
            String c, n, d;
            c = request.getParameter("codigo");
            n = request.getParameter("nome");
            d = request.getParameter("duracao");
            //Encapsular os dados recebidos em um
            //objeto da classe Curso
            //Curso curso = new Curso();
            // curso.setCodigo(c);
            //curso.setNome(n);
            //curso.setDuracao(d);
            //Enviar o objeto curso para o método
            //salvarCurso da classe UniversidadeDao
            //int resultado = new UniversidadeDao().salvarCurso(curso);
            switch (resultado) {
                case 1:
                    mensagem = "Cadastro realizado com sucesso";
                    break;
                case 2:
                    mensagem = "Código do curso já cadastrado";
                    break;
                default:
                    mensagem = "Erro ao tentar salvar o curso";
                    break;
            }
            //Carrega a mensagem em uma variável "mensagem"
            request.setAttribute("mensagem", mensagem);
            //Indica para qual arquivo JSP a mensage será enviada
            RequestDispatcher disp = request.getRequestDispatcher("mensagens.jsp");
            //Envia a mensagem para o arquivo mensagens.jsp
            disp.forward(request, response);
        } else if (flag.equals("excluir")) {
            //Aqui será feita a parte de exclusão de cursos
            String c;
            //Receber o código do curso a excluir
            c = request.getParameter("codigo");
            //Chamar o método excluirCurso na classe UniversidadeDao
            int resultado = new UniversidadeDao().excluirCurso(c);
            if (resultado == 1) { //Se ele excluiu o curso
                mensagem = "Curso excluído com sucesso";
            } else { //Se o curso não foi encontrado
                mensagem = "Curso não está cadastrado";
            }
            //Carrega a mensagem em uma variável "mensagem"
            request.setAttribute("mensagem", mensagem);
            //Indica para qual arquivo JSP a mensage será enviada
            RequestDispatcher disp = request.getRequestDispatcher("mensagens.jsp");
            //Envia a mensagem para o arquivo mensagens.jsp
            disp.forward(request, response);
        } else if (flag.equals("listar")) {
            //Chama o método listarCursos da UniversidadeDao que recebe os cursos
            List<Curso> listaCursos = new UniversidadeDao().listarCursos();
            //Enviar a lista de cursos para exibir em um arquivo listar_cursos.jsp
            request.setAttribute("listaCursos", listaCursos);
            RequestDispatcher disp = request.getRequestDispatcher("listar_cursos.jsp");
            disp.forward(request, response);
        } else if (flag.equals("buscarCurso")) {
            //Buscar o curso para alteração
            String codigo = request.getParameter("codigo");
            Curso curso = new UniversidadeDao().buscarCurso(codigo);
            if (curso == null) { //Se o curso não foi localizado
                request.setAttribute("mensagem", "Curso não localizado");
                RequestDispatcher disp = request.getRequestDispatcher("mensagens.jsp");
                disp.forward(request, response);
            } else { //se encontrou o curso
                request.setAttribute("curso", curso);
                RequestDispatcher disp = request.getRequestDispatcher("carregacurso.jsp");
                disp.forward(request, response);
            }
        } else if (flag.equals("alteracao")) {
            //Receber os dados alterados no form e proceder a alteração
            String codigo, nome, duracao;
            codigo = request.getParameter("codigo");
            nome = request.getParameter("nome");
            duracao = request.getParameter("duracao");
            int resultado = new UniversidadeDao().alterarCurso(codigo, nome, duracao);
            if (resultado == 1) {
                mensagem = "Alteração realizada com sucesso no curso " + codigo;
            } else {
                mensagem = "Erro ao tentar alterar os dados do curso " + codigo;
            }
            request.setAttribute("mensagem", mensagem);
            RequestDispatcher disp = request.getRequestDispatcher("mensagens.jsp");
            disp.forward(request, response);
        }*/
