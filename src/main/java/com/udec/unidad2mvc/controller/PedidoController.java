package com.udec.unidad2mvc.controller;

import com.udec.unidad2mvc.model.Pedido;
import com.udec.unidad2mvc.service.PedidoService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PedidoController {
    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping("/pedidos")
    public String list(Model model) {
        model.addAttribute("pedidos", pedidoService.findAll());
        return "pedidos/list";
    }

    @GetMapping("/pedidos/nuevo")
    public String createForm(Model model) {
        model.addAttribute("pedido", new Pedido());
        model.addAttribute("title", "Registrar pedido");
        return "pedidos/form";
    }

    @PostMapping("/pedidos/guardar")
    public String save(@Valid @ModelAttribute("pedido") Pedido pedido,
                       BindingResult result,
                       Model model,
                       RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            model.addAttribute("title", pedido.getId() == null ? "Registrar pedido" : "Editar pedido");
            return "pedidos/form";
        }
        pedidoService.save(pedido);
        redirectAttributes.addFlashAttribute("success", "Pedido guardado correctamente");
        return "redirect:/pedidos";
    }

    @GetMapping("/pedidos/editar/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("pedido", pedidoService.findById(id));
        model.addAttribute("title", "Editar pedido");
        return "pedidos/form";
    }

    @GetMapping("/pedidos/eliminar/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        pedidoService.deleteById(id);
        redirectAttributes.addFlashAttribute("success", "Pedido eliminado correctamente");
        return "redirect:/pedidos";
    }
}
