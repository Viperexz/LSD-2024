package grsaa.sop_corba.GestionDispositivosPackage;

/**
* grsaa/sop_corba/GestionDispositivosPackage/Factura_DTOHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from gesdispositivos.idl
* domingo 2 de junio de 2024 08:21:24 PM COT
*/

public final class Factura_DTOHolder implements org.omg.CORBA.portable.Streamable
{
  public grsaa.sop_corba.GestionDispositivosPackage.Factura_DTO value = null;

  public Factura_DTOHolder ()
  {
  }

  public Factura_DTOHolder (grsaa.sop_corba.GestionDispositivosPackage.Factura_DTO initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = grsaa.sop_corba.GestionDispositivosPackage.Factura_DTOHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    grsaa.sop_corba.GestionDispositivosPackage.Factura_DTOHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return grsaa.sop_corba.GestionDispositivosPackage.Factura_DTOHelper.type ();
  }

}