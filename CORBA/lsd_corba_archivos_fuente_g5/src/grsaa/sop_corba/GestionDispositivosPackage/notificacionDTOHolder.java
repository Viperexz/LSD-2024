package grsaa.sop_corba.GestionDispositivosPackage;

/**
* grsaa/sop_corba/GestionDispositivosPackage/notificacionDTOHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from gesdispositivos.idl
* jueves 6 de junio de 2024 12:24:05 PM COT
*/

public final class notificacionDTOHolder implements org.omg.CORBA.portable.Streamable
{
  public grsaa.sop_corba.GestionDispositivosPackage.notificacionDTO value = null;

  public notificacionDTOHolder ()
  {
  }

  public notificacionDTOHolder (grsaa.sop_corba.GestionDispositivosPackage.notificacionDTO initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = grsaa.sop_corba.GestionDispositivosPackage.notificacionDTOHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    grsaa.sop_corba.GestionDispositivosPackage.notificacionDTOHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return grsaa.sop_corba.GestionDispositivosPackage.notificacionDTOHelper.type ();
  }

}
