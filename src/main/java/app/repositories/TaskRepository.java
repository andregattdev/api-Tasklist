package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import app.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
	
}



