package plc_tu.sop_corba.GestionAlertasPackage;


/**
* plc_tu/sop_corba/GestionAlertasPackage/alertaDto.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from gesalertas.idl
* martes 28 de mayo de 2024 05:03:02 PM COT
*/

public final class alertaDto implements org.omg.CORBA.portable.IDLEntity
{
  public String usuario = null;
  public int id = (int)0;
  public int modo = (int)0;

  public alertaDto ()
  {
  } // ctor

  public alertaDto (String _usuario, int _id, int _modo)
  {
    usuario = _usuario;
    id = _id;
    modo = _modo;
  } // ctor

} // class alertaDto
