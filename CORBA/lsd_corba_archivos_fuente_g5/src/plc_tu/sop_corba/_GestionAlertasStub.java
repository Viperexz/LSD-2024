package plc_tu.sop_corba;


/**
* plc_tu/sop_corba/_GestionAlertasStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from gesalertas.idl
* domingo 2 de junio de 2024 08:21:24 PM COT
*/

public class _GestionAlertasStub extends org.omg.CORBA.portable.ObjectImpl implements plc_tu.sop_corba.GestionAlertas
{

  public void notificar (plc_tu.sop_corba.GestionAlertasPackage.alertaDto objAlerta)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("notificar", true);
                plc_tu.sop_corba.GestionAlertasPackage.alertaDtoHelper.write ($out, objAlerta);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                notificar (objAlerta        );
            } finally {
                _releaseReply ($in);
            }
  } // notificar

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:sop_corba/GestionAlertas:1.0"};

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
} // class _GestionAlertasStub