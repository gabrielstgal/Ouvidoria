package Reclamação2;
import java.time.LocalDate;

public class Professor extends Usuario {
    private int cargaHoraria;

    public Professor(String nome, String telefone, LocalDate dataNascimento, String profissao, int cargaHoraria) {
        super(nome, telefone, dataNascimento, profissao);
        this.cargaHoraria = cargaHoraria;
    }
    
    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
}