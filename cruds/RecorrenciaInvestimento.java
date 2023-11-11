import java.util.ArrayList;
import java.util.List;

public class RecorrenciaInvestimentoDAO {
    private Connection connection;

    public RecorrenciaInvestimentoDAO() {
        // Substitua "seu_url_jdbc_oracle", "nome_de_usuario" e "senha" com as informações do seu banco de dados Oracle
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            this.connection = DriverManager.getConnection("jdbc:oracle:thin:@seu_url_jdbc_oracle", "nome_de_usuario", "senha");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    // Operação de criação (Create)
    public void inserirRecorrenciaInvestimento(RecorrenciaInvestimento recorrenciaInvestimento) {
        try (PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO RECORRENCIA_INVESTIMENTO (conta_id, data_criacao, nome_titulo, tipo, valor_aplicacao, rendimento_anual, " +
                        "data_vencimento, emissor_titulo, corretora, data_inativacao, dias_recorrencia, status, quantidade_repeticao) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
            statement.setLong(1, recorrenciaInvestimento.getContaId());
            statement.setDate(2, new java.sql.Date(recorrenciaInvestimento.getDataCriacao().getTime()));
            statement.setString(3, recorrenciaInvestimento.getNomeTitulo());
            statement.setString(4, recorrenciaInvestimento.getTipo());
            statement.setBigDecimal(5, recorrenciaInvestimento.getValorAplicacao());
            statement.setBigDecimal(6, recorrenciaInvestimento.getRendimentoAnual());
            statement.setDate(7, new java.sql.Date(recorrenciaInvestimento.getDataVencimento().getTime()));
            statement.setString(8, recorrenciaInvestimento.getEmissorTitulo());
            statement.setString(9, recorrenciaInvestimento.getCorretora());
            statement.setDate(10, new java.sql.Date(recorrenciaInvestimento.getDataInativacao().getTime()));
            statement.setInt(11, recorrenciaInvestimento.getDiasRecorrencia());
            statement.setString(12, recorrenciaInvestimento.getStatus());
            statement.setLong(13, recorrenciaInvestimento.getQuantidadeRepeticao());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Operação de leitura (Read)
    public RecorrenciaInvestimento getRecorrenciaInvestimentoPorId(Long id) {
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM RECORRENCIA_INVESTIMENTO WHERE id = ?")) {
            statement.setLong(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return mapResultSetToRecorrenciaInvestimento(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<RecorrenciaInvestimento> getAllRecorrenciaInvestimentos() {
        List<RecorrenciaInvestimento> recorrenciaInvestimentos = new ArrayList<>();

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM RECORRENCIA_INVESTIMENTO")) {

            while (resultSet.next()) {
                recorrenciaInvestimentos.add(mapResultSetToRecorrenciaInvestimento(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return recorrenciaInvestimentos;
    }

    // Operação de atualização (Update)
    public void atualizarRecorrenciaInvestimento(RecorrenciaInvestimento recorrenciaInvestimento) {
        try (PreparedStatement statement = connection.prepareStatement(
                "UPDATE RECORRENCIA_INVESTIMENTO SET conta_id = ?, data_criacao = ?, nome_titulo = ?, tipo = ?, valor_aplicacao = ?, " +
                        "rendimento_anual = ?, data_vencimento = ?, emissor_titulo = ?, corretora = ?, " +
                        "data_inativacao = ?, dias_recorrencia = ?, status = ?, quantidade_repeticao = ? WHERE id = ?")) {
            statement.setLong(1, recorrenciaInvestimento.getContaId());
            statement.setDate(2, new java.sql.Date(recorrenciaInvestimento.getDataCriacao().getTime()));
            statement.setString(3, recorrenciaInvestimento.getNomeTitulo());
            statement.setString(4, recorrenciaInvestimento.getTipo());
            statement.setBigDecimal(5, recorrenciaInvestimento.getValorAplicacao());
            statement.setBigDecimal(6, recorrenciaInvestimento.getRendimentoAnual());
            statement.setDate(7, new java.sql.Date(recorrenciaInvestimento.getDataVencimento().getTime()));
            statement.setString(8, recorrenciaInvestimento.getEmissorTitulo());
            statement.setString(9, recorrenciaInvestimento.getCorretora());
            statement.setDate(10, new java.sql.Date(recorrenciaInvestimento.getDataInativacao().getTime()));
            statement.setInt(11, recorrenciaInvestimento.getDiasRecorrencia());
            statement.setString(12, recorrenciaInvestimento.getStatus());
            statement.setLong(13, recorrenciaInvestimento.getQuantidadeRepeticao());
            statement.setLong(14, recorrenciaInvestimento.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método auxiliar para mapear um ResultSet para um objeto RecorrenciaInvestimento
    private RecorrenciaInvestimento mapResultSetToRecorrenciaInvestimento(ResultSet resultSet) throws SQLException {
        return new RecorrenciaInvestimento(
                resultSet.getLong("id"),
                resultSet.getLong("conta_id"),
                resultSet.getDate("data_criacao"),
                resultSet.getString("nome_titulo"),
                resultSet.getString("tipo"),
                resultSet.getBigDecimal("valor_aplicacao"),
                resultSet.getBigDecimal("rendimento_anual"),
                resultSet.getDate("data_vencimento"),
                resultSet.getString("emissor_titulo"),
                resultSet.getString("corretora"),
                resultSet.getDate("data_inativacao"),
                resultSet.getInt("dias_recorrencia"),
                resultSet.getString("status"),
                resultSet.getLong("quantidade_repeticao")
        );
    }

    // Operação de exclusão (Delete)
    public void deletarRecorrenciaInvestimento(Long id) {
        try (PreparedStatement statement = connection.prepareStatement("DELETE FROM RECORRENCIA_INVESTIMENTO WHERE id = ?")) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
