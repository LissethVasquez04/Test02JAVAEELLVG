package org.esfe.Test02JAVAEELLVG.controladores;

import org.esfe.Test02JAVAEELLVG.modelos.DetalleOrdenLLVG;
import org.esfe.Test02JAVAEELLVG.modelos.OrdenLLVG;
import org.esfe.Test02JAVAEELLVG.modelos.ProductoLLVG;
import org.esfe.Test02JAVAEELLVG.servicios.interfaces.IDetalleOrdenLLVGService;
import org.esfe.Test02JAVAEELLVG.servicios.interfaces.IOrdenLLVGService;
import org.esfe.Test02JAVAEELLVG.servicios.interfaces.IProductoLLVGService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/detallesOrden") 
public class DetalleOrdenLLVGController {

    @Autowired
    private IDetalleOrdenLLVGService detalleOrdenService;

    @Autowired 
    private IProductoLLVGService productoService; 

    @Autowired
    private IOrdenLLVGService ordenService; 

    @GetMapping
    public String index(Model model, @RequestParam("page") Optional<Integer> page,
                        @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);
    
        Page<DetalleOrdenLLVG> detalleOrdenPage = detalleOrdenService.buscarTodosPaginados(PageRequest.of(currentPage - 1, pageSize));
        model.addAttribute("detallesOrden", detalleOrdenPage);
    
        int totalPages = detalleOrdenPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
    
        return "detallesOrden/index"; 
    }
  
    @GetMapping("/create")
public String create(Model model) {
    model.addAttribute("detalleOrden", new DetalleOrdenLLVG());

    List<ProductoLLVG> productos = productoService.obtenerTodos();
    List<OrdenLLVG> ordenes = ordenService.obtenerTodos();

    model.addAttribute("productos", productos);
    model.addAttribute("ordenes", ordenes);

    return "detallesOrden/create"; 
}



    @PostMapping("/save")
    public String save(@ModelAttribute("detalleOrden") DetalleOrdenLLVG detalleOrden, RedirectAttributes redirectAttributes) {
        detalleOrdenService.crearOEditar(detalleOrden);
        redirectAttributes.addFlashAttribute("msg", "Detalle de orden guardado exitosamente!");
        return "redirect:/detallesOrden"; 
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        DetalleOrdenLLVG detalleOrden = detalleOrdenService.buscarPorId(id);
        model.addAttribute("detalleOrden", detalleOrden);
            List<ProductoLLVG> productos = productoService.obtenerTodos();
            List<OrdenLLVG> ordenes = ordenService.obtenerTodos();

                model.addAttribute("productos", productos);
            model.addAttribute("ordenes", ordenes);

            return "detallesOrden/edit"; 
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("detalleOrden") DetalleOrdenLLVG detalleOrden, RedirectAttributes redirectAttributes) {
        detalleOrdenService.crearOEditar(detalleOrden);
        redirectAttributes.addFlashAttribute("msg", "Detalle de orden actualizado exitosamente!");
        return "redirect:/detallesOrden"; 
    }

    @GetMapping("/remove/{id}")
public String remove(@PathVariable Long id, Model model) {
    DetalleOrdenLLVG detalleOrden = detalleOrdenService.buscarPorId(id);
    model.addAttribute("detalleOrden", detalleOrden);
    return "detallesOrden/delete"; 
}



    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        detalleOrdenService.eliminarPorId(id);
        redirectAttributes.addFlashAttribute("msg", "Detalle de orden eliminado exitosamente!");
        return "redirect:/detallesOrden"; 
    }
    
    @GetMapping("/details/{id}")
    public String details(@PathVariable Long id, Model model) {
        DetalleOrdenLLVG detalleOrden = detalleOrdenService.buscarPorId(id);
        model.addAttribute("detalleOrden", detalleOrden);
        return "detallesOrden/details"; 
    }
}
