package be.vdab.repositories;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import be.vdab.entities.Artikel;

public class ArtikelRepository extends AbstractRepository {
	public Optional<Artikel> read(long id){
			return Optional.ofNullable(getEntityManager().find(Artikel.class, id));
	}
	
	public void create(Artikel artikel) {
		getEntityManager().persist(artikel);
	}
	
	public List<Artikel> findArtikelHasInName(String text){
		return getEntityManager().createQuery(
				"select a from Artikel a where a.naam like :text order by a.naam", Artikel.class)
				.setParameter("text", "%" + text + "%")
				.getResultList();
	}
	
	public void algemenePrijsverhoging(BigDecimal factor) {
		getEntityManager().createNamedQuery("Artikel.algemeneOpslag")
		.setParameter("factor", factor)
		.executeUpdate();
	}
	
	public List<Artikel> findAll(){
		return getEntityManager().createNamedQuery("Artikel.findAll", Artikel.class).getResultList();
	}
}
