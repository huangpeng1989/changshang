package modelpojo.vo.cateioflow;

/**
 * @program: phaseiiclota
 * @description: 仓库数据
 * @author: panda
 * @create: 2019-11-19 18:36
 **/
public class HouseVo extends House{

    private String companyIds;

    private String orgIds;

    public String getCompanyIds() {
        return companyIds;
    }

    public void setCompanyIds(String companyIds) {
        this.companyIds = companyIds;
    }

    public String getOrgIds() {
        return orgIds;
    }

    public void setOrgIds(String orgIds) {
        this.orgIds = orgIds;
    }
}
