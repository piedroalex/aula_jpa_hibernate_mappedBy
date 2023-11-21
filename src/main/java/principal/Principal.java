package principal;

import java.util.ArrayList;
import java.util.List;

import dao.DespesaDAO;
import dao.PessoaDAO;
import entities.Despesa;
import entities.Pessoa;

/**
 * @author Pedro Alex
 */
public class Principal {
	
	public static void main(String[] args) {
		DespesaDAO despesaDAO = new DespesaDAO();
		
		Despesa despesa1 = new Despesa();
		despesa1.setDescricao("Energia");
		despesa1.setValor(325.75);
		
		Despesa despesa2 = new Despesa();
		despesa2.setDescricao("Aluguel");
		despesa2.setValor(650.12);
		
		despesaDAO.salvar(despesa1);
		despesaDAO.salvar(despesa2);
		
		List<Despesa> despesas = new ArrayList<Despesa>();
		despesas.addAll(despesaDAO.listarTodos());
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Ana");
		pessoa.setDespesas(despesas);
		
		pessoaDAO.salvar(pessoa);
		
		pessoa = new Pessoa();
		pessoa.setNome("Marcos");
		pessoa.setDespesas(despesas);
		
		pessoaDAO.salvar(pessoa);
		
		for(Despesa d: despesaDAO.listarTodos()) {
			System.out.println(d.getDescricao()+": R$"+d.getValor());
			for(Pessoa p: d.getPessoas()) {
				System.out.println(p.getNome());
			}
		}
	}
}
