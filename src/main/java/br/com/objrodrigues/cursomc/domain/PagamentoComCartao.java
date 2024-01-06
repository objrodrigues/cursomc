package br.com.objrodrigues.cursomc.domain;

import br.com.objrodrigues.cursomc.domain.enums.EstadoPagamento;
import jakarta.persistence.Entity;

@Entity
public class PagamentoComCartao extends Pagamento{
	
	private static final long serialVersionUID = 1L;
	
	private Integer numeroDeParcelas;
	
	public PagamentoComCartao() {
		
	}

	public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido, Integer numeDeParcelas) {
		super(id, estado, pedido);
		this.numeroDeParcelas = numeDeParcelas;
	}

	public Integer getNumeroDeParcelas() {
		return numeroDeParcelas;
	}

	public void setNumeroDeParcelas(Integer numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}
}