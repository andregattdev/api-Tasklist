package app.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import app.model.Task;
import app.services.TaskService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/tarefas")
public class TaskController {

    @Autowired
    private TaskService tarefaService;

    @GetMapping
    public List<Task> listar() {
        return tarefaService.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> buscar(@PathVariable Long id) {
        return tarefaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Task> criar(@RequestBody Task task) {
        Task novaTarefa = tarefaService.criar(task);
        return ResponseEntity.ok(novaTarefa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> atualizar(@PathVariable Long id, @RequestBody Task task) {
        try {
            Task tarefaAtualizada = tarefaService.atualizar(id, task);
            return ResponseEntity.ok(tarefaAtualizada); // ✅ retorna JSON
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build(); // ✅ evita erro 500 se id não existe
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); 
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id) {
    	tarefaService.deletar(id);
    	return ResponseEntity.noContent().build();
    }
}

