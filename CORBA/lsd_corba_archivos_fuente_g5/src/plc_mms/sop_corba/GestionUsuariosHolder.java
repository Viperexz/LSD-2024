package plc_mms.sop_corba;

/**
* plc_mms/sop_corba/GestionUsuariosHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from gesusuarios.idl
* domingo 2 de junio de 2024 08:21:24 PM COT
*/

public final class GestionUsuariosHolder implements org.omg.CORBA.portable.Streamable
{
  public plc_mms.sop_corba.GestionUsuarios value = null;

  public GestionUsuariosHolder ()
  {
  }

  public GestionUsuariosHolder (plc_mms.sop_corba.GestionUsuarios initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = plc_mms.sop_corba.GestionUsuariosHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    plc_mms.sop_corba.GestionUsuariosHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return plc_mms.sop_corba.GestionUsuariosHelper.type ();
  }

}
