
package com.recogidapaquete.BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import org.apache.commons.codec.digest.DigestUtils;
import com.recogidapaquete.base.*;
import java.util.ArrayList;
import java.util.Calendar;

public class ConexionMySQL {
    
    private static ConexionMySQL conexionSingleton;
    private static Connection connection = null;
    private Statement st;
    private PreparedStatement ps;
    private ResultSet resultado;
    private static final String url="jdbc:mysql://localhost:3306/recogidapaquetes";
    private static final String password="root";
    private static final String user="root";
    private static int cantClientesRecogidaDia = 0;
    private static double porcentajePaqRecogidos = 0.0;
    private static double porcentajePaqNoRecogidos = 0.0;
    private static int paqueteRecogidos = 0;
    private static int paqueteSinRecoger = 0;
    private static String diaSemanaMayorRecogida ;
    private static String cantidadDiaSemanaMayor;
    private static int clienteHombre = 0;
    private static int clienteMujer =0;
    private static double porcentajeMujeres = 0.0;
    private static double porcentajeHombres = 0.0;
    
    private ConexionMySQL(){
        getConnection();
    }
    
    public static ConexionMySQL getInstance(){
        if(conexionSingleton == null){
            conexionSingleton = new ConexionMySQL();
        }
        return conexionSingleton;
    }
    
    public static Connection getConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error de conexión: "+e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return connection;
    }
    
    public int confirmacionLogin(String tabla, String usuario, String contrasena){
        String sql = "";
        
        if(null != tabla) {
            switch (tabla) {
                case "administrador":
                    sql = "select * from administrador where usuario='"+usuario+"'and contrasena=md5('"+contrasena+"')";
                    break;
                case "cliente":
                    sql = "select * from cliente where usuario='"+usuario+"'and contrasena=md5('"+contrasena+"')";
                    break;
                case "receptor":
                    sql = "select * from receptor where usuario='"+usuario+"'and contrasena=md5('"+contrasena+"')";
                    break;
                default:
                    break;
            }
        }
        
        int confirmacion = 0;
        
        try{
            st = connection.createStatement();
            resultado = st.executeQuery(sql);
            
            while(resultado.next()){
                confirmacion = 1;
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error en la consulta: "+e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
       return confirmacion;
    
    }
    
    public void introducirCliente(Cliente cliente){
        String encripted = DigestUtils.md5Hex(cliente.getContrasena()); 
        
        try{
            st = connection.createStatement();
            resultado = st.executeQuery("select usuario from cliente where usuario='"+(cliente.getUsuario())+"'");
            
            int x = 0;
            
            while(resultado.next()) {
                x += 1;
            }
            if (x == 1) {
                JOptionPane.showMessageDialog(null, "Usuario ya existe.", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
            
            } else {
                ps = connection.prepareStatement("insert into cliente (nombre, apellido, direccion, sexo, usuario, contrasena, correo) values (?,?,?,?,?,?,?)");
                ps.setString(1, cliente.getNombre());
                ps.setString(2, cliente.getApellido());
                ps.setString(3, cliente.getDireccion());
                ps.setString(4, cliente.getSexo());
                ps.setString(5, cliente.getUsuario());
                ps.setString(6, encripted);
                ps.setString(7, cliente.getCorreo());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Cliente agregado con éxito.", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
            }
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error al introducir datos: "+ex, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public void agregarReceptor(Receptor receptor){
        String encripted = DigestUtils.md5Hex(receptor.getContrasena()); 
        
        try{
            st = connection.createStatement();
            resultado = st.executeQuery("select usuario from receptor where usuario='"+(receptor.getUsuario())+"'");
            
            int x = 0;
            
            while(resultado.next()) {
                x += 1;
            }
            if (x == 1) {
                JOptionPane.showMessageDialog(null, "Usuario ya existe.", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
            
            } else {
                ps = connection.prepareStatement("insert into receptor (usuario, contrasena) values (?,?)");
                ps.setString(1, receptor.getUsuario());
                ps.setString(2, encripted);
                ps.executeUpdate();
                
                JOptionPane.showMessageDialog(null, "Receptor agregado con éxito.", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
            }
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error al introducir datos: "+ex, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        
    }
        
    public void agregarPaquete(Paquete paquete, String usuario){        
        try{
            int validar = 0;
            
            st = connection.createStatement();
            resultado = st.executeQuery("select usuario from cliente where usuario='"+(usuario)+"'");
            
            while (resultado.next()) {
                validar += 1;
            }
            
            if (validar == 1){
                ps = connection.prepareStatement("insert into paquete (descripcion, tipo_paquete, estado, ubicacion, fecha, usuario) values (?,?,?,?,?,?)");
                ps.setString(1, paquete.getDescripcion());
                ps.setString(2, paquete.getTipoPaquete());
                ps.setString(3, paquete.getEstadoValido());
                ps.setString(4, paquete.getUbicacion());
                ps.setString(5, paquete.getFecha());
                ps.setString(6, usuario);
                ps.executeUpdate();

                JOptionPane.showMessageDialog(null, "Paquete agregado con éxito.", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
            
            } else{
                JOptionPane.showMessageDialog(null, "El usuario no existe.", "ERROR", JOptionPane.ERROR_MESSAGE);

            }
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error al introducir paquete: "+ex, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    public void buscarCorreo(String usuario, Correo correo){
        
        try{
            int validar = 0;
            st = connection.createStatement();
            resultado = st.executeQuery("select correo from cliente where usuario='"+usuario+"'");
            
            while(resultado.next()){
                validar += 1;
                String correo1 = resultado.getString("correo");
                correo.setEmail(correo1);
            }
            
            if(validar == 0){
                JOptionPane.showMessageDialog(null, "Ese usuario no existe, no se puede generar el correo.", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
            }
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error en la búsqueda de la consulta.\n"+ex, "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
    
    public ArrayList<Paquete> getPaqueteDisponible(){
       Calendar fecha = Calendar.getInstance();
       String dia;
       dia = Integer.toString(fecha.get(Calendar.DATE));
       ArrayList <Paquete> datosPaquete = new ArrayList<Paquete>();
       try{
            st = connection.createStatement();
            
            if (Integer.parseInt(dia) <= 9) {
                resultado = st.executeQuery("select * from paquete where estado in('disponible') and fecha like '0"+dia+"%'");
            }else{
                resultado = st.executeQuery("select * from paquete where estado in('disponible') and fecha like '"+dia+"%'");
            }
            int validar = 0; 
            while(resultado.next()){
                validar = 1;
                Paquete paquete = new Paquete(resultado.getString("estado"));
                paquete.setId_paquete(resultado.getString("id_paquete"));
                paquete.setId_cliente(resultado.getString("usuario"));
                paquete.setTipoPaquete(resultado.getString("tipo_paquete"));
                paquete.setUbicacion(resultado.getString("ubicacion"));
                paquete.setDescripcion(resultado.getString("descripcion"));
                paquete.setFecha( resultado.getString("fecha"));
                datosPaquete.add(paquete); 
            }
            
            if (validar == 0) {
                JOptionPane.showMessageDialog(null, "No hay paquetes disponibles para hoy.", "ERROR", JOptionPane.ERROR_MESSAGE);
           }
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error en la consulta.\n"+ex, "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
        }
        return datosPaquete;
    }
    
    public void cambiarEstado(String estado, String id_paquete){
        try {
            ps = connection.prepareStatement("update paquete set estado='"+(estado)+"' where id_paquete='"+(id_paquete)+"'");
            ps.executeUpdate();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la consulta.\n"+e, "INFORMACION", JOptionPane.INFORMATION_MESSAGE);

        }
    }
    
    public ArrayList<Cliente> buscarPorNomApell(String nom_apell){
        ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
        try {
            int validar = 0; 
            st = connection.createStatement();
            resultado = st.executeQuery("select * from cliente where nombre='"+(nom_apell)+"' or apellido='"+(nom_apell)+"'");
            
            while (resultado.next()) {
                validar = 1;
                MediadorConcreto mediador = new MediadorConcreto();
                Cliente cliente = new Cliente(mediador);
                
                cliente.setIdCliente(resultado.getString("id_cliente"));
                cliente.setNombre(resultado.getString("nombre"));
                cliente.setApellido(resultado.getString("apellido"));
                cliente.setDireccion(resultado.getString("direccion"));
                cliente.setSexo(resultado.getString("sexo"));
                cliente.setCorreo(resultado.getString("correo"));
                listaClientes.add(cliente);
            }
            
            if (validar == 0) {
                JOptionPane.showMessageDialog(null, "El usuario no existe.\n", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error en la cosulta.\n"+e,"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        return listaClientes;
    }
    
    public ArrayList<Paquete> getPaqueteEstado(Paquete paquete){
        ArrayList<Paquete> listaPaquetes = new ArrayList<Paquete>();
        try{
            st = connection.createStatement();
            resultado = st.executeQuery("select * from paquete where estado='"+paquete.getEstadoValido()+"'");
            
            while(resultado.next()){
                paquete = new Paquete(resultado.getString("estado"));
                paquete.setDescripcion(resultado.getString("descripcion"));
                paquete.setTipoPaquete(resultado.getString("tipo_paquete"));
                paquete.setFecha(resultado.getString("fecha"));
                paquete.setUbicacion(resultado.getString("ubicacion"));
                listaPaquetes.add(paquete);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Ocurrió un error en la cosulta.\n"+ex,"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        return listaPaquetes;
    }
    public void consultaPorDia(String dia){
        try {
            if (dia.equals("")) {
                cantClientesRecogidaDia = 0;
                JOptionPane.showMessageDialog(null, "Introduzca el dia.", "ERROR", JOptionPane.INFORMATION_MESSAGE);
            }else{
                if (Integer.parseInt(dia) <= 9) {
                    st = connection.createStatement();
                    resultado = st.executeQuery("select * from paquete where estado='entregado' and fecha like'0"+(dia)+"%'");
                    cantClientesRecogidaDia = 0;
                    while (resultado.next()) {
                        cantClientesRecogidaDia += 1;
                    }
                } else{
                    st = connection.createStatement();
                    resultado = st.executeQuery("select * from paquete where estado='entregado' and fecha like'"+(dia)+"%'");
                    cantClientesRecogidaDia = 0;
                    while (resultado.next()) {
                        cantClientesRecogidaDia += 1;
                    }                
                }


            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Datos no encontrado u ocurrió un error en la cosulta.\n"+e,"ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }

    public void consultaPorSemana(String semana, String mes, String year){
        try {
            if (year.equals("")) {
                cantClientesRecogidaDia = 0;
                JOptionPane.showMessageDialog(null, "Introduzca el año.", "ERROR", JOptionPane.INFORMATION_MESSAGE);
                
            }else{
                
                int semanaValidate = Integer.parseInt(semana);
                
                if (semanaValidate == 1) {
                    st = connection.createStatement();
                    cantClientesRecogidaDia = 0;

                    if (Integer.parseInt(mes) < 10) {
                        for (int i = 1; i < 8; i++) {
                            resultado = st.executeQuery("select * from paquete where estado='entregado' and fecha='0"+(String.valueOf(i))+"/0"+(mes)+"/"+(year)+"'");
                            while (resultado.next()) {
                                cantClientesRecogidaDia += 1;
                            }
                        }
                    } else {
                        for (int i = 1; i < 8; i++) {
                            resultado = st.executeQuery("select * from paquete where estado='entregado' and fecha='0"+(String.valueOf(i))+"/"+(mes)+"/"+(year)+"'");
                            while (resultado.next()) {
                                cantClientesRecogidaDia += 1;
                            }
                        }
                    }
                } else if(semanaValidate == 2){
                    st = connection.createStatement();
                    cantClientesRecogidaDia = 0;

                    if (Integer.parseInt(mes) < 10) {
                        for (int i = 7; i < 15; i++) {
                            if (i < 10) {
                                resultado = st.executeQuery("select * from paquete where estado='entregado' and fecha='0"+(String.valueOf(i))+"/0"+(mes)+"/"+(year)+"'");
                                while (resultado.next()) {
                                    cantClientesRecogidaDia += 1;
                                }
                            }else{
                                resultado = st.executeQuery("select * from paquete where estado='entregado' and fecha='"+(String.valueOf(i))+"/0"+(mes)+"/"+(year)+"'");
                                while (resultado.next()) {
                                    cantClientesRecogidaDia += 1;
                                }
                            }
                        }
                    } else {
                        for (int i = 7; i < 15; i++) {
                            if (i < 10) {
                                resultado = st.executeQuery("select * from paquete where estado='entregado' and fecha='0"+(String.valueOf(i))+"/"+(mes)+"/"+(year)+"'");
                                while (resultado.next()) {
                                    cantClientesRecogidaDia += 1;
                                }
                            }else{
                                resultado = st.executeQuery("select * from paquete where estado='entregado' and fecha='"+(String.valueOf(i))+"/"+(mes)+"/"+(year)+"'");
                                while (resultado.next()) {
                                    cantClientesRecogidaDia += 1;
                                }
                            }
                        }
                    }
                } else if(semanaValidate == 3){
                    st = connection.createStatement();
                    cantClientesRecogidaDia = 0;

                    if (Integer.parseInt(mes) < 10) {
                        for (int i = 14; i < 22; i++) {
                            resultado = st.executeQuery("select * from paquete where estado='entregado' and fecha='"+(String.valueOf(i))+"/0"+(mes)+"/"+(year)+"'");
                            while (resultado.next()) {
                                cantClientesRecogidaDia += 1;
                            }
                        }
                    } else {
                        for (int i = 14; i < 22; i++) {
                            resultado = st.executeQuery("select * from paquete where estado='entregado' and fecha='"+(String.valueOf(i))+"/"+(mes)+"/"+(year)+"'");
                            while (resultado.next()) {
                                cantClientesRecogidaDia += 1;
                            }
                        }
                    }
                } else if(semanaValidate == 4){
                    st = connection.createStatement();
                    cantClientesRecogidaDia = 0;

                    if (Integer.parseInt(mes) < 10) {
                        for (int i = 21; i < 29; i++) {
                            resultado = st.executeQuery("select * from paquete where estado='entregado' and fecha='"+(String.valueOf(i))+"/0"+(mes)+"/"+(year)+"'");
                            while (resultado.next()) {
                                cantClientesRecogidaDia += 1;
                            }
                        }
                    } else {
                        for (int i = 21; i < 29; i++) {
                            resultado = st.executeQuery("select * from paquete where estado='entregado' and fecha='"+(String.valueOf(i))+"/"+(mes)+"/"+(year)+"'");
                            while (resultado.next()) {
                                cantClientesRecogidaDia += 1;
                            }
                        }
                    }
                } else if(semanaValidate == 5){
                    st = connection.createStatement();
                    cantClientesRecogidaDia = 0;

                    if (Integer.parseInt(mes) < 10) {
                        for (int i = 28; i < 31; i++) {
                            resultado = st.executeQuery("select * from paquete where estado='entregado' and fecha='"+(String.valueOf(i))+"/0"+(mes)+"/"+(year)+"'");
                            while (resultado.next()) {
                                cantClientesRecogidaDia += 1;
                            }
                        }
                    } else {
                        for (int i = 28; i < 31; i++) {
                            resultado = st.executeQuery("select * from paquete where estado='entregado' and fecha='"+(String.valueOf(i))+"/"+(mes)+"/"+(year)+"'");
                            while (resultado.next()) {
                                cantClientesRecogidaDia += 1;
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Datos no encontrado u ocurrió un error en la cosulta.\n"+e,"ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void consultaPorMes(String mes, String year){
        try {
            if (year.equals("")) {
                cantClientesRecogidaDia = 0;
                JOptionPane.showMessageDialog(null, "Introduzca el año.", "ERROR", JOptionPane.INFORMATION_MESSAGE);
            
            }else{
                st = connection.createStatement();
                cantClientesRecogidaDia = 0;

                if (Integer.parseInt(mes) < 10) {
                    for (int i = 1; i < 31; i++) {
                        if (i < 10) {
                            resultado = st.executeQuery("select * from paquete where estado='entregado' and fecha='0"+(String.valueOf(i))+"/0"+(mes)+"/"+(year)+"'");
                            while (resultado.next()) {
                                cantClientesRecogidaDia += 1;
                            }
                        } else{
                            resultado = st.executeQuery("select * from paquete where estado='entregado' and fecha='"+(String.valueOf(i))+"/0"+(mes)+"/"+(year)+"'");
                            while (resultado.next()) {
                                cantClientesRecogidaDia += 1;
                            }
                        }
                    }
                } else {
                    for (int i = 1; i < 31; i++) {
                        if (i < 10) {
                            resultado = st.executeQuery("select * from paquete where estado='entregado' and fecha='0"+(String.valueOf(i))+"/"+(mes)+"/"+(year)+"'");
                            while (resultado.next()) {
                                cantClientesRecogidaDia += 1;
                            }
                        } else{
                            resultado = st.executeQuery("select * from paquete where estado='entregado' and fecha='"+(String.valueOf(i))+"/"+(mes)+"/"+(year)+"'");
                            while (resultado.next()) {
                                cantClientesRecogidaDia += 1;
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Datos no encontrado u ocurrió un error en la cosulta.\n"+e,"ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void getPorcentajePaquetesRecogido(){
        try {
            double porcentaje = 0.0;
            st = connection.createStatement();
            resultado = st.executeQuery("select * from paquete where estado='entregado'");
            paqueteRecogidos = 0;
            
            while (resultado.next()) {
                paqueteRecogidos += 1;
            }
            
            resultado = st.executeQuery("select * from paquete where estado='disponible'");
            paqueteSinRecoger = 0;
            
            while (resultado.next()) {
                paqueteSinRecoger += 1;
            }
            
            int totalPaquetes = paqueteRecogidos+paqueteSinRecoger;
            porcentaje = (paqueteRecogidos * 100) / totalPaquetes;
            porcentajePaqRecogidos = porcentaje;
            porcentajePaqNoRecogidos = 100.0 - porcentaje;

            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de consulta. \n"+e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void getPorcentajeClienteMascFem(){
        try {
            double porcentaje = 0.0;
            st = connection.createStatement();
            resultado = st.executeQuery("select * from cliente where sexo='masculino'");
            clienteHombre = 0;
            
            while (resultado.next()) {
                clienteHombre += 1;
            }
            
            resultado = st.executeQuery("select * from cliente where sexo='femenino'");
            clienteMujer = 0;
            
            while (resultado.next()) {
                clienteMujer += 1;
            }
            
            int totalClientes = clienteHombre+clienteMujer;
            porcentaje = (clienteHombre * 100) / totalClientes;
            porcentajeHombres = porcentaje;
            porcentajeMujeres = 100.0 - porcentaje;

            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de consulta.\n"+e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void setDiaSemanaMayor(String dia,String mes,String year){
        try{
            st=connection.createStatement();
            resultado=st.executeQuery("select ((paquete.fecha))+0 as dia, count(paquete.fecha) as total from paquete where paquete.fecha<='"+dia+"/"+mes+"/"+year+"' and estado='entregado' order by total desc");
            while (resultado.next()){
                diaSemanaMayorRecogida=resultado.getString("dia");
                cantidadDiaSemanaMayor=resultado.getString("total");
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Error en la consulta "+ex);
        }
        
    }
    
    public ArrayList<Cliente> verPerfilUsuario(String usuario){
        ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
        try {
            st = connection.createStatement();
            resultado = st.executeQuery("select * from cliente where usuario='"+(usuario)+"'");
            MediadorConcreto mediador = new MediadorConcreto();
            int validar = 0;
            while(resultado.next()) {
                validar += 1;
                Cliente cliente = new Cliente(mediador);
                cliente.setNombre(resultado.getString("nombre"));
                cliente.setApellido(resultado.getString("apellido"));
                cliente.setDireccion(resultado.getString("direccion"));
                cliente.setCorreo(resultado.getString("correo"));
                cliente.setSexo(resultado.getString("sexo"));
                listaClientes.add(cliente);
            }
            if (validar == 0) {
                JOptionPane.showMessageDialog(null, "No existe este usuario.", "ERROR", JOptionPane.INFORMATION_MESSAGE);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de consulta.\n"+e, "ERROR", JOptionPane.INFORMATION_MESSAGE);
        }
        return listaClientes;
                
    }
    
    public ArrayList<Paquete> verPaquetesDePerfilUsuario(String usuario){
        ArrayList<Paquete> listaPaquetes = new ArrayList<Paquete>();
        try {
            st = connection.createStatement();
            resultado = st.executeQuery("select * from paquete where usuario='"+(usuario)+"'");
            
            while(resultado.next()) {
                Paquete paquete = new Paquete(resultado.getString("estado"));
                paquete.setDescripcion(resultado.getString("descripcion"));
                paquete.setTipoPaquete(resultado.getString("tipo_paquete"));
                paquete.setUbicacion(resultado.getString("ubicacion"));
                paquete.setFecha(resultado.getString("fecha"));
                listaPaquetes.add(paquete);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de consulta.\n"+e, "ERROR", JOptionPane.INFORMATION_MESSAGE);
        }
        return listaPaquetes;
                
    }
    
    //getters
    public int getCantClientesRecogidaDia() {
        return cantClientesRecogidaDia;
    }
    
    public double getPorcentajePaqRecogidos() {
        return porcentajePaqRecogidos;
    }
    
    public double getPorcentajePaqNoRecogidos() {
        return porcentajePaqNoRecogidos;
    }
    
    public double getPorcentajeMujeres() {
        return porcentajeMujeres;
    }
    
    public double getPorcentajeHombres() {
        return porcentajeHombres;
    }

    public String getDiaSemanaMayorRecogida() {
        return diaSemanaMayorRecogida;
    }

    public String getCantidadDiaSemanaMayor() {
        return cantidadDiaSemanaMayor;
    }
    
    public void desconectar(){
       try{
            connection.close();
            
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "Error de desconexión: "+e, "ERROR", JOptionPane.ERROR_MESSAGE);
       }
       
    }
    
}
