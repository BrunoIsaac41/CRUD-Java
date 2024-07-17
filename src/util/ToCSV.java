package util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ToCSV {

    private static final String separador = ",";
    private static final String quebraLinha = "\n";

    public void gerarCSV(String arquivo, List dados, String[] cabecalho)  {

        try (FileWriter writer = new FileWriter(arquivo, true)) {

            File file = new File(arquivo);
            if (file.length() == 0) {
                escreverLinha(writer, cabecalho); // Escreve o cabeçalho
            }
            // Escreve os dados
            for (int i = 0; i < dados.size(); i++) {
                escreverLinha(writer, (String[]) dados.get(i));
            }
        } catch (RuntimeException e){
            e.getMessage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void escreverLinha(FileWriter writer, String[] campos) throws IOException {
        for (int i = 0; i < campos.length; i++) {
            writer.append(transformarValorCSV(campos[i]));
            if (i < campos.length - 1) {
                writer.append(separador);
            }
        }
        writer.append(quebraLinha);
    }

    public String transformarValorCSV(String valor) {
        if (valor == null || valor.isEmpty()) {
            return "";
        }

        valor = valor.replace("\"", "\"\"");
        if (valor.contains(",") || valor.contains("\"") || valor.contains("\n") || valor.contains("\r")) {
            valor = "\"" + valor + "\"";
        }
        return valor;
    }
}
