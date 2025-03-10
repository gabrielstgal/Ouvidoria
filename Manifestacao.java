package Reclamação2;
import java.time.LocalDate;

public class Manifestacao {
    private String descricao;
    private LocalDate dataCriada;
    private Usuario usuario;
    private TipoManifestacao tipo;
    
    public Manifestacao(String descricao, LocalDate dataCriada, Usuario usuario, TipoManifestacao tipo) {
        this.descricao = descricao;
        this.dataCriada= dataCriada;
        this.usuario = usuario;
        this.tipo = tipo;
    }
    public Manifestacao() {
        
    }
    public Manifestacao(String descricao) {
        this.descricao = descricao;
    }

   
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

   
    public LocalDate getDataCriada() {
        return dataCriada;
    }

    public void setDataCriada(LocalDate dataCriada) {
        this.dataCriada = dataCriada;
    }

   
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


    public TipoManifestacao getTipo() {
        return tipo;
    }

    public void setTipo(TipoManifestacao tipo) {
        this.tipo = tipo;
    }

  
    public enum TipoManifestacao {
        SUGESTAO,
        ELOGIO,
        CRITICA
    }

}
  