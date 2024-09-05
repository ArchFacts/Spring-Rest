package Facts.Arch.ArchFacts.repository;

import Facts.Arch.ArchFacts.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, UUID> {
}
