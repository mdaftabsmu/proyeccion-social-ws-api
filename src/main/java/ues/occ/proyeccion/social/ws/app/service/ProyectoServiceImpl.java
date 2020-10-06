package ues.occ.proyeccion.social.ws.app.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ues.occ.proyeccion.social.ws.app.dao.Proyecto;
import ues.occ.proyeccion.social.ws.app.repository.ProyectoRepository;

import java.util.Collections;
import java.util.List;

@Service
public class ProyectoServiceImpl implements ProyectoService {

    private final ProyectoRepository proyectoRepository;

    public ProyectoServiceImpl(ProyectoRepository proyectoRepository) {
        this.proyectoRepository = proyectoRepository;
    }

    @Override
    public Proyecto findById(int id) {
       return this.proyectoRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public List<Proyecto> findAll(int page, int size) {
        Pageable paging = PageRequest.of(page, size);
        Page<Proyecto> proyectoPage = proyectoRepository.findAll(paging);
        if(proyectoPage.hasContent()){
            return proyectoPage.getContent();
        }
        else{
            return Collections.EMPTY_LIST;
        }
    }
}
