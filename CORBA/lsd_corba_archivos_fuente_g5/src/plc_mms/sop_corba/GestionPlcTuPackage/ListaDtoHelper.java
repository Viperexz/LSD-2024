package plc_mms.sop_corba.GestionPlcTuPackage;


/**
* plc_mms/sop_corba/GestionPlcTuPackage/ListaDtoHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from gesplctu.idl
* domingo 2 de junio de 2024 08:21:24 PM COT
*/

abstract public class ListaDtoHelper
{
  private static String  _id = "IDL:sop_corba/GestionPlcTu/ListaDto:1.0";

  public static void insert (org.omg.CORBA.Any a, plc_mms.sop_corba.GestionPlcTuPackage.ListaDto that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static plc_mms.sop_corba.GestionPlcTuPackage.ListaDto extract (org.omg.CORBA.Any a)
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
          _tcOf_members0 = plc_mms.sop_corba.GestionPlcTuPackage.DatosPlcTu_DTOHelper.type ();
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_sequence_tc (0, _tcOf_members0);
          _members0[0] = new org.omg.CORBA.StructMember (
            "listTU",
            _tcOf_members0,
            null);
          __typeCode = org.omg.CORBA.ORB.init ().create_struct_tc (plc_mms.sop_corba.GestionPlcTuPackage.ListaDtoHelper.id (), "ListaDto", _members0);
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

  public static plc_mms.sop_corba.GestionPlcTuPackage.ListaDto read (org.omg.CORBA.portable.InputStream istream)
  {
    plc_mms.sop_corba.GestionPlcTuPackage.ListaDto value = new plc_mms.sop_corba.GestionPlcTuPackage.ListaDto ();
    int _len0 = istream.read_long ();
    value.listTU = new plc_mms.sop_corba.GestionPlcTuPackage.DatosPlcTu_DTO[_len0];
    for (int _o1 = 0;_o1 < value.listTU.length; ++_o1)
      value.listTU[_o1] = plc_mms.sop_corba.GestionPlcTuPackage.DatosPlcTu_DTOHelper.read (istream);
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, plc_mms.sop_corba.GestionPlcTuPackage.ListaDto value)
  {
    ostream.write_long (value.listTU.length);
    for (int _i0 = 0;_i0 < value.listTU.length; ++_i0)
      plc_mms.sop_corba.GestionPlcTuPackage.DatosPlcTu_DTOHelper.write (ostream, value.listTU[_i0]);
  }

}
