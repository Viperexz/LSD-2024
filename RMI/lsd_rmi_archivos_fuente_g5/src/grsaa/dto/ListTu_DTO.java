package grsaa.dto;

import java.util.ArrayList;
import plc_mms.dto.DatosPlcTu_DTO;

public class ListTu_DTO {
    int mmsId;
    ArrayList <DatosPlcTu_DTO> listTU;

    public ListTu_DTO(int mmsId, ArrayList<DatosPlcTu_DTO> listTU) {
        this.mmsId = mmsId;
        this.listTU = listTU;
    }

    public ArrayList<DatosPlcTu_DTO> getListTU() {
        return listTU;
    }

    public void setListTU(ArrayList<DatosPlcTu_DTO> listTU) {
        this.listTU = listTU;
    }

    public int getMmsId() {
        return mmsId;
    }

    public void setMmsId(int mmsId) {
        this.mmsId = mmsId;
    }
}
