package Facts.Arch.ArchFacts.dto.mapper;

import Facts.Arch.ArchFacts.dto.negocio.NegocioRequestDTO;
import Facts.Arch.ArchFacts.dto.negocio.NegocioResponseDTO;
import Facts.Arch.ArchFacts.entities.Negocio;
import Facts.Arch.ArchFacts.services.NegocioService;
import org.springframework.beans.factory.annotation.Autowired;

public class NegocioMapper {
    @Autowired
    private static NegocioService negocioService;
    public static Negocio toEntity(NegocioRequestDTO dtoRequest) {
        if (dtoRequest == null) {
            return null;
        }
        Negocio negocio = new Negocio();
        negocio.setNome(dtoRequest.getNome());

        String documento = negocioService.identificarTipoDocumento(dtoRequest.getCpforCnpj());

        if (documento.equals("CPF")) {
            negocio.setCpf(documento);
        } else {
            negocio.setCnpj(documento);
        }

        negocio.setCep(dtoRequest.getCep());
        return negocio;
    }
    public static NegocioResponseDTO toDto(Negocio negocio) {
        if (negocio == null) {
            return null;
        }

        NegocioResponseDTO dto = new NegocioResponseDTO();
        dto.setNome(negocio.getNome());
        dto.setCodigo(negocio.getCodigo());

        if (negocio.getCnpj() == null) {
            dto.setCnpj(negocio.getCnpj());
        }

        if (negocio.getCpf() == null) {
            dto .setCpf(negocio.getCpf());
        }

        dto.setDataRegistro(dto.getDataRegistro());

        return dto;
    }
}
