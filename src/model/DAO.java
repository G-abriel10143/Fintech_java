package model;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;

import secrets.Keys;
import utils.StringUtils;

public abstract class DAO<T extends Entity> {
	private final Class<T> type;
	
	protected DAO(Class<T> type) {
		this.type = type;
	}
	
	// TODO separar lógica
	protected Connection createConnection() throws SQLException {
		return DriverManager.getConnection(
			"jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL",
			Keys.DB_USER,
			Keys.DB_PASSWORD
		);
	}
	
	private T map(ResultSet rs) {
		T t;
		
		try {
			t = this.type.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			System.err.println("Não foi possível instanciar a classe " + this.type.toString());
			e.printStackTrace();
			
			return null;
		}
		
		for(Field field : this.type.getDeclaredFields()) {
			if(!field.isAnnotationPresent(ColumnName.class)) continue;
			
			try {
				
				field.setAccessible(true);
				field.set(
					t,
					rs.getObject(
						field.getAnnotation(ColumnName.class).value(),
						field.getType()
					)
				);
				
			} catch (SQLException e) {
				
				System.err.println(
					"Houve um erro ao recuperar o valor da coluna" +
					field.getAnnotation(ColumnName.class).value() +
					" da classe " +
					this.type.toString()
				);
				e.printStackTrace();
				
			} catch (IllegalAccessException e) {
				
				System.err.println(
					"Não foi possível atribuir um valor ao atributo " +
					field.getName() +
					" da classe " +
					this.type.toString()
				);
				e.printStackTrace();
				
			}
		}
		
		return t;
	}
	
	protected List<T> getAll(String query) {
		Connection connection = null;
		Statement statement = null;
		final List<T> list = new ArrayList<T>();
		
		try {
			connection = this.createConnection();
			statement = connection.createStatement();
			
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()) {
				T t = this.map(rs);
				
				if(t == null) continue;
				
				list.add(t);
			}
			
		} catch (SQLException e) {
			System.err.println("Ocorreu um erro ao criar um statement na classe " + e.getClass());
			e.printStackTrace();
			
			return null;
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}

	// Insert não implementado
	/*
	protected T insert(T t) throws CadastroException {
		if(t.getId() != null) {
			throw new CadastroException(this.type, "O objeto a ser cadastrado não pode possuir ID");
		}
		
		final List<Object> listaKeys = new LinkedList<Object>();
		final List<Object> listaValues = new LinkedList<Object>();
		
		Field idField = null;
		Connection connection = null;
		PreparedStatement statement = null;
		
		for(Field field : this.type.getDeclaredFields()) {
			if(field.isAnnotationPresent(Id.class)) {
				idField = field;
				break;
			}
		}
		
		if(idField == null) {
			throw new CadastroException(this.type, "A classe não possui um atributo referenciado por @Id");
		}
		
		listaKeys.add("ID");
		listaValues.add(idField.getAnnotation(Id.class).value() + ".NEXTVAL");
		
		for(Field field : this.type.getDeclaredFields()) {
			if(
				!field.isAnnotationPresent(ColumnName.class) ||
				field.isAnnotationPresent(Id.class)
			) {
				continue;				
			}
			
			field.setAccessible(true);
			
			try {
				Object valor = field.get(t);
				
//				if(valor != null && field.get(t) instanceof Date) {
//					valor = String.format(
//						"TO_DATE('%s', 'YYYY-MM-DD')",
//						new SimpleDateFormat("yyyy-MM-dd").format(valor)
//					);
//				}
				
				listaKeys.add(field.getAnnotation(ColumnName.class).value());
				listaValues.add(valor);
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		
		try {
			String query =
				"INSERT INTO " + this.type.getAnnotation(TableName.class).value() + " " +
				"(" + StringUtils.join(", ", listaKeys) + ") " +
				"VALUES " +
				"(" + this.getInsertWildCards() + ");";
			
			connection = this.createConnection();
			statement = connection.prepareStatement(query);
			
			this.setObjectsNoStatement(statement, listaValues);
			
			statement.executeUpdate();
			
			System.out.println(statement);
		} catch (SQLException e) {
			System.err.println("Ocorreu um erro ao criar um registro no banco");
			e.printStackTrace();
			
			return null;
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return t;
	}
	
	public String getInsertWildCards() {
		final int length = this.type.getDeclaredFields().length;
		List<Object> lista = new ArrayList<Object>(length);
		
		for(int i=0; i<length; i++) {
			lista.add("?");
		}
		
		return StringUtils.join(", ", lista);
	}
	
	private void setObjectsNoStatement(PreparedStatement statement, List<Object> listaValues) throws SQLException {
		final int length = this.type.getDeclaredFields().length;
		
		for(int i=1; i <= length; i++) {
			System.out.println(listaValues.get(i - 1).getClass());
			statement.setObject(i, listaValues.get(i - 1));
		}
	}*/
}
