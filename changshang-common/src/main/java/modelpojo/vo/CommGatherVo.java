package modelpojo.vo;

import java.io.Serializable;
import java.math.BigDecimal;


public class CommGatherVo implements Serializable{

    private String comName;//商品名称

    private String oneClass;//一级分类

    private String twoClass;//二级分类

    private String threeClass;//三级分类

    private String comSpec;//规格
    private String comUnit;//商品单位
    private String sellModel;//经营方式

    private BigDecimal startCount  ;//期初库存

    private BigDecimal startTaxCost  ;//期初含税成本

    private BigDecimal startNoTaxCost ;//期初未税成本


    private BigDecimal sellCount  ;//本期销售总数

    private BigDecimal sellTaxCost  ;// 销售含税成本

    private BigDecimal sellNoTaxCost   ;//销售未税成本



    private BigDecimal iNCount  ;//本期进货总数

    private BigDecimal iNTaxCost  ;//进货含税成本

    private BigDecimal iNNoTaxCost;//进货未税成本


    private BigDecimal qINCount    ;//本期退货总数

    private BigDecimal qINTaxCost    ;//退货含税成本

    private BigDecimal qINNoTaxCost;//退货未税成本


    private BigDecimal lossCount ;//本期消耗总数

    private BigDecimal lossTaxCost ;//消耗含税成本

    private BigDecimal lossNoTaxCost;//消耗未税成本


    private BigDecimal allotOutCount   ;//本期调出总数

    private BigDecimal allotOutTaxCost   ;//调出含税成本

    private BigDecimal allotOutNoTaxCost;//调出未税成本


    private BigDecimal allotInCount     ;//本期调入总数

    private BigDecimal allotInTaxCost     ;//调入含税成本

    private BigDecimal allotInNoTaxCost;//调入未税成本


    private BigDecimal recCount       ;//本期领用总数

    private BigDecimal recTaxCost       ;//领用含税成本

    private BigDecimal recNoTaxCost;//领用未税成本


    private BigDecimal returnCount         ;//本期归还总数

    private BigDecimal returnTaxCost         ;//归还含税成本

    private BigDecimal returnNoTaxCost;//归还未税成本


    private BigDecimal breakCount           ;//本期报损总数

    private BigDecimal breakTaxCost           ;//报损含税成本

    private BigDecimal breakNoTaxCost;//报损未税成本


    private BigDecimal flowCount  ;//本期报溢总数

    private BigDecimal flowTaxCost  ;//报溢含税成本

    private BigDecimal flowNoTaxCost;//报溢未税成本



    private BigDecimal ivbreakCount  ;//本期盘盈总数

    private BigDecimal ivbreakTaxCost  ;//盘盈含税成本

    private BigDecimal ivbreakNoTaxCost;//盘盈未税成本



    private BigDecimal ivflowCount  ;//本期盘亏总数

    private BigDecimal ivflowTaxCost  ;//盘亏含税成本

    private BigDecimal ivflowNoTaxCost ;//盘亏未税成本


    private BigDecimal endCount  ;//期未库存总数

    private BigDecimal endTaxCost  ;//期未含税成本

    private BigDecimal endNoTaxCost ;//期未未税成本


    private Integer totalCount;


    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public String getSellModel() {
        return sellModel;
    }

    public void setSellModel(String sellModel) {
        this.sellModel = sellModel;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getOneClass() {
        return oneClass;
    }

    public void setOneClass(String oneClass) {
        this.oneClass = oneClass;
    }

    public String getTwoClass() {
        return twoClass;
    }

    public void setTwoClass(String twoClass) {
        this.twoClass = twoClass;
    }

    public String getThreeClass() {
        return threeClass;
    }

    public void setThreeClass(String threeClass) {
        this.threeClass = threeClass;
    }

    public String getComSpec() {
        return comSpec;
    }

    public void setComSpec(String comSpec) {
        this.comSpec = comSpec;
    }

    public String getComUnit() {
        return comUnit;
    }

    public void setComUnit(String comUnit) {
        this.comUnit = comUnit;
    }

    public BigDecimal getStartCount() {
        return startCount;
    }

    public void setStartCount(BigDecimal startCount) {
        this.startCount = startCount;
    }

    public BigDecimal getStartTaxCost() {
        return startTaxCost;
    }

    public void setStartTaxCost(BigDecimal startTaxCost) {
        this.startTaxCost = startTaxCost;
    }

    public BigDecimal getStartNoTaxCost() {
        return startNoTaxCost;
    }

    public void setStartNoTaxCost(BigDecimal startNoTaxCost) {
        this.startNoTaxCost = startNoTaxCost;
    }

    public BigDecimal getSellCount() {
        return sellCount;
    }

    public void setSellCount(BigDecimal sellCount) {
        this.sellCount = sellCount;
    }

    public BigDecimal getSellTaxCost() {
        return sellTaxCost;
    }

    public void setSellTaxCost(BigDecimal sellTaxCost) {
        this.sellTaxCost = sellTaxCost;
    }

    public BigDecimal getSellNoTaxCost() {
        return sellNoTaxCost;
    }

    public void setSellNoTaxCost(BigDecimal sellNoTaxCost) {
        this.sellNoTaxCost = sellNoTaxCost;
    }


    public BigDecimal getiNCount() {
        return iNCount;
    }

    public void setiNCount(BigDecimal iNCount) {
        this.iNCount = iNCount;
    }

    public BigDecimal getiNTaxCost() {
        return iNTaxCost;
    }

    public void setiNTaxCost(BigDecimal iNTaxCost) {
        this.iNTaxCost = iNTaxCost;
    }

    public BigDecimal getiNNoTaxCost() {
        return iNNoTaxCost;
    }

    public void setiNNoTaxCost(BigDecimal iNNoTaxCost) {
        this.iNNoTaxCost = iNNoTaxCost;
    }

    public BigDecimal getqINCount() {

        return qINCount;
    }

    public void setqINCount(BigDecimal qINCount) {
        this.qINCount = qINCount;
    }

    public BigDecimal getqINTaxCost() {
        return qINTaxCost;
    }

    public void setqINTaxCost(BigDecimal qINTaxCost) {
        this.qINTaxCost = qINTaxCost;
    }

    public BigDecimal getqINNoTaxCost() {
        return qINNoTaxCost;
    }

    public void setqINNoTaxCost(BigDecimal qINNoTaxCost) {
        this.qINNoTaxCost = qINNoTaxCost;
    }

    public BigDecimal getLossCount() {
        return lossCount;
    }

    public void setLossCount(BigDecimal lossCount) {
        this.lossCount = lossCount;
    }

    public BigDecimal getLossTaxCost() {
        return lossTaxCost;
    }

    public void setLossTaxCost(BigDecimal lossTaxCost) {
        this.lossTaxCost = lossTaxCost;
    }

    public BigDecimal getLossNoTaxCost() {
        return lossNoTaxCost;
    }

    public void setLossNoTaxCost(BigDecimal lossNoTaxCost) {
        this.lossNoTaxCost = lossNoTaxCost;
    }

    public BigDecimal getAllotOutCount() {
        return allotOutCount;
    }

    public void setAllotOutCount(BigDecimal allotOutCount) {
        this.allotOutCount = allotOutCount;
    }

    public BigDecimal getAllotOutTaxCost() {
        return allotOutTaxCost;
    }

    public void setAllotOutTaxCost(BigDecimal allotOutTaxCost) {
        this.allotOutTaxCost = allotOutTaxCost;
    }

    public BigDecimal getAllotOutNoTaxCost() {
        return allotOutNoTaxCost;
    }

    public void setAllotOutNoTaxCost(BigDecimal allotOutNoTaxCost) {
        this.allotOutNoTaxCost = allotOutNoTaxCost;
    }

    public BigDecimal getAllotInCount() {
        return allotInCount;
    }

    public void setAllotInCount(BigDecimal allotInCount) {
        this.allotInCount = allotInCount;
    }

    public BigDecimal getAllotInTaxCost() {
        return allotInTaxCost;
    }

    public void setAllotInTaxCost(BigDecimal allotInTaxCost) {
        this.allotInTaxCost = allotInTaxCost;
    }

    public BigDecimal getAllotInNoTaxCost() {
        return allotInNoTaxCost;
    }

    public void setAllotInNoTaxCost(BigDecimal allotInNoTaxCost) {
        this.allotInNoTaxCost = allotInNoTaxCost;
    }

    public BigDecimal getRecCount() {
        return recCount;
    }

    public void setRecCount(BigDecimal recCount) {
        this.recCount = recCount;
    }

    public BigDecimal getRecTaxCost() {
        return recTaxCost;
    }

    public void setRecTaxCost(BigDecimal recTaxCost) {
        this.recTaxCost = recTaxCost;
    }

    public BigDecimal getRecNoTaxCost() {
        return recNoTaxCost;
    }

    public void setRecNoTaxCost(BigDecimal recNoTaxCost) {
        this.recNoTaxCost = recNoTaxCost;
    }

    public BigDecimal getReturnCount() {
        return returnCount;
    }

    public void setReturnCount(BigDecimal returnCount) {
        this.returnCount = returnCount;
    }

    public BigDecimal getReturnTaxCost() {
        return returnTaxCost;
    }

    public void setReturnTaxCost(BigDecimal returnTaxCost) {
        this.returnTaxCost = returnTaxCost;
    }

    public BigDecimal getReturnNoTaxCost() {
        return returnNoTaxCost;
    }

    public void setReturnNoTaxCost(BigDecimal returnNoTaxCost) {
        this.returnNoTaxCost = returnNoTaxCost;
    }

    public BigDecimal getBreakCount() {
        return breakCount;
    }

    public void setBreakCount(BigDecimal breakCount) {
        this.breakCount = breakCount;
    }

    public BigDecimal getBreakTaxCost() {
        return breakTaxCost;
    }

    public void setBreakTaxCost(BigDecimal breakTaxCost) {
        this.breakTaxCost = breakTaxCost;
    }

    public BigDecimal getBreakNoTaxCost() {
        return breakNoTaxCost;
    }

    public void setBreakNoTaxCost(BigDecimal breakNoTaxCost) {
        this.breakNoTaxCost = breakNoTaxCost;
    }

    public BigDecimal getFlowCount() {
        return flowCount;
    }

    public void setFlowCount(BigDecimal flowCount) {
        this.flowCount = flowCount;
    }

    public BigDecimal getFlowTaxCost() {
        return flowTaxCost;
    }

    public void setFlowTaxCost(BigDecimal flowTaxCost) {
        this.flowTaxCost = flowTaxCost;
    }

    public BigDecimal getFlowNoTaxCost() {
        return flowNoTaxCost;
    }

    public void setFlowNoTaxCost(BigDecimal flowNoTaxCost) {
        this.flowNoTaxCost = flowNoTaxCost;
    }

    public BigDecimal getIvbreakCount() {
        return ivbreakCount;
    }

    public void setIvbreakCount(BigDecimal ivbreakCount) {
        this.ivbreakCount = ivbreakCount;
    }

    public BigDecimal getIvbreakTaxCost() {
        return ivbreakTaxCost;
    }

    public void setIvbreakTaxCost(BigDecimal ivbreakTaxCost) {
        this.ivbreakTaxCost = ivbreakTaxCost;
    }

    public BigDecimal getIvbreakNoTaxCost() {
        return ivbreakNoTaxCost;
    }

    public void setIvbreakNoTaxCost(BigDecimal ivbreakNoTaxCost) {
        this.ivbreakNoTaxCost = ivbreakNoTaxCost;
    }

    public BigDecimal getIvflowCount() {
        return ivflowCount;
    }

    public void setIvflowCount(BigDecimal ivflowCount) {
        this.ivflowCount = ivflowCount;
    }

    public BigDecimal getIvflowTaxCost() {
        return ivflowTaxCost;
    }

    public void setIvflowTaxCost(BigDecimal ivflowTaxCost) {
        this.ivflowTaxCost = ivflowTaxCost;
    }

    public BigDecimal getIvflowNoTaxCost() {
        return ivflowNoTaxCost;
    }

    public void setIvflowNoTaxCost(BigDecimal ivflowNoTaxCost) {
        this.ivflowNoTaxCost = ivflowNoTaxCost;
    }

    public BigDecimal getEndCount() {
        return endCount;
    }

    public void setEndCount(BigDecimal endCount) {
        this.endCount = endCount;
    }

    public BigDecimal getEndTaxCost() {
        return endTaxCost;
    }

    public void setEndTaxCost(BigDecimal endTaxCost) {
        this.endTaxCost = endTaxCost;
    }

    public BigDecimal getEndNoTaxCost() {
        return endNoTaxCost;
    }

    public void setEndNoTaxCost(BigDecimal endNoTaxCost) {
        this.endNoTaxCost = endNoTaxCost;
    }
}
