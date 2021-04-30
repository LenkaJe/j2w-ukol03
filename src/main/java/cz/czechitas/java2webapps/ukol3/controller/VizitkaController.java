package cz.czechitas.java2webapps.ukol3.controller;

import cz.czechitas.java2webapps.ukol3.entity.Vizitka;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Kontroler obsluhující zobrazování vizitek.
 */
@Controller
public class VizitkaController {
    private final List<Vizitka> vizitky;

    public VizitkaController() {
        vizitky = new ArrayList<>();
        vizitky.add(new Vizitka("Věra Čermáková", "Czechitas z. s.", "Václavské náměstí 837/11", "Praha 11000", "vera@seznam.cz", "606355355", "www.czechitas.cz"));
        vizitky.add(new Vizitka("Jana Nováková", "Czechitas z. s.", "Václavské náměstí 837/11", "Praha 11000", null, "605466466", "www.czechitas.cz"));
        vizitky.add(new Vizitka("Hana Novotná", "Czechitas z. s.", "Hlavní náměstí 96/1", "Krnov 79401", "hana@seznam.cz", null, "www.czechitas.cz"));
        vizitky.add(new Vizitka("Dana Veselá", "Czechitas z. s.", "Hlavní náměstí 96/1", "Krnov 79401", "dana@seznam.cz", "776890987", "www.czechitas.cz"));
    }

    @GetMapping("/")
    public ModelAndView seznam() {
        ModelAndView result = new ModelAndView("seznam");
        result.addObject("vizitky", vizitky);
        return result;
    }

    @GetMapping("/detail")
    public ModelAndView detail(int id) {
        ModelAndView result = new ModelAndView("detail");
        result.addObject("vizitky", vizitky.get(id));
        return result;
    }

    @GetMapping("/nova")
    public String nova() {
        return "nova";
    }

    @PostMapping(value = "/nova", params = {"jmeno", "firma", "ulice", "obecPsc", "email", "telefon", "web"})
    public String nova(Vizitka vizitka) {
        vizitky.add(vizitka);
        return "redirect:/";
    }

    @PostMapping(value = "/detail", params = {"id"})
    public String smazat(int id) {
        vizitky.remove(id);
        return "redirect:/";
    }

}
