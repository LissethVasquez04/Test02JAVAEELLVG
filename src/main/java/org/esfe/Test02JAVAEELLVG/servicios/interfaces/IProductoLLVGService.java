package org.esfe.Test02JAVAEELLVG.servicios.interfaces;

import org.esfe.Test02JAVAEELLVG.modelos.ProductoLLVG;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductoLLVGService {
    Page<ProductoLLVG> buscarTodosPaginados(Pageable pageable);

    List<ProductoLLVG> obtenerTodos();

    ProductoLLVG buscarPorId(Long id);

    ProductoLLVG crearOEditar(ProductoLLVG productoLLVG);

    void eliminarPorId(Long id);
}
 