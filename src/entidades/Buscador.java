package entidades;

import java.util.Collection;

public interface Buscador {
	
	Collection<Buscavel> busca(String termo);

}
