import java.util.ArrayList;
import java.util.List;

public class RecorrenciaTransacaoDAO {
    private Connection connection;

    public RecorrenciaTransacaoDAO() {
        // Substitua "seu_url_jdbc_oracle", "nome_de_usuario" e "senha" com as informações do seu banco de dados Oracle
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            this.connection = DriverManager.getConnection("jdbc:oracle:thin:@seu_url_jdbc_oracle", "nome_de_usuario", "senha");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    // Operação de criação (Create)
    public void inserirRecorrenciaTransacao(RecorrenciaTransacao recorrenciaTransacao) {
        try (PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO recorrencia_transacao (conta_id, data_criacao, titulo, tipo, valor, status, dias_recorrencia, " +
                        "data_inativacao, quantidade_repeticao) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
            statement.setLong(1, recorrenciaTransacao.getContaId());
            statement.setDate(2, new java.sql.Date(recorrenciaTransacao.getDataCriacao().getTime()));
            statement.setString(3, recorrenciaTransacao.getTitulo());
            statement.setString(4, recorrenciaTransacao.getTipo());
            statement.setBigDecimal(5, recorrenciaTransacao.getValor());
            statement.setString(6, recorrenciaTransacao.getStatus());
            statement.setInt(7, recorrenciaTransacao.getDiasRecorrencia());
            statement.setDate(8, new java.sql.Date(recorrenciaTransacao.getDataInativacao().getTime()));
            statement.setInt(9, recorrenciaTransacao.getQuantidadeRepeticao());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Operação de leitura (Read)
    public RecorrenciaTransacao getRecorrenciaTransacaoPorId(Long id) {
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM recorrencia_transacao WHERE id = ?")) {
            statement.setLong(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return mapResultSetToRecorrenciaTransacao(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<RecorrenciaTransacao> getAllRecorrenciaTransacoes() {
        List<RecorrenciaTransacao> recorrenciaTransacoes = new ArrayList<>();

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM recorrencia_transacao")) {

            while (resultSet.next()) {
                recorrenciaTransacoes.add(mapResultSetToRecorrenciaTransacao(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return recorrenciaTransacoes;
    }

    // Operação de atualização (Update)
    public void atualizarRecorrenciaTransacao(RecorrenciaTransacao recorrenciaTransacao) {
        try (PreparedStatement statement = connection.prepareStatement(
                "UPDATE recorrencia_transacao SET conta_id = ?, data_criacao = ?, titulo = ?, tipo = ?, valor = ?, " +
                        "status = ?, dias_recorrencia = ?, data_inativacao = ?, quantidade_repeticao = ? WHERE id = ?")) {
            statement.setLong(1, recorrenciaTransacao.getContaId());
            statement.setDate(2, new java.sql.Date(recorrenciaTransacao.getDataCriacao().getTime()));
            statement.setString(3, recorrenciaTransacao.getTitulo());
            statement.setString(4, recorrenciaTransacao.getTipo());
            statement.setBigDecimal(5, recorrenciaTransacao.getValor());
            statement.setString(6, recorrenciaTransacao.getStatus());
            statement.setInt(7, recorrenciaTransacao.getDiasRecorrencia());
            statement.setDate(8, new java.sql.Date(recorrenciaTransacao.getDataInativacao().getTime()));
            statement.setInt(9, recorrenciaTransacao.getQuantidadeRepeticao());
            statement.setLong(10, recorrenciaTransacao.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método auxiliar para mapear um ResultSet para um objeto RecorrenciaTransacao
    private RecorrenciaTransacao mapResultSetToRecorrenciaTransacao(ResultSet resultSet) throws SQLException {
        return new RecorrenciaTransacao(
                resultSet.getLong("id"),
                resultSet.getLong("conta_id"),
                resultSet.getDate("data_criacao"),
                resultSet.getString("titulo"),
                resultSet.getString("tipo"),
                resultSet.getBigDecimal("valor"),
                resultSet.getString("status"),
                resultSet.getInt("dias_recorrencia"),
                resultSet.getDate("data_inativacao"),
                resultSet.getInt("quantidade_repeticao")
        );
    }

    // Operação de exclusão (Delete)
    public void deletarRecorrenciaTransacao(Long id) {
        try (PreparedStatement statement = connection.prepareStatement("DELETE FROM recorrencia_transacao WHERE id = ?")) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
