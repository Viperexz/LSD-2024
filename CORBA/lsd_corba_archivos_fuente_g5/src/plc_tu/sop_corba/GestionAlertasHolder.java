package plc_tu.sop_corba;

/**
* plc_tu/sop_corba/GestionAlertasHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from gesalertas.idl
* jueves 6 de junio de 2024 12:24:04 PM COT
*/

public final class GestionAlertasHolder implements org.omg.CORBA.portable.Streamable
{
  public plc_tu.sop_corba.GestionAlertas value = null;

  public GestionAlertasHolder ()
  {
  }

  public GestionAlertasHolder (plc_tu.sop_corba.GestionAlertas initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = plc_tu.sop_corba.GestionAlertasHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    plc_tu.sop_corba.GestionAlertasHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return plc_tu.sop_corba.GestionAlertasHelper.type ();
  }

}
