package co.feriaDeProyectos.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import co.feriaDeProyectos.model.Proyecto;

import co.feriaDeProyectos.util.ConexionMySQL;

public class ProyectoDaoMySQL  {

	private ConexionMySQL c;
	private static final String INSERT_PROYECTO_SQL = "INSERT INTO proyecto (nombre,resumen,video,tipo,categoria,asignatura,evento) VALUES (?,?,?,?,?,?,?);";
	// private static final String DELETE_PROYECTO_SQL = "DELETE FROM proyecto WHERE
	// id = ?;";
	private static final String UPDATE_PROYECTO_SQL = "UPDATE proyecto SET nombre=?,resumen=?,video=?,tipo=?,categoria=?,asignatura=?,evento=?  WHERE id = ?;";
	private static final String SELECT_PROYECTO_BY_ID = "SELECT * FROM proyecto WHERE id=?;";
	private static final String SELECT_ALL_PROYECTOS = "SELECT * FROM proyecto;";

	public ProyectoDaoMySQL() {
		this.c = ConexionMySQL.getConexion();
	}


	public void insert(Proyecto proyecto) throws SQLException {
		try {
			c.setPreparedStatement(INSERT_PROYECTO_SQL);
			PreparedStatement pr = c.getPreparedStatement();
			pr.setString(1, proyecto.getNombre());
			pr.setString(2, proyecto.getResumen());
			pr.setString(3, proyecto.getVideo());
			int idTipo = proyecto.getTipo();
			pr.setInt(4, idTipo);
			int idCat = proyecto.getCat();
			pr.setInt(5, idCat);
			String codAsignatura = proyecto.getAsig();
			pr.setString(6, codAsignatura);
			int idEvento = proyecto.getEvento();
			pr.setInt(7, idEvento);
			c.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public Proyecto select(int id) {
		Proyecto proyecto = null;
		try{
			PreparedStatement preparedStatement= (PreparedStatement) c.setPreparedStatement(SELECT_PROYECTO_BY_ID);
			preparedStatement.setInt(1,id);
			ResultSet rs = c.query();
			while(rs.next()) {
				
				String nombre = rs.getString("nombre");
				String resumen = rs.getString("resumen");
				String video = rs.getString("video");
				int tipo = rs.getInt("tipo");
				int cat = rs.getInt("cat");
				String asig = rs.getString("asig");
				int evento = rs.getInt("evento");

				proyecto=new Proyecto(id, nombre, resumen, video, tipo, cat, asig, evento);
			
			}
			}
		catch(SQLException e){}
		return proyecto;
	}


	public List<Proyecto> selectAll() {
		List<Proyecto> proyectos = new ArrayList<>();
		try {
			PreparedStatement preparedStatement = (PreparedStatement) c.setPreparedStatement(SELECT_ALL_PROYECTOS);
			ResultSet rs = c.query();
			while (rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String resumen = rs.getString("resumen");
				String video = rs.getString("video");
				int tipo = rs.getInt("tipo");
				int cat = rs.getInt("cat");
				String asig = rs.getString("asig");
				int evento = rs.getInt("evento");

				proyectos.add(new Proyecto(id, nombre, resumen, video, tipo, cat, asig, evento));
			}
		} catch (SQLException e) {
		}
		return proyectos;
	}


	public void delete(int id) throws SQLException {
		// TODO Auto-generated method stub

	}

	
	public void update(Proyecto proyecto) throws SQLException {
		try {
			c.setPreparedStatement(UPDATE_PROYECTO_SQL);
			PreparedStatement pr = c.getPreparedStatement();

			pr.setString(1, proyecto.getNombre());
			pr.setString(2, proyecto.getResumen());
			pr.setString(3, proyecto.getVideo());
			int idTipo = proyecto.getTipo();
			pr.setInt(4, idTipo);
			int idCat = proyecto.getCat();
			pr.setInt(5, idCat);
			String codAsignatura = proyecto.getAsig();
			pr.setString(6, codAsignatura);
			int idEvento = proyecto.getEvento();
			pr.setInt(7, idEvento);
			pr.setInt(8, proyecto.getId());
			c.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
