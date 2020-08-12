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
		int contador = 0;
		for (Lance l : lances) {
			if (l.getUsuario().equals(lance.getUsuario())) {
				contador ++;
			}
		}

		if (lances.isEmpty() || (!pegaUltimoLance().getUsuario().equals(lance.getUsuario()) && contador < 5)){
			lances.add(lance);
		}
	}

	private Lance pegaUltimoLance() {
		return lances.get(lances.size() - 1);
	}

	public String getDescricao() {
		return descricao;
	}

	public List<Lance> getLances() {
		return Collections.unmodifiableList(lances);
	}

}
