package plc_mms.sop_corba;


/**
* plc_mms/sop_corba/_GestionUsuariosStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from gesusuarios.idl
* domingo 2 de junio de 2024 08:21:24 PM COT
*/

public class _GestionUsuariosStub extends org.omg.CORBA.portable.ObjectImpl implements plc_mms.sop_corba.GestionUsuarios
{

  public int abrirSesion (plc_mms.sop_corba.GestionUsuariosPackage.usuarioDTO objUsuario)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("abrirSesion", true);
                plc_mms.sop_corba.GestionUsuariosPackage.usuarioDTOHelper.write ($out, objUsuario);
                $in = _invoke ($out);
                int $result = $in.read_long ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return abrirSesion (objUsuario        );
            } finally {
                _releaseReply ($in);
            }
  } // abrirSesion

  public boolean consultarUsuario (int id, plc_mms.sop_corba.GestionUsuariosPackage.usuarioDTOHolder objUsuario)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("consultarUsuario", true);
                $out.write_long (id);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                objUsuario.value = plc_mms.sop_corba.GestionUsuariosPackage.usuarioDTOHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return consultarUsuario (id, objUsuario        );
            } finally {
                _releaseReply ($in);
            }
  } // consultarUsuario

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:sop_corba/GestionUsuarios:1.0"};

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
} // class _GestionUsuariosStub
