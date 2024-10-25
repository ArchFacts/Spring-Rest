package Facts.Arch.ArchFacts.System;

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

    public void quickSortMeio(FiltroLogs[] arquivos, int indInicio, int indFim) {
        int i, j;
        i = indInicio;
        j = indFim;

        String pivo = arquivos[(indInicio + indFim / 2)].getTempoResposta();

        while (i <= j) {
            while (arquivos[i].getTempoResposta().compareTo(pivo) < 0) {
                i++;
            }

            while (arquivos[j].getTempoResposta().compareTo(pivo) > 0) {
                j--;
            }

            if (i <= j) {
                FiltroLogs aux = arquivos[j];
                arquivos[i] = arquivos[j];
                arquivos[j] = aux;

                i++;
                j--;
            }
        }

        if (indInicio < j) {
            quickSortMeio(arquivos, indInicio, j);
        }
        if (i < indFim) {
            quickSortMeio(arquivos, i, indFim);
        }
    }

    public int pesquisaBinariaTempoReposta(FiltroLogs[] v, String valor) {
        int inicio, meio, fim;
        inicio = 0;
        fim = v.length - 1;

        while (inicio <= fim) {
            meio = (inicio + fim) / 2;
            if (v[meio].getTempoResposta().compareTo(valor) == 0) {
                return  meio;
            } else if (0 < v[meio].getTempoResposta().compareTo(valor)) {
                fim = meio - 1;
            } else {
                inicio = meio +1;
            }
        }
        return -1;  
    }
}
