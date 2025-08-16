package com.foroAluraLatam.demo.controller;

import com.foroAluraLatam.demo.domain.topico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/topicos")
@RequiredArgsConstructor
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    // GET general
    @GetMapping
    public ResponseEntity<List<Topico>> listarTopicos() {
        List<Topico> lista = topicoRepository.findAll();
        return ResponseEntity.ok(lista);
    }

    // GET(por id)
    @GetMapping("/{id}")
    public ResponseEntity<Topico> buscarTopicoPorID(@PathVariable Long id) {
        return topicoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST
    @PostMapping
    public ResponseEntity<DatosRespuestaTopico> crearTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico,
                                                            UriComponentsBuilder uriComponentsBuilder) {
        Topico topico = topicoRepository.save(new Topico(datosRegistroTopico));
        DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaDeCreacion(), topico.isStatus(), topico.getAutor(), topico.getCurso());

        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaTopico);

    }

//     PUT
    @PutMapping
    @Transactional
    public ResponseEntity<DatosActualizacionTopico> actualizarTopico(@RequestBody @Valid DatosActualizacionTopico datosActualizarTopico) {
        Topico topico = topicoRepository.getReferenceById(datosActualizarTopico.id());
        topico.actualizarTopico(datosActualizarTopico);
        return ResponseEntity.ok(new DatosActualizacionTopico(topico.getId(), topico.getTitulo(), topico.getMensaje(),
                topico.getAutor(), topico.getCurso()));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrarTopico(@PathVariable Long id) {
        if (topicoRepository.existsById(id)) {
            topicoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}