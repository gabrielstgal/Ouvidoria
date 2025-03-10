package Reclamação2;
import java.time.LocalDate;

public class Colaborador extends Usuario {
    private String setor;

    public Colaborador(String nome, String telefone, LocalDate dataNascimento, String profissao, String setor) {
        super(nome, telefone, dataNascimento, profissao);
        this.setor = setor;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }
}
