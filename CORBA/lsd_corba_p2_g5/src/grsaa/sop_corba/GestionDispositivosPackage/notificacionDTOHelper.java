package grsaa.sop_corba.GestionDispositivosPackage;


/**
* grsaa/sop_corba/GestionDispositivosPackage/notificacionDTOHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from gesdispositivos.idl
* martes 21 de mayo de 2024 05:08:23 PM COT
*/

abstract public class notificacionDTOHelper
{
  private static String  _id = "IDL:sop_corba/GestionDispositivos/notificacionDTO:1.0";

  public static void insert (org.omg.CORBA.Any a, grsaa.sop_corba.GestionDispositivosPackage.notificacionDTO that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static grsaa.sop_corba.GestionDispositivosPackage.notificacionDTO extract (org.omg.CORBA.Any a)
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
          org.omg.CORBA.StructMember[] _members0 = new org.omg.CORBA.StructMember [1];
          org.omg.CORBA.TypeCode _tcOf_members0 = null;
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_long);
          _members0[0] = new org.omg.CORBA.StructMember (
            "idPlcmms",
            _tcOf_members0,
            null);
          __typeCode = org.omg.CORBA.ORB.init ().create_struct_tc (grsaa.sop_corba.GestionDispositivosPackage.notificacionDTOHelper.id (), "notificacionDTO", _members0);
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

  public static grsaa.sop_corba.GestionDispositivosPackage.notificacionDTO read (org.omg.CORBA.portable.InputStream istream)
  {
    grsaa.sop_corba.GestionDispositivosPackage.notificacionDTO value = new grsaa.sop_corba.GestionDispositivosPackage.notificacionDTO ();
    value.idPlcmms = istream.read_long ();
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, grsaa.sop_corba.GestionDispositivosPackage.notificacionDTO value)
  {
    ostream.write_long (value.idPlcmms);
  }

}
