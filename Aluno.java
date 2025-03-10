package Reclamação2;
import java.time.LocalDate;

public class Aluno extends Usuario {
    private double media;

    public Aluno(String nome, String telefone, LocalDate dataNascimento, String profissao, double media) {
        super(nome, telefone, dataNascimento, profissao);
        this.media = media;
    }
   
    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }
}
