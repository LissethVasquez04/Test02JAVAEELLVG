package org.esfe.Test02JAVAEELLVG.modelos;


import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "OrdenLLVG")
public class OrdenLLVG {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaLLVG;

    @OneToMany(mappedBy = "ordenLLVG", cascade = CascadeType.ALL)
    private List<DetalleOrdenLLVG> detallesOrdenLLVG;

     
    public Long getId() {
        return id;
    }

    public LocalDate getFechaLLVG() {
        return fechaLLVG;
    }

    public List<DetalleOrdenLLVG> getDetalleOrdenLLVG() {
        return detallesOrdenLLVG;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFechaLLVG(LocalDate fechaLLVG) {
        this.fechaLLVG = fechaLLVG;
    }

    public void setDetallesOrdenLLVG(List<DetalleOrdenLLVG> detallesOrdenLLVG) {
        this.detallesOrdenLLVG = detallesOrdenLLVG;
    }
}
