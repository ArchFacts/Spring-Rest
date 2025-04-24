package Facts.Arch.ArchFacts.services;

import Facts.Arch.ArchFacts.dto.parcela.ParcelaRequestDTO;
import Facts.Arch.ArchFacts.entities.Chamado;
import Facts.Arch.ArchFacts.entities.Parcela;
import Facts.Arch.ArchFacts.entities.Projeto;
import Facts.Arch.ArchFacts.exceptions.EntidadeNaoEncontradaException;
import Facts.Arch.ArchFacts.repositories.ChamadoRepository;
import Facts.Arch.ArchFacts.repositories.ParcelaRepository;
import Facts.Arch.ArchFacts.repositories.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ParcelaService {
    @Autowired
    private ParcelaRepository parcelaRepository;
    @Autowired
    private UsuarioLogadoService usuarioLogadoService;
    @Autowired
    private ChamadoRepository chamadoRepository;
    @Autowired
    private ProjetoRepository projetoRepository;
    public List<Parcela> definirParcelas(ParcelaRequestDTO dto, UUID idProjeto) {
        List<Parcela> parcelasCriadas = new ArrayList<>();
        LocalDateTime dataInicio = dto.getDataInicio();

        Optional<Chamado> possivelChamado = chamadoRepository.findById(dto.getIdChamado());
        Optional<Projeto> possivelProjeto = projetoRepository.findById(idProjeto);

        if (possivelProjeto.isEmpty()) {
            throw new EntidadeNaoEncontradaException("Não foi possível encontrar um projeto");
        }

        if (possivelChamado.isEmpty()) {
            throw new EntidadeNaoEncontradaException("Não foi possível encontrar um chamado");
        }

        Chamado chamado = possivelChamado.get();
        Projeto projeto = possivelProjeto.get();

        Double valorParcelas = dto.getValor() / dto.getQtdParcelas();

        for (int i = 1; i < dto.getQtdParcelas(); i++) {
            Parcela parcela = new Parcela();

            parcela.setIdParcela(null);
            parcela.setValor(valorParcelas);
            parcela.setDataInicio(dataInicio);
            parcela.setDataTermino(dataInicio.plusMonths(1));
            parcela.setStatus(dto.getStatus());
            parcela.setChamado(chamado);
            parcela.setProjeto(projeto);

            parcelaRepository.save(parcela);
            parcelasCriadas.add(parcela);

            dataInicio = dataInicio.plusMonths(1);
        }
        return parcelasCriadas;
    }
}
