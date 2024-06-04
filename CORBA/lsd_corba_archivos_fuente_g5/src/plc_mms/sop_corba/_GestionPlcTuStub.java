package plc_mms.sop_corba;


/**
* plc_mms/sop_corba/_GestionPlcTuStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from gesplctu.idl
* domingo 2 de junio de 2024 08:21:24 PM COT
*/

public class _GestionPlcTuStub extends org.omg.CORBA.portable.ObjectImpl implements plc_mms.sop_corba.GestionPlcTu
{

  public boolean registrar_plctu (plc_mms.sop_corba.GestionPlcTuPackage.DatosPlcTu_DTO dplctu)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("registrar_plctu", true);
                plc_mms.sop_corba.GestionPlcTuPackage.DatosPlcTu_DTOHelper.write ($out, dplctu);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return registrar_plctu (dplctu        );
            } finally {
                _releaseReply ($in);
            }
  } // registrar_plctu

  public boolean consultarplctu (int plctuid, plc_mms.sop_corba.GestionPlcTuPackage.DatosPlcTu_DTOHolder objTU)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("consultarplctu", true);
                $out.write_long (plctuid);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                objTU.value = plc_mms.sop_corba.GestionPlcTuPackage.DatosPlcTu_DTOHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return consultarplctu (plctuid, objTU        );
            } finally {
                _releaseReply ($in);
            }
  } // consultarplctu

  public void registrarCallback (plc_tu.sop_corba.GestionAlertas objAlertas)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("registrarCallback", true);
                plc_tu.sop_corba.GestionAlertasHelper.write ($out, objAlertas);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                registrarCallback (objAlertas        );
            } finally {
                _releaseReply ($in);
            }
  } // registrarCallback

  public void usuariosConectados (plc_tu.sop_corba.GestionAlertas objUsuario)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("usuariosConectados", true);
                plc_tu.sop_corba.GestionAlertasHelper.write ($out, objUsuario);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                usuariosConectados (objUsuario        );
            } finally {
                _releaseReply ($in);
            }
  } // usuariosConectados

  public boolean recuperarLista (plc_mms.sop_corba.GestionPlcTuPackage.ListaDtoHolder objLista)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("recuperarLista", true);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                objLista.value = plc_mms.sop_corba.GestionPlcTuPackage.ListaDtoHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return recuperarLista (objLista        );
            } finally {
                _releaseReply ($in);
            }
  } // recuperarLista

  public plc_mms.sop_corba.GestionPlcTuPackage.Factura_DTO recuperarFactura (String IdTu)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("recuperarFactura", true);
                $out.write_string (IdTu);
                $in = _invoke ($out);
                plc_mms.sop_corba.GestionPlcTuPackage.Factura_DTO $result = plc_mms.sop_corba.GestionPlcTuPackage.Factura_DTOHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return recuperarFactura (IdTu        );
            } finally {
                _releaseReply ($in);
            }
  } // recuperarFactura

  public void notificarFacturas (String IdTu)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("notificarFacturas", true);
                $out.write_string (IdTu);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                notificarFacturas (IdTu        );
            } finally {
                _releaseReply ($in);
            }
  } // notificarFacturas

  public void actualizarLista (plc_mms.sop_corba.GestionPlcTuPackage.ListaDto prmListaTU)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("actualizarLista", true);
                plc_mms.sop_corba.GestionPlcTuPackage.ListaDtoHelper.write ($out, prmListaTU);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                actualizarLista (prmListaTU        );
            } finally {
                _releaseReply ($in);
            }
  } // actualizarLista

  public boolean eliminarTU (String idTu)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("eliminarTU", true);
                $out.write_string (idTu);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return eliminarTU (idTu        );
            } finally {
                _releaseReply ($in);
            }
  } // eliminarTU

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:sop_corba/GestionPlcTu:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }

  private void readObject (java.io.ObjectInputStream s) throws java.io.IOException
  {
     String str = s.readUTF ();
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     org.omg.CORBA.Object obj = orb.string_to_object (str);
     org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate ();
     _set_delegate (delegate);
   } finally {
     orb.destroy() ;
   }
  }

  private void writeObject (java.io.ObjectOutputStream s) throws java.io.IOException
  {
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     String str = orb.object_to_string (this);
     s.writeUTF (str);
   } finally {
     orb.destroy() ;
   }
  }
} // class _GestionPlcTuStub
