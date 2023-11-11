import java.util.ArrayList;
import java.util.List;

public class TransacaoDAO {
    private Connection connection;

    public TransacaoDAO() {
        // Substitua "seu_url_jdbc_oracle", "nome_de_usuario" e "senha" com as informações do seu banco de dados Oracle
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            this.connection = DriverManager.getConnection("jdbc:oracle:thin:@seu_url_jdbc_oracle", "nome_de_usuario", "senha");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    // Operação de criação (Create)
    public void inserirTransacao(Transacao transacao) {
        try (PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO transacao (conta_id, data_criacao, titulo, tipo, valor, transacao_estornada_id, data_inativacao) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?)")) {
            statement.setLong(1, transacao.getContaId());
            statement.setDate(2, new java.sql.Date(transacao.getDataCriacao().getTime()));
            statement.setString(3, transacao.getTitulo());
            statement.setString(4, transacao.getTipo());
            statement.setBigDecimal(5, transacao.getValor());
            statement.setLong(6, transacao.getTransacaoEstornadaId());
            statement.setDate(7, new java.sql.Date(transacao.getDataInativacao().getTime()));

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Operação de leitura (Read)
    public Transacao getTransacaoPorId(Long id) {
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM transacao WHERE id = ?")) {
            statement.setLong(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return mapResultSetToTransacao(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Transacao> getAllTransacoes() {
        List<Transacao> transacoes = new ArrayList<>();

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM transacao")) {

            while (resultSet.next()) {
                transacoes.add(mapResultSetToTransacao(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return transacoes;
    }

    // Operação de atualização (Update)
    public void atualizarTransacao(Transacao transacao) {
        try (PreparedStatement statement = connection.prepareStatement(
                "UPDATE transacao SET conta_id = ?, data_criacao = ?, titulo = ?, tipo = ?, valor = ?, " +
                        "transacao_estornada_id = ?, data_inativacao = ? WHERE id = ?")) {
            statement.setLong(1, transacao.getContaId());
            statement.setDate(2, new java.sql.Date(transacao.getDataCriacao().getTime()));
            statement.setString(3, transacao.getTitulo());
            statement.setString(4, transacao.getTipo());
            statement.setBigDecimal(5, transacao.getValor());
            statement.setLong(6, transacao.getTransacaoEstornadaId());
            statement.setDate(7, new java.sql.Date(transacao.getDataInativacao().getTime()));
            statement.setLong(8, transacao.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método auxiliar para mapear um ResultSet para um objeto Transacao
    private Transacao mapResultSetToTransacao(ResultSet resultSet) throws SQLException {
        return new Transacao(
                resultSet.getLong("id"),
                resultSet.getLong("conta_id"),
                resultSet.getDate("data_criacao"),
                resultSet.getString("titulo"),
                resultSet.getString("tipo"),
                resultSet.getBigDecimal("valor"),
                resultSet.getLong("transacao_estornada_id"),
                resultSet.getDate("data_inativacao")
        );
    }

    // Operação de exclusão (Delete)
    public void deletarTransacao(Long id) {
        try (PreparedStatement statement = connection.prepareStatement("DELETE FROM transacao WHERE id = ?")) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
public class Transacao {
    
}
