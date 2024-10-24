package Facts.Arch.ArchFacts.System;

import java.io.File;

public class ListaEstatica<T>{
    protected SystemLog[] vetor;
    protected int nElementos;

    public ListaEstatica(int tamanho) {
        vetor = (SystemLog[]) new SystemLog[tamanho];
        nElementos = 0;
    }

    public void adiciona(SystemLog log) {
        if (nElementos >= vetor.length) {
            System.out.println("Lista cheia");
        } else {
            vetor[nElementos++] = log;
        }
    }

    public static void quickSortMeio(File[] arquivos, int indInicio, int indFim) {
        int i, j;
        i = indInicio;
        j = indFim;

        String pivo = arquivos[(indInicio + indFim / 2)].getName();

        while (i <= j) {
            while (arquivos[i].getName().compareTo(pivo) < 0) {
                i++;
            }

            while (arquivos[j].getName().compareTo(pivo) > 0) {
                j--;
            }

            if (i <= j) {
                File aux = arquivos[j];
                arquivos[i] = arquivos[j];
                arquivos[j] = aux;

                i++;
                j--;
            }
        }

        if (indInicio < j) {
            quickSortMeio(arquivos);
        }
    }


}
