package app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.model.Task;
import app.repositories.TaskRepository;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> listarTodas() {
        return taskRepository.findAll();
    }

    public Optional<Task> buscarPorId(Long id) {
        return taskRepository.findById(id);
    }

    public Task criar(Task task) {
        return taskRepository.save(task);
    }

    public Task atualizar(Long id, Task novaTask) {
        return taskRepository.findById(id).map(task -> { 
            task.setTitulo(novaTask.getTitulo());
            task.setDescricao(novaTask.getDescricao());
            task.setConcluida(novaTask.isConcluida());
            return taskRepository.save(task);
        }).orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
    }
    public void deletar(Long id) {
    	taskRepository.deleteById(id);
    }


}
