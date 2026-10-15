package com.example.tasks.persistence;

import com.example.tasks.task.TaskStatus;
import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TaskRepository extends JpaRepository<TaskEntity, UUID> {

  Optional<TaskEntity> findByIdAndOwnerId(UUID id, UUID ownerId);

  @Query(
      """
      select t from TaskEntity t
      where t.owner.id = :ownerId
        and (:status is null or t.status = :status)
        and (:dueBefore is null or t.dueDate < :dueBefore)
      """)
  Page<TaskEntity> search(
      @Param("ownerId") UUID ownerId,
      @Param("status") TaskStatus status,
      @Param("dueBefore") LocalDate dueBefore,
      Pageable pageable);
}
