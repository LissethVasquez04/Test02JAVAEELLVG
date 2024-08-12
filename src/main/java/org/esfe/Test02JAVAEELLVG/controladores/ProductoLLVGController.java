package org.esfe.Test02JAVAEELLVG.controladores;

import org.esfe.Test02JAVAEELLVG.modelos.ProductoLLVG;
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
@RequestMapping("/productos") 
public class ProductoLLVGController {

    @Autowired
    private IProductoLLVGService productoService;

    @GetMapping
    public String index(Model model, @RequestParam("page") Optional<Integer> page,
                        @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);

        Page<ProductoLLVG> productoPage = productoService.buscarTodosPaginados(PageRequest.of(currentPage - 1, pageSize));
        model.addAttribute("productos", productoPage);

        int totalPages = productoPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        return "productos/index"; 
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("producto", new ProductoLLVG());
        return "productos/create"; 
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("producto") ProductoLLVG producto, RedirectAttributes redirectAttributes) {
        productoService.crearOEditar(producto);
        redirectAttributes.addFlashAttribute("msg", "Producto guardado exitosamente!");
        return "redirect:/productos";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        ProductoLLVG producto = productoService.buscarPorId(id);
        model.addAttribute("producto", producto);
        return "productos/edit"; 
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("producto") ProductoLLVG producto, RedirectAttributes redirectAttributes) {
        productoService.crearOEditar(producto);
        redirectAttributes.addFlashAttribute("msg", "Producto actualizado exitosamente!");
        return "redirect:/productos";
    }
    @GetMapping("/remove/{id}")
public String remove(@PathVariable Long id, Model model) {
    ProductoLLVG producto = productoService.buscarPorId(id);
    model.addAttribute("producto", producto);
    return "productos/delete"; 
}

    
@PostMapping("/delete/{id}") 
public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        productoService.eliminarPorId(id);
        redirectAttributes.addFlashAttribute("msg", "Producto eliminado exitosamente!");
        return "redirect:/productos";
    }
    
    @GetMapping("/details/{id}")
    public String details(@PathVariable Long id, Model model) {
        ProductoLLVG producto = productoService.buscarPorId(id);
        model.addAttribute("producto", producto);
        return "productos/details"; 
    }
}
