package com.example.foro_topico.controller;

import com.example.foro_topico.domain.topicos.DatosActualizarTopico;
import com.example.foro_topico.domain.topicos.DatosListadoTopico;
import com.example.foro_topico.domain.topicos.DatosRegistrosTopicos;
import com.example.foro_topico.domain.topicos.DatosRespuestaTopico;
import com.example.foro_topico.domain.topicos.Topico;
import com.example.foro_topico.domain.topicos.TopicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping({"/topicos"})
public class TopicoController {
    @Autowired
    private TopicoRepository topicoRepository;


    @PostMapping
    public ResponseEntity<DatosRespuestaTopico> registrartopico(@RequestBody @Valid DatosRegistrosTopicos datosRegistrosTopicos, UriComponentsBuilder uriComponentsBuilder) {
        Topico topico = (Topico)this.topicoRepository.save(new Topico(datosRegistrosTopicos));
        DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(topico.getId(), topico.getNombre(), topico.getMensaje(), topico.getCurso(), topico.getTitulo());
        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(new Object[]{topico.getId()}).toUri();
        return ResponseEntity.created(url).body(datosRespuestaTopico);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoTopico>> listadoTopicos(@PageableDefault Pageable paginacion) {
        return ResponseEntity.ok(this.topicoRepository.findByActivoTrue(paginacion).map(DatosListadoTopico::new));
    }

    @PutMapping
    @Transactional
    public ResponseEntity actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico) {
        Topico topico = (Topico)this.topicoRepository.getReferenceById(datosActualizarTopico.id());
        topico.actualizarDatos(datosActualizarTopico);
        return ResponseEntity.ok(new DatosRespuestaTopico(topico.getId(), topico.getNombre(), topico.getMensaje(), topico.getCurso(), topico.getTitulo()));
    }

    @DeleteMapping({"/{id}"})
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id) {
        Topico topico = (Topico)this.topicoRepository.getReferenceById(id);
        topico.desactivarTopico();
        return ResponseEntity.noContent().build();
    }

    @GetMapping({"/{id}"})
    @Transactional
    public ResponseEntity<DatosRespuestaTopico> retornaDatosTopico(@PathVariable Long id) {
        Topico topico = (Topico)this.topicoRepository.getReferenceById(id);
        DatosRespuestaTopico datosTopico = new DatosRespuestaTopico(topico.getId(), topico.getNombre(), topico.getMensaje(), topico.getCurso(), topico.getTitulo());
        return ResponseEntity.ok(datosTopico);
    }
}
