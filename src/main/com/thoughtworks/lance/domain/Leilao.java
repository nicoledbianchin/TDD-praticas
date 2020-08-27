package main.com.thoughtworks.lance.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leilao {

	private String descricao;
	private List<Lance> lances;
	
	public Leilao(String descricao) {
		this.descricao = descricao;
		this.lances = new ArrayList<Lance>();
	}
	
	public void propoe(Lance lance) {
		if (lances.isEmpty() || (podeDarNovoLance(lance.getUsuario()))){
			lances.add(lance);
		}
	}

	private Lance pegarUltimoLance() {
		return lances.get(lances.size() - 1);
	}

	private int pegarQuantidadeLancesDoUsuario(Usuario usuario) {
		int contador = 0;

		for (Lance lance : lances) {
			if (lance.getUsuario().equals(usuario)) {
				contador++;
			}
		}
		return  contador;
	}

	private boolean podeDarNovoLance(Usuario usuario) {
		return !pegarUltimoLance().getUsuario().equals(usuario) && pegarQuantidadeLancesDoUsuario(usuario) < 5;
	}

	public List<Lance> getLances() {
		return Collections.unmodifiableList(lances);
	}

	public Lance dobraLance(Usuario usuario) {
		Lance ultimo = null;
		for (Lance lance : lances) {
			if (lance.getUsuario() == usuario) {
				ultimo = lance;
			}
		}
		return new Lance(usuario, ultimo.getValor() * 2);
	}
}
