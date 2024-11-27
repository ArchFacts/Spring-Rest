package Facts.Arch.ArchFacts.dto.mapper;

import Facts.Arch.ArchFacts.dto.servico.ServicoRequestDTO;
import Facts.Arch.ArchFacts.dto.servico.ServicoResponseDTO;
import Facts.Arch.ArchFacts.entities.Servico;
import Facts.Arch.ArchFacts.services.UsuarioLogadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServicoMapper {
    @Autowired
    private UsuarioLogadoService usuarioLogadoService;
    public Servico toEntity(ServicoRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        Servico servico = new Servico();
        servico.setNome(dto.getNome());
        servico.setDescricao(dto.getDescricao());
        servico.setNegocio(usuarioLogadoService.obterNegocio());

        return servico;
    }

    public ServicoResponseDTO toDto(Servico servico) {
        if (servico == null) {
            return  null;
        }
        ServicoResponseDTO dto = new ServicoResponseDTO();
        dto.setNome(servico.getNome());
        dto.setDescricao(servico.getDescricao());

        return dto;
    }
}
