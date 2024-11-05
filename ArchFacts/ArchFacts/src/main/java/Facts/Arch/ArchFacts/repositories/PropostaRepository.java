//package Facts.Arch.ArchFacts.repositories;
//
//import Facts.Arch.ArchFacts.entities.Negocio;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.UUID;
//@Repository
//public interface PropostaRepository extends JpaRepository<Negocio, UUID> {
//    List<Negocio> findByAtivado(Integer ativado);
//    @Query("SELECT AVG (n.avaliacao) FROM Negocio n WHERE n.idNegocio = :idNegocio AND n.avaliacao = 1")
//    Optional<Double> encontrarMediaAvaliacao(@Param("idNegocio") UUID id);
//
//    @Query
//    Optional<Integer> encontrarServicosPrestados
//}
