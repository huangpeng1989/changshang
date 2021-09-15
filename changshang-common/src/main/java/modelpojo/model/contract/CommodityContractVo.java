package modelpojo.model.contract;

import java.io.Serializable;

/**
 * 
 * 
 * @author LK
 * 
 * @date 2020-12-31
 */
public class CommodityContractVo extends CommodityContract implements Serializable {

    private String contractSupperName;

    public String getContractSupperName() {
        return contractSupperName;
    }

    public void setContractSupperName(String contractSupperName) {
        this.contractSupperName = contractSupperName;
    }
}