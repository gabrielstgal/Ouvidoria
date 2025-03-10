package Reclamação2;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

import javax.swing.JOptionPane;



import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        
        ArrayList<Usuario> usuarios = new ArrayList<>();
        ArrayList<Manifestacao> manifestacoes = new ArrayList<>();
        int opcao = 0;
        int contador = 0;
        LocalDate dataNascimento = null;
        while(opcao != 5){ 
            do {
                String escolha = JOptionPane.showInputDialog("Escolha uma opção:\n" +
                "1. Cadastrar Pessoa e manifestação\n" +
                "2. Listar Manifestações por Usuário\n" +
                "3. Listar Manifestações por Dia\n" +
                "4. Quantidade de cadastros\n" +
                "5. Sair");
                try {
                opcao = Integer.parseInt(escolha);
                switch (opcao) {
                   case 1:
                            String nome = JOptionPane.showInputDialog("Qual seu nome? ");
                           
                            
                            boolean dataValida = false;

                            while (!dataValida) {
                            String dataNascimentoString = JOptionPane.showInputDialog("Informe sua data de nascimento (AAAA-MM-DD): ");
                                try {
                                    dataNascimento = LocalDate.parse(dataNascimentoString);
                                    dataValida = true; 
                                } catch (DateTimeParseException e) {
                                    JOptionPane.showMessageDialog(null, "Data inválida. Por favor, digite novamente.");
                                }
                            }
                            String descricao = JOptionPane.showInputDialog("Faça sua manifestação: ");
                                String telefone = "";
                                boolean entrada = false;
                                while (!entrada) {
                                    try {
                                        telefone = JOptionPane.showInputDialog("Informe seu telefone: ");
                                        Long.parseLong(telefone);
                                        entrada = true;
                                    } catch (NumberFormatException e) {
                                        JOptionPane.showMessageDialog(null, "Telefone inválido! Por favor, insira apenas números.");
                                    }
                                }

                            
                            
    
                            
                            String[] tiposManifestacao = {"Sugestão", "Elogio", "Crítica"};
                            String tipoManifestacao = (String) JOptionPane.showInputDialog(null,
                                        "Selecione o tipo de manifestação",
                                        "Tipo de Manifestação",
                                        JOptionPane.QUESTION_MESSAGE,
                                        null,
                                        tiposManifestacao,
                                        tiposManifestacao[0]);
                            
                            String[] profissoes = {"aluno", "professor", "colaborador"};
                            String profissao = (String) JOptionPane.showInputDialog(null,
                                            "Selecione o tipo de usuário",
                                            "Tipo de Usuário",
                                            JOptionPane.QUESTION_MESSAGE,
                                            null,
                                            profissoes,
                                            profissoes[0]);
                                        
                             Usuario usuario = null;
                             if (profissao.equals("aluno")) {
                                double media = 0.0; 
                                String mediaInput;
                                    do {
                                        mediaInput = JOptionPane.showInputDialog(null, "Qual a sua média na escola? (Digite 'cancelar' para sair)");
                                    if (mediaInput == null) {
                                        JOptionPane.showMessageDialog(null, "Operação cancelada.");
                                        return; 
                                     }
                                        if (mediaInput.trim().isEmpty()) {
                                            JOptionPane.showMessageDialog(null, "Por favor, insira um valor válido.");
                                            }
                                            } while (mediaInput.trim().isEmpty());
                                            
                                            try {
                                                media = Double.parseDouble(mediaInput);
                                                usuario = new Aluno(nome, telefone, dataNascimento, profissao, media);
                                                } catch (NumberFormatException e) {
                                                    JOptionPane.showMessageDialog(null, "Média inválida. Por favor, insira um número válido.");
                                                }
                                        } else if (profissao.equals("professor")) {
                                            int cargaHoraria = 0;
                                            String cargaHorariaInput;
                                            do {
                                                cargaHorariaInput = JOptionPane.showInputDialog(null, "Qual sua carga horária? (Digite 'cancelar' para sair)");
                                                if (cargaHorariaInput == null) {
                                                 JOptionPane.showMessageDialog(null, "Operação cancelada.");
                                                return; 
                                                    }
                                                if (cargaHorariaInput.trim().isEmpty()) {
                                                        JOptionPane.showMessageDialog(null, "Por favor, insira um valor válido.");
                                                    }
                                                } while (cargaHorariaInput.trim().isEmpty());
                                            
                                                try {
                                                    cargaHoraria = Integer.parseInt(cargaHorariaInput);
                                                    usuario = new Professor(nome, telefone, dataNascimento, profissao, cargaHoraria);
                                                } catch (NumberFormatException e) {
                                                    JOptionPane.showMessageDialog(null, "Carga horária inválida. Por favor, insira um número válido.");
                                                }
                                            } else if (profissao.equals("colaborador")) {
                                                String setor;
                                                do {
                                                    setor = JOptionPane.showInputDialog(null, "Qual setor você trabalha? (Digite 'cancelar' para sair)");
                                                    if (setor == null) {
                                                        JOptionPane.showMessageDialog(null, "Operação cancelada.");
                                                        return; 
                                                    }
                                                    if (setor.trim().isEmpty()) {
                                                        JOptionPane.showMessageDialog(null, "Por favor, insira um valor válido.");
                                                    }
                                                } while (setor.trim().isEmpty());
                                            
                                                usuario = new Colaborador(nome, telefone, dataNascimento, profissao, setor);
                                            }
                            usuarios.add(usuario);
                            
                            Manifestacao.TipoManifestacao tipoEnum = null;
                            switch (tipoManifestacao) {
                                case "Sugestão":
                                    tipoEnum = Manifestacao.TipoManifestacao.SUGESTAO;
                                    break;
                                case "Elogio":
                                    tipoEnum = Manifestacao.TipoManifestacao.ELOGIO;
                                    break;
                                case "Crítica":
                                    tipoEnum = Manifestacao.TipoManifestacao.CRITICA;
                                    break;
                            }
                            contador++;
                            
                            
                            Manifestacao manifestacao = new Manifestacao(descricao, LocalDate.now(), usuario, tipoEnum);
                            manifestacoes.add(manifestacao);
                            break;
                            
                case 2:
                            String nomeUsuario = JOptionPane.showInputDialog("Qual o nome do usuário?");
                            for (Usuario user : usuarios) {
                                if (nomeUsuario.equals(user.getNome())) {
                                    for (Manifestacao manifest : manifestacoes) {
                                        if (user.equals(manifest.getUsuario())) {
                                            
                                            String setor = "";
                                            String cargaHoraria = "";
                                            String media = "";
                                            if (user instanceof Colaborador) {
                                                setor = "\nSetor: " + ((Colaborador) user).getSetor();
                                            } else if ( user instanceof Professor) {
                                                cargaHoraria = "\nCarga Horaria: " + ((Professor) user).getCargaHoraria();
                                            } else if ( user instanceof Aluno ) {
                                                media = "\nMedia: " + ((Aluno) user).getMedia();
                                            }
                                            
                                            JOptionPane.showMessageDialog(null, "Nome: " + user.getNome() + "\n" +
                                            "Telefone: " + user.getTelefone() + "\n" +
                                            "Data de Nascimento: " + user.getDataNascimento() + "\n" +
                                            "Descrição da Manifestação: " + manifest.getDescricao() + "\n" +
                                            "Tipo de Manifestação: " + manifest.getTipo() + "\n" + 
                                            "Profissão: " + user.getProfissao() + setor + cargaHoraria + media );
                                        }
                                    }
                                } else if (nomeUsuario != user.getNome()) {
                                        JOptionPane.showMessageDialog(null,"Usuario Invalido, escolha um Usuario cadastrado!");
                                }
                            }
                            break;
                        
                    case 3:
                
                    boolean datahoje = false;
                    LocalDate dataSelecionada = null;
                    
                    while (!datahoje) {
                        String dataString = JOptionPane.showInputDialog("Digite a data (AAAA-MM-DD):");
                        
                        try {
                            dataSelecionada = LocalDate.parse(dataString);
                            datahoje = true;
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Data inválida. Por favor, digite novamente.");
                        }
                    }
                    
                    boolean encontrouManifestacao = false;
                    for (Usuario user : usuarios) {
                        for (Manifestacao manifest : manifestacoes) {
                            if (manifest.getDataCriada().equals(dataSelecionada) && manifest.getUsuario().getNome().equals(user.getNome())) {
                                    encontrouManifestacao = true;
                                 JOptionPane.showMessageDialog(null, "Nome: " + user.getNome() + "\n" +
                                    "Telefone: " + user.getTelefone() + "\n" +
                                    "Data de Nascimento: " + user.getDataNascimento() + "\n" +
                                    "Descrição da Manifestação: " + manifest.getDescricao() + "\n" +
                                    "Tipo de Manifestação: " + manifest.getTipo() + "\n" +
                                    "Profissão: " + user.getProfissao());
                                 }
                            }
                        }

                         if (!encontrouManifestacao) {
                          JOptionPane.showMessageDialog(null, "Nenhuma manifestação encontrada para a data inserida.");
                            }

                    
                
            
                            break;
                        case 4:
                        JOptionPane.showMessageDialog(null, "A quantidade de cadastros realizados foi: " + contador);
                            break;
                        case 5:
                            JOptionPane.showMessageDialog(null, "Saindo...");
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Opção inválida! Por favor, escolha uma opção válida.");
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Por favor, insira um número correspondente à opção desejada.");
                }
            } while (opcao != 5);
        }
    }
}
