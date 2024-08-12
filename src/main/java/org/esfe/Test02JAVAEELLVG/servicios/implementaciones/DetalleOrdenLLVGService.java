package org.esfe.Test02JAVAEELLVG.servicios.implementaciones;

import org.esfe.Test02JAVAEELLVG.modelos.DetalleOrdenLLVG;
import org.esfe.Test02JAVAEELLVG.repositorios.IDetalleOrdenLLVGRepository;
import org.esfe.Test02JAVAEELLVG.servicios.interfaces.IDetalleOrdenLLVGService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleOrdenLLVGService implements IDetalleOrdenLLVGService {

    @Autowired
    private IDetalleOrdenLLVGRepository detalleOrdenRepository;

    @Override
    public Page<DetalleOrdenLLVG> buscarTodosPaginados(Pageable pageable) {
        return detalleOrdenRepository.findAll(pageable);
    }

    @Override
    public List<DetalleOrdenLLVG> obtenerTodos() {
        return detalleOrdenRepository.findAll();
    }

    @Override
    public DetalleOrdenLLVG buscarPorId(Long id) {
        Optional<DetalleOrdenLLVG> detalleOrdenOptional = detalleOrdenRepository.findById(id);
        if (detalleOrdenOptional.isPresent()) {
            return detalleOrdenOptional.get();
        } else {
            throw new RuntimeException("Detalle de Orden no encontrado con ID: " + id); // O lanzar una excepción personalizada
        }
    }

    @Override
    public DetalleOrdenLLVG crearOEditar(DetalleOrdenLLVG detalleOrdenLLVG) {
        return detalleOrdenRepository.save(detalleOrdenLLVG);
    }

    @Override
    public void eliminarPorId(Long id) {
        if (detalleOrdenRepository.existsById(id)) {
            detalleOrdenRepository.deleteById(id);
        } else {
            throw new RuntimeException("Detalle de Orden no encontrado con ID: " + id); // O lanzar una excepción personalizada
        }
    }
}
