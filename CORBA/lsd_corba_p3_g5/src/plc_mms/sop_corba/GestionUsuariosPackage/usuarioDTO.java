package plc_mms.sop_corba.GestionUsuariosPackage;


/**
* plc_mms/sop_corba/GestionUsuariosPackage/usuarioDTO.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from gesusuarios.idl
* martes 28 de mayo de 2024 05:03:03 PM COT
*/

public final class usuarioDTO implements org.omg.CORBA.portable.IDLEntity
{
  public int id = (int)0;
  public String nombreCompleto = null;
  public String usuario = null;
  public String clave = null;

  public usuarioDTO ()
  {
  } // ctor

  public usuarioDTO (int _id, String _nombreCompleto, String _usuario, String _clave)
  {
    id = _id;
    nombreCompleto = _nombreCompleto;
    usuario = _usuario;
    clave = _clave;
  } // ctor

} // class usuarioDTO
