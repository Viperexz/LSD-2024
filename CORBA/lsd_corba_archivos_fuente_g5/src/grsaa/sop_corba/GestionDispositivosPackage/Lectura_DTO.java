package grsaa.sop_corba.GestionDispositivosPackage;


/**
* grsaa/sop_corba/GestionDispositivosPackage/Lectura_DTO.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from gesdispositivos.idl
* domingo 2 de junio de 2024 08:21:24 PM COT
*/

public final class Lectura_DTO implements org.omg.CORBA.portable.IDLEntity
{
  public grsaa.sop_corba.GestionDispositivosPackage.DatosPlcTu_DTO listTU[] = null;

  public Lectura_DTO ()
  {
  } // ctor

  public Lectura_DTO (grsaa.sop_corba.GestionDispositivosPackage.DatosPlcTu_DTO[] _listTU)
  {
    listTU = _listTU;
  } // ctor

} // class Lectura_DTO