package org.esfe.Test02JAVAEELLVG.servicios.interfaces;

import org.esfe.Test02JAVAEELLVG.modelos.OrdenLLVG;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IOrdenLLVGService {
    Page<OrdenLLVG> buscarTodosPaginados(Pageable pageable);

    List<OrdenLLVG> obtenerTodos();

    OrdenLLVG buscarPorId(Long id);

    OrdenLLVG crearOEditar(OrdenLLVG ordenLLVG);

    void eliminarPorId(Long id);
}
