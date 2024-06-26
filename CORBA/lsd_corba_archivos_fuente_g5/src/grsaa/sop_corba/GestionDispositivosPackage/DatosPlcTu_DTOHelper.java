package grsaa.sop_corba.GestionDispositivosPackage;


/**
* grsaa/sop_corba/GestionDispositivosPackage/DatosPlcTu_DTOHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from gesdispositivos.idl
* jueves 6 de junio de 2024 12:24:05 PM COT
*/

abstract public class DatosPlcTu_DTOHelper
{
  private static String  _id = "IDL:sop_corba/GestionDispositivos/DatosPlcTu_DTO:1.0";

  public static void insert (org.omg.CORBA.Any a, grsaa.sop_corba.GestionDispositivosPackage.DatosPlcTu_DTO that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static grsaa.sop_corba.GestionDispositivosPackage.DatosPlcTu_DTO extract (org.omg.CORBA.Any a)
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
          org.omg.CORBA.StructMember[] _members0 = new org.omg.CORBA.StructMember [9];
          org.omg.CORBA.TypeCode _tcOf_members0 = null;
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[0] = new org.omg.CORBA.StructMember (
            "id_plctu",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[1] = new org.omg.CORBA.StructMember (
            "propietario",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[2] = new org.omg.CORBA.StructMember (
            "tipoIden",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[3] = new org.omg.CORBA.StructMember (
            "numIden",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[4] = new org.omg.CORBA.StructMember (
            "direccion",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[5] = new org.omg.CORBA.StructMember (
            "estrato",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[6] = new org.omg.CORBA.StructMember (
            "fechaRegistro",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_long);
          _members0[7] = new org.omg.CORBA.StructMember (
            "lectura",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_long);
          _members0[8] = new org.omg.CORBA.StructMember (
            "consumo",
            _tcOf_members0,
            null);
          __typeCode = org.omg.CORBA.ORB.init ().create_struct_tc (grsaa.sop_corba.GestionDispositivosPackage.DatosPlcTu_DTOHelper.id (), "DatosPlcTu_DTO", _members0);
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

  public static grsaa.sop_corba.GestionDispositivosPackage.DatosPlcTu_DTO read (org.omg.CORBA.portable.InputStream istream)
  {
    grsaa.sop_corba.GestionDispositivosPackage.DatosPlcTu_DTO value = new grsaa.sop_corba.GestionDispositivosPackage.DatosPlcTu_DTO ();
    value.id_plctu = istream.read_string ();
    value.propietario = istream.read_string ();
    value.tipoIden = istream.read_string ();
    value.numIden = istream.read_string ();
    value.direccion = istream.read_string ();
    value.estrato = istream.read_string ();
    value.fechaRegistro = istream.read_string ();
    value.lectura = istream.read_long ();
    value.consumo = istream.read_long ();
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, grsaa.sop_corba.GestionDispositivosPackage.DatosPlcTu_DTO value)
  {
    ostream.write_string (value.id_plctu);
    ostream.write_string (value.propietario);
    ostream.write_string (value.tipoIden);
    ostream.write_string (value.numIden);
    ostream.write_string (value.direccion);
    ostream.write_string (value.estrato);
    ostream.write_string (value.fechaRegistro);
    ostream.write_long (value.lectura);
    ostream.write_long (value.consumo);
  }

}
