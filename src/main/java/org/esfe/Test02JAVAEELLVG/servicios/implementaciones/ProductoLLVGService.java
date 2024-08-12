package org.esfe.Test02JAVAEELLVG.servicios.implementaciones;

import org.esfe.Test02JAVAEELLVG.modelos.ProductoLLVG;
import org.esfe.Test02JAVAEELLVG.repositorios.IProductoLLVGRepository;
import org.esfe.Test02JAVAEELLVG.servicios.interfaces.IProductoLLVGService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoLLVGService implements IProductoLLVGService {

    @Autowired
    private IProductoLLVGRepository productoRepository;

    @Override
    public Page<ProductoLLVG> buscarTodosPaginados(Pageable pageable) {
        return productoRepository.findAll(pageable);
    }

    @Override
    public List<ProductoLLVG> obtenerTodos() {
        return productoRepository.findAll();
    }

    @Override
    public ProductoLLVG buscarPorId(Long id) {
        Optional<ProductoLLVG> productoOptional = productoRepository.findById(id);
        if (productoOptional.isPresent()) {
            return productoOptional.get();
        } else {
            throw new RuntimeException("Producto no encontrado con ID: " + id); // O lanzar una excepción personalizada
        }
    }

    @Override
    public ProductoLLVG crearOEditar(ProductoLLVG productoLLVG) {
        return productoRepository.save(productoLLVG);
    }

    @Override
    public void eliminarPorId(Long id) {
        if (productoRepository.existsById(id)) {
            productoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Producto no encontrado con ID: " + id); // O lanzar una excepción personalizada
        }
    }
}
