package sop_corba;

/**
* sop_corba/GestionUsuariosHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from gesusuarios.idl
* martes 14 de mayo de 2024 05:34:09 PM COT
*/

public final class GestionUsuariosHolder implements org.omg.CORBA.portable.Streamable
{
  public sop_corba.GestionUsuarios value = null;

  public GestionUsuariosHolder ()
  {
  }

  public GestionUsuariosHolder (sop_corba.GestionUsuarios initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = sop_corba.GestionUsuariosHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    sop_corba.GestionUsuariosHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return sop_corba.GestionUsuariosHelper.type ();
  }

}
