package org.esfe.Test02JAVAEELLVG.modelos;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "DetalleOrdenLLVG")
public class DetalleOrdenLLVG {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "La cantidad es requerida")
    private Integer cantidadLLVG;

    @NotNull(message = "El precio es requerido")
    private Double precioLLVG;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private ProductoLLVG productoLLVG;

    @ManyToOne
    @JoinColumn(name = "orden_id")
    private OrdenLLVG ordenLLVG;

    public Long getId() {
        return id;
    }

    public Integer getCantidadLLVG() {
        return cantidadLLVG;
    }

    public Double getPrecioLLVG() {
        return precioLLVG;
    }

    public ProductoLLVG getProductoLLVG() {
        return productoLLVG;
    }

    public OrdenLLVG getOrdenLLVG() {
        return ordenLLVG;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCantidadLLVG(Integer cantidadLLVG) {
        this.cantidadLLVG = cantidadLLVG;
    }

    public void setPrecioLLVG(Double precioLLVG) {
        this.precioLLVG = precioLLVG;
    }

    public void setProductoLLVG(ProductoLLVG productoLLVG) {
        this.productoLLVG = productoLLVG;
    }

    public void setOrdenLLVG(OrdenLLVG ordenLLVG) {
        this.ordenLLVG = ordenLLVG;
    }
}
