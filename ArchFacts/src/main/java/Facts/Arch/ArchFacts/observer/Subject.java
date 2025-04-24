package Facts.Arch.ArchFacts.observer;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Subject {
    private List<Observer> listaObservers = new ArrayList<>();

    public void adicionar(Observer observer) {
        listaObservers.add(observer);
    }

    public void remover(Observer observer) {
        listaObservers.remove(observer);
    }

    public void notificar(Object entidade) {
        for (Observer observer : listaObservers) {
            observer.atualizar(entidade);
        }
    }
}