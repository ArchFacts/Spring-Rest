package Facts.Arch.ArchFacts.dto.mapper;

import Facts.Arch.ArchFacts.dto.negocio.NegocioRequestDTO;
import Facts.Arch.ArchFacts.dto.negocio.NegocioResponseDTO;
import Facts.Arch.ArchFacts.entities.Negocio;
import Facts.Arch.ArchFacts.exceptions.DocumentoInvalidoException;
import Facts.Arch.ArchFacts.services.NegocioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class NegocioMapper {
    @Autowired
    private NegocioService negocioService;
    public Negocio toEntity(NegocioRequestDTO dtoRequest) {
        if (dtoRequest == null) {
            return null;
        }
        Negocio negocio = new Negocio();
        negocio.setNome(dtoRequest.getNome());

        Optional<String> possivelDocumento = negocioService.identificarTipoDocumento(dtoRequest.getCpfOrCnpj()).describeConstable();

        if (possivelDocumento.isEmpty()) {
            throw new DocumentoInvalidoException("Não foi encontrado nenhum documento");
        } else {
            String documento = possivelDocumento.get();

            if (documento.length() == 11) {
                negocio.setCpf(documento);
            } else {
                negocio.setCnpj(documento);
            }
        }

        negocio.setCep(dtoRequest.getCep());
        return negocio;
    }
    public static NegocioResponseDTO toDto(Negocio negocio) {
        if (negocio == null) {
            return null;
        }

        NegocioResponseDTO dto = new NegocioResponseDTO();
        dto.setNomeEmpresa(negocio.getNome());
        dto.setCodigo(negocio.getCodigo());

        if (negocio.getCnpj() == null) {
            dto.setCpf(negocio.getCpf());
        }

        if (negocio.getCpf() == null) {
            dto .setCnpj(negocio.getCnpj());
        }

        dto.setDataRegistro(dto.getDataRegistro());

        return dto;
    }
}
