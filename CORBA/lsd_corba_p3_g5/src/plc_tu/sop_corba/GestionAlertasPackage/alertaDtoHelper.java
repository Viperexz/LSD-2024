package plc_tu.sop_corba.GestionAlertasPackage;


/**
* plc_tu/sop_corba/GestionAlertasPackage/alertaDtoHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from gesalertas.idl
* martes 28 de mayo de 2024 05:03:02 PM COT
*/

abstract public class alertaDtoHelper
{
  private static String  _id = "IDL:sop_corba/GestionAlertas/alertaDto:1.0";

  public static void insert (org.omg.CORBA.Any a, plc_tu.sop_corba.GestionAlertasPackage.alertaDto that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static plc_tu.sop_corba.GestionAlertasPackage.alertaDto extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  private static boolean __active = false;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      synchronized (org.omg.CORBA.TypeCode.class)
      {
        if (__typeCode == null)
        {
          if (__active)
          {
            return org.omg.CORBA.ORB.init().create_recursive_tc ( _id );
          }
          __active = true;
          org.omg.CORBA.StructMember[] _members0 = new org.omg.CORBA.StructMember [3];
          org.omg.CORBA.TypeCode _tcOf_members0 = null;
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[0] = new org.omg.CORBA.StructMember (
            "usuario",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_long);
          _members0[1] = new org.omg.CORBA.StructMember (
            "id",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_long);
          _members0[2] = new org.omg.CORBA.StructMember (
            "modo",
            _tcOf_members0,
            null);
          __typeCode = org.omg.CORBA.ORB.init ().create_struct_tc (plc_tu.sop_corba.GestionAlertasPackage.alertaDtoHelper.id (), "alertaDto", _members0);
          __active = false;
        }
      }
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static plc_tu.sop_corba.GestionAlertasPackage.alertaDto read (org.omg.CORBA.portable.InputStream istream)
  {
    plc_tu.sop_corba.GestionAlertasPackage.alertaDto value = new plc_tu.sop_corba.GestionAlertasPackage.alertaDto ();
    value.usuario = istream.read_string ();
    value.id = istream.read_long ();
    value.modo = istream.read_long ();
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, plc_tu.sop_corba.GestionAlertasPackage.alertaDto value)
  {
    ostream.write_string (value.usuario);
    ostream.write_long (value.id);
    ostream.write_long (value.modo);
  }

}
