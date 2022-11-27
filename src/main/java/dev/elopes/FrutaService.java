package dev.elopes;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import dev.elopes.dto.InserirFrutaDTO;
import io.quarkus.arc.Lock;
import io.quarkus.arc.Lock.Type;

@Lock
@ApplicationScoped
public final class FrutaService {
  
  @Lock(value = Type.READ, time = 1, unit = TimeUnit.SECONDS)
  public List<Fruta> list() {
    return Fruta.listAll();
  }

  @Transactional
  public void create(InserirFrutaDTO dto) {
    Fruta fruta = new Fruta();
    fruta.nome = dto.getNome();
    fruta.qtd = dto.getQtd();
    fruta.persist();
  }

}
