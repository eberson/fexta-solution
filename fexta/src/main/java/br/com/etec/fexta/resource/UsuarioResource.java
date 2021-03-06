package br.com.etec.fexta.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.etec.fexta.dto.UsuarioDTO;
import br.com.etec.fexta.service.UsuarioService;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/usuario")
public class UsuarioResource {

    @Autowired
    private UsuarioService service;

    @RequestMapping(path = "/todos",
                    method = RequestMethod.GET,
                    produces = "application/json")
    public List<UsuarioDTO> searchAll() {
        return service.all();
    }

    @RequestMapping(path = "/find/{numero}",
                    method = RequestMethod.GET,
                    produces = "application/json")
    public UsuarioDTO searchOne(@PathVariable String numero) {
        return service.one(numero);
    }

    @RequestMapping(path = "/salva",
                    method = RequestMethod.POST,
                    consumes = "application/json",
                    produces = "application/json")
    public UsuarioDTO save(@RequestBody UsuarioDTO dto) {
        return service.save(dto);
    }

    @RequestMapping(path = "/exclui",
                    method = RequestMethod.POST,
                    consumes = "application/json",
                    produces = "application/json")
    public String remove(@RequestBody UsuarioDTO dto) {
        service.remove(dto);
        return String.format("Usu�rio, %s, removido com sucesso", dto.getNome());
    }
}
