package org.esfe.Test02JAVAEELLVG.servicios.implementaciones;

import org.esfe.Test02JAVAEELLVG.modelos.OrdenLLVG;
import org.esfe.Test02JAVAEELLVG.repositorios.IOrdenLLVGRepository;
import org.esfe.Test02JAVAEELLVG.servicios.interfaces.IOrdenLLVGService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdenLLVGService implements IOrdenLLVGService {

    @Autowired
    private IOrdenLLVGRepository ordenRepository;

    @Override
    public Page<OrdenLLVG> buscarTodosPaginados(Pageable pageable) {
        return ordenRepository.findAll(pageable);
    }

    @Override
    public List<OrdenLLVG> obtenerTodos() {
        return ordenRepository.findAll();
    }

    @Override
    public OrdenLLVG buscarPorId(Long id) {
        Optional<OrdenLLVG> ordenOptional = ordenRepository.findById(id);
        if (ordenOptional.isPresent()) {
            return ordenOptional.get();
        } else {
            throw new RuntimeException("Orden no encontrada con ID: " + id); // O lanzar una excepción personalizada
        }
    }

    @Override
    public OrdenLLVG crearOEditar(OrdenLLVG ordenLLVG) {
        return ordenRepository.save(ordenLLVG);
    }

    @Override
    public void eliminarPorId(Long id) {
        if (ordenRepository.existsById(id)) {
            ordenRepository.deleteById(id);
        } else {
            throw new RuntimeException("Orden no encontrada con ID: " + id); // O lanzar una excepción personalizada
        }
    }
}
