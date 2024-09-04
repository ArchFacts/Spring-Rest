package facts.arch.ArchFacts.API.REST.entity;

import java.time.LocalDate;

public class Task {
    private Integer id;
    private LocalDate dataTermino;

    public Task() {
    }

    public Task(Integer id, LocalDate dataTermino) {
        this.id = id;
        this.dataTermino = dataTermino;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(LocalDate dataTermino) {
        this.dataTermino = dataTermino;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", dataTermino=" + dataTermino +
                '}';
    }
}
