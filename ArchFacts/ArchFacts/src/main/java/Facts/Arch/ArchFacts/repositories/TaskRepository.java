package Facts.Arch.ArchFacts.repositories;

import Facts.Arch.ArchFacts.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, UUID> {
}
