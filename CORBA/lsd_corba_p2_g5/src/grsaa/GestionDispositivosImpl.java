package grsaa;

public class GestionDispositivosImpl extends grsaa.sop_corba.GestionDispositivosPOA{

    @Override
    public void notificacionmms(int mmsid) {
        System.out.println("El dispositivo PLC_MMS con Id:"+ mmsid +" completo sus registros y esta activo en el sistema");
    }
}
