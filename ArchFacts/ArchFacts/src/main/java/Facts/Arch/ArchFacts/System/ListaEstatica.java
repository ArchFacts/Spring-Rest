package Facts.Arch.ArchFacts.System;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class ListaEstatica{
    protected SystemLog[] vetor;
    protected int nElementos;

    public ListaEstatica() {
        vetor = new SystemLog[10];
        nElementos = 0;
    }

    public void adiciona(SystemLog log) {
        if (nElementos >= vetor.length) {
            aumentarCapacidade();
        } else {
            vetor[nElementos++] = log;
        }
    }

    private void aumentarCapacidade() {
        int novaCapacidade = vetor.length * 2;
        SystemLog[] novoVetor = new SystemLog[novaCapacidade];
        System.arraycopy(vetor, 0, novoVetor, 0, vetor.length);
        vetor = novoVetor;
    }

    public void quickSortMeio(List<SystemLog> vetor, int indInicio, int indFim) {
        if (indInicio >= indFim) {
            return; // Caso base: se o intervalo não tiver elementos ou tiver apenas um
        }

        int i = indInicio;
        int j = indFim;

        // Pivo é o elemento do meio
        LocalDateTime pivo = vetor.get((indInicio + indFim) / 2).getHorario();

        while (i <= j) {
            // Encontrar elemento maior que o pivo
            while (i < vetor.size() && vetor.get(i) != null && vetor.get(i).getHorario().isBefore(pivo)) {
                i++;
            }
            // Encontrar elemento menor que o pivo
            while (j >= 0 && vetor.get(j) != null && vetor.get(j).getHorario().isAfter(pivo)) {
                j--;
            }
            // Trocar os elementos
            if (i <= j) {
                SystemLog aux = vetor.get(i);
                vetor.set(i, vetor.get(j));
                vetor.set(j, aux);
                i++;
                j--;
            }
        }

        // Recursão
        if (indInicio < j) {
            quickSortMeio(vetor, indInicio, j);
        }
        if (i < indFim) {
            quickSortMeio(vetor, i, indFim);
        }
    }

    public int pesquisaBinariaHorario(List<SystemLog> vetor, LocalDateTime valor) {
        int inicio, meio, fim;
        inicio = 0;
        fim = nElementos - 1;

        while (inicio <= fim) {
            meio = (inicio + fim) / 2;
            if (vetor.get(meio).getHorario().isEqual(valor)) {
                return meio;
            } else if (vetor.get(meio).getHorario().isAfter(valor)) {
                fim = meio - 1;
            } else {
                inicio = meio +1;
            }
        }
        return -1;
    }

    public List<SystemLog> pegarVetor() {
        List<SystemLog> logList = new ArrayList<>();
        for (int i = 0; i < nElementos; i++) {
            if (vetor[i] != null) {
                logList.add(vetor[i]);
            }
        }
        quickSortMeio(logList, 0, logList.size() - 1);
        return logList;
    }
}
