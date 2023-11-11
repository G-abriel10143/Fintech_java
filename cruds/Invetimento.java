import java.util.ArrayList;
import java.util.List;

public class InvestimentoDAO {
    private Connection connection;

    public InvestimentoDAO() {
        // Substitua "seu_url_jdbc_oracle", "nome_de_usuario" e "senha" com as informações do seu banco de dados Oracle
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            this.connection = DriverManager.getConnection("jdbc:oracle:thin:@seu_url_jdbc_oracle", "nome_de_usuario", "senha");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    // Operação de criação (Create)
    public void inserirInvestimento(Investimento investimento) {
        try (PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO investimento (conta_id, data_criacao, nome_titulo, tipo, valor_aplicacao, rendimento_anual, " +
                        "data_vencimento, emissor_titulo, corretora, data_resgate, valor_resgate, data_inativacao) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
            statement.setLong(1, investimento.getContaId());
            statement.setDate(2, new java.sql.Date(investimento.getDataCriacao().getTime()));
            statement.setString(3, investimento.getNomeTitulo());
            statement.setString(4, investimento.getTipo());
            statement.setBigDecimal(5, investimento.getValorAplicacao());
            statement.setBigDecimal(6, investimento.getRendimentoAnual());
            statement.setDate(7, new java.sql.Date(investimento.getDataVencimento().getTime()));
            statement.setString(8, investimento.getEmissorTitulo());
            statement.setString(9, investimento.getCorretora());
            statement.setDate(10, new java.sql.Date(investimento.getDataResgate().getTime()));
            statement.setBigDecimal(11, investimento.getValorResgate());
            statement.setDate(12, new java.sql.Date(investimento.getDataInativacao().getTime()));

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Operação de leitura (Read)
    public Investimento getInvestimentoPorId(Long id) {
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM investimento WHERE id = ?")) {
            statement.setLong(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return mapResultSetToInvestimento(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Investimento> getAllInvestimentos() {
        List<Investimento> investimentos = new ArrayList<>();

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM investimento")) {

            while (resultSet.next()) {
                investimentos.add(mapResultSetToInvestimento(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return investimentos;
    }

    // Operação de atualização (Update)
    public void atualizarInvestimento(Investimento investimento) {
        try (PreparedStatement statement = connection.prepareStatement(
                "UPDATE investimento SET conta_id = ?, data_criacao = ?, nome_titulo = ?, tipo = ?, valor_aplicacao = ?, " +
                        "rendimento_anual = ?, data_vencimento = ?, emissor_titulo = ?, corretora = ?, " +
                        "data_resgate = ?, valor_resgate = ?, data_inativacao = ? WHERE id = ?")) {
            statement.setLong(1, investimento.getContaId());
            statement.setDate(2, new java.sql.Date(investimento.getDataCriacao().getTime()));
            statement.setString(3, investimento.getNomeTitulo());
            statement.setString(4, investimento.getTipo());
            statement.setBigDecimal(5, investimento.getValorAplicacao());
            statement.setBigDecimal(6, investimento.getRendimentoAnual());
            statement.setDate(7, new java.sql.Date(investimento.getDataVencimento().getTime()));
            statement.setString(8, investimento.getEmissorTitulo());
            statement.setString(9, investimento.getCorretora());
            statement.setDate(10, new java.sql.Date(investimento.getDataResgate().getTime()));
            statement.setBigDecimal(11, investimento.getValorResgate());
            statement.setDate(12, new java.sql.Date(investimento.getDataInativacao().getTime()));
            statement.setLong(13, investimento.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método auxiliar para mapear um ResultSet para um objeto Investimento
    private Investimento mapResultSetToInvestimento(ResultSet resultSet) throws SQLException {
        return new Investimento(
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
                resultSet.getDate("data_resgate"),
                resultSet.getBigDecimal("valor_resgate"),
                resultSet.getDate("data_inativacao")
        );
    }

    // Operação de exclusão (Delete)
    public void deletarInvestimento(Long id) {
        try (PreparedStatement statement = connection.prepareStatement("DELETE FROM investimento WHERE id = ?")) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
