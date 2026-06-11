package com.udec.unidad2mvc.controller;

import com.udec.unidad2mvc.model.User;
import com.udec.unidad2mvc.service.UserService;
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
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/usuarios")
    public String list(Model model) {
        model.addAttribute("usuarios", userService.findAll());
        return "usuarios/list";
    }

    @GetMapping("/usuarios/nuevo")
    public String createForm(Model model) {
        model.addAttribute("usuario", new User());
        model.addAttribute("title", "Registrar usuario");
        return "usuarios/form";
    }

    @PostMapping("/usuarios/guardar")
    public String save(@Valid @ModelAttribute("usuario") User user,
                       BindingResult result,
                       Model model,
                       RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            model.addAttribute("title", user.getId() == null ? "Registrar usuario" : "Editar usuario");
            return "usuarios/form";
        }
        userService.save(user);
        redirectAttributes.addFlashAttribute("success", "Usuario guardado correctamente");
        return "redirect:/usuarios";
    }

    @GetMapping("/usuarios/editar/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("usuario", userService.findById(id));
        model.addAttribute("title", "Editar usuario");
        return "usuarios/form";
    }

    @GetMapping("/usuarios/eliminar/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        userService.deleteById(id);
        redirectAttributes.addFlashAttribute("success", "Usuario eliminado correctamente");
        return "redirect:/usuarios";
    }
}
