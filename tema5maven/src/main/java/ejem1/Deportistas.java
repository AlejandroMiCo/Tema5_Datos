package ejem1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/deportistas")
public class Deportistas {
    private Connection mySQLConexion;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Deportista> todos() {
        ArrayList<Deportista> deportistas = new ArrayList<>();

        abrirConexion("ad_tema6", "localhost", "root", "");
        try {
            String sql = "SELECT * FROM deportistas;";
            System.out.println(sql);
            mySQLConexion.createStatement().execute(sql);
            ResultSet resultados = mySQLConexion.createStatement().executeQuery(sql);
            while (resultados.next()) {
                deportistas.add(new Deportista(resultados.getInt("id"), resultados.getString("nombre"),
                        resultados.getString("deporte"), resultados.getBoolean("activo"),
                        resultados.getString("genero")));
            }
        } catch (SQLException e) {
            System.out.println("Error al ejecutar el comando SQL: " + e.getLocalizedMessage());
        }
        cerrarConexion();
        return deportistas;
    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Deportista buscarJugador(@PathParam("id") int id) {
        abrirConexion("ad_tema6", "localhost", "root", "");
        try {
            String sql = "SELECT * FROM deportistas where id = " + id;
            System.out.println(sql);
            mySQLConexion.createStatement().execute(sql);
            ResultSet resultados = mySQLConexion.createStatement().executeQuery(sql);
            if (resultados.next()) {
                return new Deportista(resultados.getInt("id"), resultados.getString("nombre"),
                        resultados.getString("deporte"), resultados.getBoolean("activo"),
                        resultados.getString("genero"));
            }
        } catch (SQLException e) {
            System.out.println("Error al ejecutar el comando SQL: " + e.getLocalizedMessage());
        }
        cerrarConexion();
        return null;
    }

    @Path("7deporte/{nombreDeporte}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Deportista> buscarJugadoresPorDeporte(@PathParam("nombreDeporte") String nombreDeporte) {
        abrirConexion("ad_tema6", "localhost", "root", "");
        ArrayList<Deportista> deportistas = new ArrayList<>();
        try {
            String sql = "SELECT * FROM deportistas where deporte = '" + nombreDeporte + "'";
            System.out.println(sql);
            mySQLConexion.createStatement().execute(sql);
            ResultSet resultados = mySQLConexion.createStatement().executeQuery(sql);
            while (resultados.next()) {
                deportistas.add(new Deportista(resultados.getInt("id"), resultados.getString("nombre"),
                        resultados.getString("deporte"), resultados.getBoolean("activo"),
                        resultados.getString("genero")));
            }
        } catch (SQLException e) {
            System.out.println("Error al ejecutar el comando SQL: " + e.getLocalizedMessage());
        }
        cerrarConexion();
        return deportistas;
    }

    @Path("/activos")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Deportista> buscarActivos() {
        abrirConexion("ad_tema6", "localhost", "root", "");
        ArrayList<Deportista> deportistas = new ArrayList<>();
        try {
            String sql = "SELECT * FROM deportistas where activo = 1";
            System.out.println(sql);
            mySQLConexion.createStatement().execute(sql);
            ResultSet resultados = mySQLConexion.createStatement().executeQuery(sql);
            while (resultados.next()) {
                deportistas.add(new Deportista(resultados.getInt("id"), resultados.getString("nombre"),
                        resultados.getString("deporte"), resultados.getBoolean("activo"),
                        resultados.getString("genero")));
            }
        } catch (SQLException e) {
            System.out.println("Error al ejecutar el comando SQL: " + e.getLocalizedMessage());
        }
        cerrarConexion();
        return deportistas;
    }

    @Path("/retirados")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Deportista> buscarRetirados() {
        abrirConexion("ad_tema6", "localhost", "root", "");
        ArrayList<Deportista> deportistas = new ArrayList<>();
        try {
            String sql = "SELECT * FROM deportistas where activo = 0";
            System.out.println(sql);
            mySQLConexion.createStatement().execute(sql);
            ResultSet resultados = mySQLConexion.createStatement().executeQuery(sql);
            while (resultados.next()) {
                deportistas.add(new Deportista(resultados.getInt("id"), resultados.getString("nombre"),
                        resultados.getString("deporte"), resultados.getBoolean("activo"),
                        resultados.getString("genero")));
            }
        } catch (SQLException e) {
            System.out.println("Error al ejecutar el comando SQL: " + e.getLocalizedMessage());
        }
        cerrarConexion();
        return deportistas;
    }

    @Path("/masculinos")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Deportista> masculinos() {
        abrirConexion("ad_tema6", "localhost", "root", "");
        ArrayList<Deportista> deportistas = new ArrayList<>();
        try {
            String sql = "SELECT * FROM deportistas where genero = 'masculino'";
            System.out.println(sql);
            mySQLConexion.createStatement().execute(sql);
            ResultSet resultados = mySQLConexion.createStatement().executeQuery(sql);
            while (resultados.next()) {
                deportistas.add(new Deportista(resultados.getInt("id"), resultados.getString("nombre"),
                        resultados.getString("deporte"), resultados.getBoolean("activo"),
                        resultados.getString("genero")));
            }
        } catch (SQLException e) {
            System.out.println("Error al ejecutar el comando SQL: " + e.getLocalizedMessage());
        }
        cerrarConexion();
        return deportistas;
    }

    @Path("/femeninos")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Deportista> femeninos() {
        abrirConexion("ad_tema6", "localhost", "root", "");
        ArrayList<Deportista> deportistas = new ArrayList<>();
        try {
            String sql = "SELECT * FROM deportistas where genero = 'femeninos'";
            System.out.println(sql);
            mySQLConexion.createStatement().execute(sql);
            ResultSet resultados = mySQLConexion.createStatement().executeQuery(sql);
            while (resultados.next()) {
                deportistas.add(new Deportista(resultados.getInt("id"), resultados.getString("nombre"),
                        resultados.getString("deporte"), resultados.getBoolean("activo"),
                        resultados.getString("genero")));
            }
        } catch (SQLException e) {
            System.out.println("Error al ejecutar el comando SQL: " + e.getLocalizedMessage());
        }
        cerrarConexion();
        return deportistas;
    }

    @SuppressWarnings("unchecked")
    @Path("/xg")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Deportista>[] xg() {
        abrirConexion("ad_tema6", "localhost", "root", "");
        ArrayList<Deportista>[] depor = (ArrayList<Deportista>[]) new ArrayList[2];

        depor[0] = masculinos();
        depor[1] = femeninos();
        cerrarConexion();
        return depor;
    }

    @Path("7deporte/{nombreDeporte}/activos")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Deportista> buscarJugadoresActivosPorDeporte(@PathParam("nombreDeporte") String nombreDeporte) {
        abrirConexion("ad_tema6", "localhost", "root", "");
        ArrayList<Deportista> deportistas = new ArrayList<>();
        try {
            String sql = "SELECT * FROM deportistas where deporte = '" + nombreDeporte + "' and activo = 1";
            System.out.println(sql);
            mySQLConexion.createStatement().execute(sql);
            ResultSet resultados = mySQLConexion.createStatement().executeQuery(sql);
            while (resultados.next()) {
                deportistas.add(new Deportista(resultados.getInt("id"), resultados.getString("nombre"),
                        resultados.getString("deporte"), resultados.getBoolean("activo"),
                        resultados.getString("genero")));
            }
        } catch (SQLException e) {
            System.out.println("Error al ejecutar el comando SQL: " + e.getLocalizedMessage());
        }
        cerrarConexion();
        return deportistas;
    }

    @Path("sdepor")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public int sdepor() {
        return todos().size();
    }

    @Path("7deportes")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<String> listarDeportes() {

        ArrayList<String> deportes = new ArrayList<>();
        abrirConexion("ad_tema6", "localhost", "root", "");
        try {
            String sql = "SELECT DISTINCT deporte FROM deportistas ORDER BY deporte asc";
            System.out.println(sql);
            mySQLConexion.createStatement().execute(sql);
            ResultSet resultados = mySQLConexion.createStatement().executeQuery(sql);
            while (resultados.next()) {
                deportes.add(resultados.getString("deporte"));
            }
        } catch (SQLException e) {
            System.out.println("Error al ejecutar el comando SQL: " + e.getLocalizedMessage());
        }
        cerrarConexion();
        return deportes;

    }

    public void cerrarConexion() {
        try {
            this.mySQLConexion.close();
            System.out.println("Conexion cerrada");
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getLocalizedMessage());
        }
    }

    public void abrirConexion(String bd, String servidor, String usuario, String password) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = String.format("jdbc:mysql://%s:3306/%s?useServerPrepStmts=true", servidor, bd);
            this.mySQLConexion = DriverManager.getConnection(url, usuario, password);
            if (this.mySQLConexion != null) {
                System.out.println("Conectado a " + bd + " en " + servidor);
            } else {
                System.out.println("No conectado a " + bd + " en " + servidor);
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getLocalizedMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("Código error: " + e.getErrorCode());
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
