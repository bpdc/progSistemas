package ProgramacaoSistemas.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ProgramacaoSistemas.demo.Curso;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    private List<Curso> cursos = new ArrayList<>();

    @Autowired
    public CursoController() {
        cursos.add(new Curso("Curso de Java", 120));
        cursos.add(new Curso("Curso de costura", 80));
        cursos.add(new Curso("REACT", 80));
    }

    @GetMapping
    public List<Curso> listarCursos() {
        return cursos;
    }

    @PostMapping
    public Curso adicionarCurso(@RequestBody Curso curso) {
        cursos.add(curso);
        return curso;
    }

    @GetMapping("/{nome}")
    public Curso obterCurso(@PathVariable String nome) {
        return cursos.stream()
                .filter(c -> c.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .orElse(null);
    }

    @PutMapping("/{nome}")
    public Curso atualizarCurso(@PathVariable String nome, @RequestBody Curso cursoAtualizado) {
        Curso curso = obterCurso(nome);
        if (curso != null) {
            curso.setNome(cursoAtualizado.getNome());
            curso.setDuracao(cursoAtualizado.getDuracao());
        }
        return curso;
    }

    @DeleteMapping("/{nome}")
    public void deletarCurso(@PathVariable String nome) {
        cursos.removeIf(c -> c.getNome().equalsIgnoreCase(nome));
    }
}
