package Facts.Arch.ArchFacts.dto.mapper;

import Facts.Arch.ArchFacts.dto.empresasParceiras.EmpresasParceirasResponseDTO;
import Facts.Arch.ArchFacts.entities.Negocio;

public class EmpresasParceirasMapper {
    public EmpresasParceirasResponseDTO toDto (Negocio negocio) {
        if (negocio == null) {
            return null;
        }

        EmpresasParceirasResponseDTO dto = new EmpresasParceirasResponseDTO();
        dto.setNomeEmpresa(negocio.getNome());
        dto.setDataRegistro(negocio.getDataRegistro());
        dto.setAvaliacao(negocio.getAvaliacao());

        return dto;
    }
}
