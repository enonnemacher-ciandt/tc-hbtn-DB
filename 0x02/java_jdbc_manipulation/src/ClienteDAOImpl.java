import java.sql.*;

public class ClienteDAOImpl implements ClienteDAO {

    @Override
    public Connection connect(String urlConexao) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(urlConexao);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }

    @Override
    public void createTable(String urlConexao) {
        StringBuffer sql = new StringBuffer();
        sql.append("CREATE TABLE IF NOT EXISTS cliente (");
        sql.append("id integer PRIMARY KEY , ");
        sql.append("nome text NOT NULL, ");
        sql.append("idade integer, ");
        sql.append("cpf text NOT NULL, ");
        sql.append("rg text ");
        sql.append(")");
        try (Connection conn = DriverManager.getConnection(urlConexao);
             Statement statement = conn.createStatement()) {
            statement.execute(sql.toString());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void insert(String url_conexao, Cliente cliente) {
        String sql = "INSERT INTO cliente(nome,idade, cpf, rg) VALUES(?,?,?,?)";

        try (Connection connection = this.connect(url_conexao);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setInt(2, cliente.getIdade());
            preparedStatement.setString(3, cliente.getCpf());
            preparedStatement.setString(4, cliente.getRg());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void selectAll(String urlConexao) {
        String sql = "SELECT id, nome, idade, cpf, rg FROM cliente";

        try (Connection connection = this.connect(urlConexao);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id")
                        + "\t" + resultSet.getString("nome")
                        + "\t" + resultSet.getInt("idade")
                        + "\t" + resultSet.getString("cpf")
                        + "\t" + resultSet.getString("rg"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(String urlConexao, int id, String name, Integer idade) {
        String sql = "UPDATE cliente SET nome = ? ," + "idade = ? " + "WHERE id = ?";

        try (Connection connection = this.connect(urlConexao);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, idade);
            preparedStatement.setInt(3, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(String urlConexao, int id) {
        String sql = "DELETE FROM cliente WHERE id = ?";

        try (Connection connection = this.connect(urlConexao);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
