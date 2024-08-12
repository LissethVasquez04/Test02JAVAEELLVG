package org.esfe.Test02JAVAEELLVG.servicios.interfaces;

import org.esfe.Test02JAVAEELLVG.modelos.DetalleOrdenLLVG;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IDetalleOrdenLLVGService {
    Page<DetalleOrdenLLVG> buscarTodosPaginados(Pageable pageable);

    List<DetalleOrdenLLVG> obtenerTodos();

    DetalleOrdenLLVG buscarPorId(Long id);

    DetalleOrdenLLVG crearOEditar(DetalleOrdenLLVG detalleOrdenLLVG);

    void eliminarPorId(Long id);
}