package org.esfe.Test02JAVAEELLVG.repositorios;

import org.esfe.Test02JAVAEELLVG.modelos.ProductoLLVG;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductoLLVGRepository extends JpaRepository<ProductoLLVG, Long> {
}