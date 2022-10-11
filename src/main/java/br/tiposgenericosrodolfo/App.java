package br.tiposgenericosrodolfo;

import javax.swing.JOptionPane;

public class App {

    public static void main(String[] args) {

        int quantidadePessoas = 0;
        int quantidadeCidades = 0;
        int continua;

        //pergunta a quantidade de pessoas e cidades a serem cadastradas
        quantidadePessoas = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de pessoas que deseja cadastrar: "));
        quantidadeCidades = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de cidades que deseja cadastrar: "));

        // Vetor de pessoas usando o tipo genérico
        Vetor<Pessoa> vetorPessoas = new Vetor<Pessoa>(quantidadePessoas);

        // Vetor de cidades usando o tipo genérico
        Vetor<Cidade> vetorCidades = new Vetor<Cidade>(quantidadeCidades);

        // Preenchendo o vetor de pessoas, usar o i para identificar o objeto
        for (int i = 0; i < quantidadePessoas; i++) {
            String nome = JOptionPane.showInputDialog("Digite o nome da pessoa " + (i + 1) + ": ");
            char sexo = JOptionPane.showInputDialog("Digite o sexo (M ou F) da pessoa " + (i + 1) + ": ").charAt(0);
            // converter o sexo para minusculo
            sexo = Character.toLowerCase(sexo);
            String naturalidade = JOptionPane.showInputDialog("Digite a naturalidade da pessoa " + (i + 1) + ": ");
            Pessoa pessoa = new Pessoa(nome, sexo, naturalidade);
            vetorPessoas.setVetor(pessoa, i);
        }
        // Preencendo o vetor de cidades, usar o i para identificar o objeto
        for (int i = 0; i < quantidadeCidades; i++) {
            String cidade = JOptionPane.showInputDialog("Digite o nome da cidade " + (i + 1) + ": ");
            String gentilico = JOptionPane.showInputDialog("Digite o gentilico da cidade " + (i + 1) + ": ");
            String estado = JOptionPane.showInputDialog("Digite o estado da cidade " + (i + 1) + ": ");
            Cidade cidadeObj = new Cidade(cidade, gentilico, estado);
            vetorCidades.setVetor(cidadeObj, i);
        }

        do {
            // Buscando uma pessoa no vetor de pessoas
            String nomePessoa = JOptionPane.showInputDialog("Digite o nome da pessoa que deseja buscar: ");
            // Percorrendo o vetor de pessoas

            //variaveis boolean para usar nos casos de não achar cidade e pessoa
            boolean achouNome = false;
            boolean achouCidade = false;
            for (int i = 0; i < vetorPessoas.getTamanho(); i++) {
                // Verificando se o nome buscado está no vetor
                String nome_index = vetorPessoas.getVetor(i).getNome();

                if (nomePessoa.toLowerCase().equals(nome_index.toLowerCase())) {
                    achouNome = true;
                    // Percorrendo o vetor de cidades
                    for (int j = 0; j < vetorCidades.getTamanho(); j++) {
                        // Verificando se a naturalidade da pessoa é igual ao nome da cidade
                        String cidade_index = vetorPessoas.getVetor(i).getNaturalidade();
                        if (cidade_index.toLowerCase().equals(vetorCidades.getVetor(j).getNome().toLowerCase())) {
                            achouCidade = true;
                            // Montando a String
                            String artigo = "";
                            if (vetorPessoas.getVetor(i).getSexo() == 'm') {
                                artigo = "O";
                            } else {
                                artigo = "A";
                            }
                            String advetivo_verificado = vetorCidades.getVetor(j).getAdjetivo();
                            // Verfica se o advetivo_verificado contem uma string /
                            if (advetivo_verificado.contains("/")) {
                                // Divide a string em duas partes
                                String[] partes = advetivo_verificado.split("/");
                                // Verifica se o sexo da pessoa é masculino
                                if (vetorPessoas.getVetor(i).getSexo() == 'm') {
                                    // Se for masculino, a primeira parte da string é o adjetivo
                                    advetivo_verificado = partes[0];
                                } else {
                                    // Se for feminino, a segunda parte da string é o adjetivo
                                    advetivo_verificado = partes[1];
                                }
                            }
                            String frase = artigo + " " + advetivo_verificado + " "
                                    + vetorPessoas.getVetor(i).getNome() + " nasceu em "
                                    + vetorCidades.getVetor(j).getNome() + " - " + vetorCidades.getVetor(j).getEstado();
                            // Exibindo a String
                            JOptionPane.showMessageDialog(null, frase);
                        }
                    }
                }
            }


        // Verificando se a pessoa foi encontrada
        if (!achouNome) {
            JOptionPane.showMessageDialog(null, "Pessoa não encontrada");
        }
        // Verificando se a cidade foi encontrada
        if (!achouCidade) {
            JOptionPane.showMessageDialog(null, "Cidade não encontrada");
        }

        continua = JOptionPane.showConfirmDialog(null, "Deseja fazer outra busca?", "FIM DA CONSULTA...", JOptionPane.YES_NO_OPTION);
        } while (continua == JOptionPane.YES_OPTION);
    }

}
