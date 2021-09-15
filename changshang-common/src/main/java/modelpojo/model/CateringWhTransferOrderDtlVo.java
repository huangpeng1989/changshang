package modelpojo.model;

/**
 * @Description TODO
 * @Author wenbin.wang
 * @Date 2020-04-27 09:19
 */
public class CateringWhTransferOrderDtlVo extends CateringWhTransferOrderDtl {

    private String oldRmCode;
    private String oldRmName;
    private String rmName;
    private String oldWhStock;
    private String whStock;
    private String oldRmUnitName;
    private String rmUnitName;
    private String oldSpecName;
    private String specName;
    private String rmBarcode;
    private String oldRmBarcode;

    public String getRmName() {
        return rmName;
    }

    public void setRmName(String rmName) {
        this.rmName = rmName;
    }

    public String getRmBarcode() {
        return rmBarcode;
    }

    public void setRmBarcode(String rmBarcode) {
        this.rmBarcode = rmBarcode;
    }

    public String getOldRmBarcode() {
        return oldRmBarcode;
    }

    public void setOldRmBarcode(String oldRmBarcode) {
        this.oldRmBarcode = oldRmBarcode;
    }

    public String getOldRmCode() {
        return oldRmCode;
    }

    public void setOldRmCode(String oldRmCode) {
        this.oldRmCode = oldRmCode;
    }

    public String getOldRmName() {
        return oldRmName;
    }

    public void setOldRmName(String oldRmName) {
        this.oldRmName = oldRmName;
    }

    public String getOldWhStock() {
        return oldWhStock;
    }

    public void setOldWhStock(String oldWhStock) {
        this.oldWhStock = oldWhStock;
    }

    public String getWhStock() {
        return whStock;
    }

    public void setWhStock(String whStock) {
        this.whStock = whStock;
    }

    public String getOldRmUnitName() {
        return oldRmUnitName;
    }

    public void setOldRmUnitName(String oldRmUnitName) {
        this.oldRmUnitName = oldRmUnitName;
    }

    public String getRmUnitName() {
        return rmUnitName;
    }

    public void setRmUnitName(String rmUnitName) {
        this.rmUnitName = rmUnitName;
    }

    public String getOldSpecName() {
        return oldSpecName;
    }

    public void setOldSpecName(String oldSpecName) {
        this.oldSpecName = oldSpecName;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }
}
