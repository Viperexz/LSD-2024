package grsaa.sop_corba.GestionDispositivosPackage;


/**
* grsaa/sop_corba/GestionDispositivosPackage/notificacionDTO.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from gesdispositivos.idl
* domingo 2 de junio de 2024 08:21:24 PM COT
*/

public final class notificacionDTO implements org.omg.CORBA.portable.IDLEntity
{
  public int idPlcmms = (int)0;
  public grsaa.sop_corba.GestionDispositivosPackage.DatosPlcTu_DTO listTU[] = null;

  public notificacionDTO ()
  {
  } // ctor

  public notificacionDTO (int _idPlcmms, grsaa.sop_corba.GestionDispositivosPackage.DatosPlcTu_DTO[] _listTU)
  {
    idPlcmms = _idPlcmms;
    listTU = _listTU;
  } // ctor

} // class notificacionDTO