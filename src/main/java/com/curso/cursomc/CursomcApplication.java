package com.curso.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.curso.cursomc.domain.Categoria;
import com.curso.cursomc.domain.Cidade;
import com.curso.cursomc.domain.Cliente;
import com.curso.cursomc.domain.Endereco;
import com.curso.cursomc.domain.Estado;
import com.curso.cursomc.domain.ItemPedido;
import com.curso.cursomc.domain.Pagamento;
import com.curso.cursomc.domain.PagamentoComBoleto;
import com.curso.cursomc.domain.PagamentoComCartao;
import com.curso.cursomc.domain.Pedido;
import com.curso.cursomc.domain.Produto;
import com.curso.cursomc.domain.enuns.EstadoPagamento;
import com.curso.cursomc.domain.enuns.TipoCliente;
import com.curso.cursomc.repositories.CategoriaRepository;
import com.curso.cursomc.repositories.CidadeRepository;
import com.curso.cursomc.repositories.ClienteRepository;
import com.curso.cursomc.repositories.EnderecoRepository;
import com.curso.cursomc.repositories.EstadoRepository;
import com.curso.cursomc.repositories.ItemPedidoRepository;
import com.curso.cursomc.repositories.PagamentoRepository;
import com.curso.cursomc.repositories.PedidoRepository;
import com.curso.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository CategoriaRepo;
	
	@Autowired
	private ProdutoRepository ProdRepo;
	
	@Autowired
	private CidadeRepository cidadeRepo;
	
	@Autowired
	private EstadoRepository estadoRepo;
	
	@Autowired
	private ClienteRepository clienteRepo;
	
	@Autowired
	private EnderecoRepository enderecoRepo;
	
	@Autowired
	private PedidoRepository pedidoRepo;
	
	@Autowired
	private PagamentoRepository pagamentoRepo;
	
	@Autowired
	private ItemPedidoRepository itemPedidorepo;
	
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null,"Informatica");
		Categoria cat2 = new Categoria(null,"Escritório");
		
		Produto p1 = new Produto(null,"Computador",2000);
		Produto p2 = new Produto(null,"Impressora",800);
		Produto p3 = new Produto(null,"Mouse",80);
		
		cat1.getProduto().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProduto().addAll(Arrays.asList(p2));
		
		p1.getCategoria().addAll(Arrays.asList(cat1));
		p2.getCategoria().addAll(Arrays.asList(cat1,cat2));
		p3.getCategoria().addAll(Arrays.asList(cat1));
		
		
		CategoriaRepo.saveAll(Arrays.asList(cat1,cat2));
		ProdRepo.saveAll(Arrays.asList(p1,p2,p3));
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlandia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est1.getCidades().addAll(Arrays.asList(c2,c3));
		
		
		estadoRepo.saveAll(Arrays.asList(est1,est2));
		cidadeRepo.saveAll(Arrays.asList(c1,c2,c3));
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOAFISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("27363323","93838393"));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 203", "Jardim", "38220834", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, c2);
		
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		clienteRepo.saveAll(Arrays.asList(cli1));
		enderecoRepo.saveAll(Arrays.asList(e1,e2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), e1, cli1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), e2, cli1);
		
		Pagamento pgto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pgto1);
		
		Pagamento pgto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"),null);
		ped2.setPagamento(pgto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1,ped2));
		
		pedidoRepo.saveAll(Arrays.asList(ped1,ped2));
		pagamentoRepo.saveAll(Arrays.asList(pgto1,pgto2));
		
		ItemPedido ip1 = new ItemPedido(ped1, p1, 0, 1, 2000);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0, 2, 80);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100, 1, 800);
		
		ped1.getItens().addAll(Arrays.asList(ip1,ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));
		
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));
		
		itemPedidorepo.saveAll(Arrays.asList(ip1,ip2,ip3));
	}
}
