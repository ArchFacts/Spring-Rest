package Facts.Arch.ArchFacts.System;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

@Component
public class filtroLogs extends SystemLog implements Filter {

    ListaEstatica<SystemLog> listaLogs = new ListaEstatica<>(10);
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        Long comeco = System.currentTimeMillis();

        try {
            chain.doFilter(request, response);
        } catch (Exception exception) {
            throw exception;
        } finally {
            Long fim = System.currentTimeMillis();
            Long tempoResposta = fim - comeco;

            String usuario = (httpRequest.getUserPrincipal() != null) ? httpRequest.getUserPrincipal().getName() : "Não logado";

            SystemLog systemLog = new SystemLog(
                    usuario,
                    httpRequest.getMethod(),
                    httpRequest.getRequestURI(),
                    String.valueOf(httpResponse.getStatus()),
                    tempoResposta + "ms"
            );

            listaLogs.adiciona(systemLog);
            gravarArquivoCsv(systemLog, gerarNomeArquivo());
        }
    }

    private String gerarNomeArquivo() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        String dataHoraAtual = LocalDateTime.now().format(formatter);
        return "log_" + dataHoraAtual + ".csv";
    }

    private void gravarArquivoCsv (SystemLog systemLog, String nomeArq) {
        FileWriter arq = null;
        Formatter builder = null;

        try {
            arq = new FileWriter(nomeArq, true);
            builder = new Formatter(arq);

            builder.format("Usuário: %s - Método: %s - URI: %s - Status: %s - Tempo de Resposta: %s\n",
                    systemLog.getUsuario(),
                    systemLog.getMetodo(),
                    systemLog.getUri(),
                    systemLog.getStatusCode(),
                    systemLog.getTempoResposta());

        } catch (IOException error) {
            System.out.println("Erro ao abrir o arquivo");
            error.printStackTrace();
            System.exit(1);
        } finally {
            if (builder != null) {
                builder. close();
                try {
                    arq.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}

