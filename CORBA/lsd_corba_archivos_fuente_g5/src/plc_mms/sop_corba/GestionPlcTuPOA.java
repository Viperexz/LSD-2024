package plc_mms.sop_corba;


/**
* plc_mms/sop_corba/GestionPlcTuPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from gesplctu.idl
* domingo 2 de junio de 2024 08:21:24 PM COT
*/

public abstract class GestionPlcTuPOA extends org.omg.PortableServer.Servant
 implements plc_mms.sop_corba.GestionPlcTuOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("registrar_plctu", new java.lang.Integer (0));
    _methods.put ("consultarplctu", new java.lang.Integer (1));
    _methods.put ("registrarCallback", new java.lang.Integer (2));
    _methods.put ("usuariosConectados", new java.lang.Integer (3));
    _methods.put ("recuperarLista", new java.lang.Integer (4));
    _methods.put ("recuperarFactura", new java.lang.Integer (5));
    _methods.put ("notificarFacturas", new java.lang.Integer (6));
    _methods.put ("actualizarLista", new java.lang.Integer (7));
    _methods.put ("eliminarTU", new java.lang.Integer (8));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // sop_corba/GestionPlcTu/registrar_plctu
       {
         plc_mms.sop_corba.GestionPlcTuPackage.DatosPlcTu_DTO dplctu = plc_mms.sop_corba.GestionPlcTuPackage.DatosPlcTu_DTOHelper.read (in);
         boolean $result = false;
         $result = this.registrar_plctu (dplctu);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 1:  // sop_corba/GestionPlcTu/consultarplctu
       {
         int plctuid = in.read_long ();
         plc_mms.sop_corba.GestionPlcTuPackage.DatosPlcTu_DTOHolder objTU = new plc_mms.sop_corba.GestionPlcTuPackage.DatosPlcTu_DTOHolder ();
         boolean $result = false;
         $result = this.consultarplctu (plctuid, objTU);
         out = $rh.createReply();
         out.write_boolean ($result);
         plc_mms.sop_corba.GestionPlcTuPackage.DatosPlcTu_DTOHelper.write (out, objTU.value);
         break;
       }

       case 2:  // sop_corba/GestionPlcTu/registrarCallback
       {
           plc_tu.sop_corba.GestionAlertas objAlertas = plc_tu.sop_corba.GestionAlertasHelper.read (in);
         this.registrarCallback (objAlertas);
         out = $rh.createReply();
         break;
       }

       case 3:  // sop_corba/GestionPlcTu/usuariosConectados
       {
           plc_tu.sop_corba.GestionAlertas objUsuario = plc_tu.sop_corba.GestionAlertasHelper.read (in);
         this.usuariosConectados (objUsuario);
         out = $rh.createReply();
         break;
       }

       case 4:  // sop_corba/GestionPlcTu/recuperarLista
       {
         plc_mms.sop_corba.GestionPlcTuPackage.ListaDtoHolder objLista = new plc_mms.sop_corba.GestionPlcTuPackage.ListaDtoHolder ();
         boolean $result = false;
         $result = this.recuperarLista (objLista);
         out = $rh.createReply();
         out.write_boolean ($result);
         plc_mms.sop_corba.GestionPlcTuPackage.ListaDtoHelper.write (out, objLista.value);
         break;
       }

       case 5:  // sop_corba/GestionPlcTu/recuperarFactura
       {
         String IdTu = in.read_string ();
         plc_mms.sop_corba.GestionPlcTuPackage.Factura_DTO $result = null;
         $result = this.recuperarFactura (IdTu);
         out = $rh.createReply();
         plc_mms.sop_corba.GestionPlcTuPackage.Factura_DTOHelper.write (out, $result);
         break;
       }

       case 6:  // sop_corba/GestionPlcTu/notificarFacturas
       {
         String IdTu = in.read_string ();
         this.notificarFacturas (IdTu);
         out = $rh.createReply();
         break;
       }

       case 7:  // sop_corba/GestionPlcTu/actualizarLista
       {
         plc_mms.sop_corba.GestionPlcTuPackage.ListaDto prmListaTU = plc_mms.sop_corba.GestionPlcTuPackage.ListaDtoHelper.read (in);
         this.actualizarLista (prmListaTU);
         out = $rh.createReply();
         break;
       }

       case 8:  // sop_corba/GestionPlcTu/eliminarTU
       {
         String idTu = in.read_string ();
         boolean $result = false;
         $result = this.eliminarTU (idTu);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:sop_corba/GestionPlcTu:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public GestionPlcTu _this() 
  {
    return GestionPlcTuHelper.narrow(
    super._this_object());
  }

  public GestionPlcTu _this(org.omg.CORBA.ORB orb) 
  {
    return GestionPlcTuHelper.narrow(
    super._this_object(orb));
  }


} // class GestionPlcTuPOA