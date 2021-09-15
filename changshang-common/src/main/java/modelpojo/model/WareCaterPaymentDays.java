package modelpojo.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Description 餐饮仓库账期报表实体
 * @Author wenbin.wang
 * @Date 2020-07-01 20:34
 */
public class WareCaterPaymentDays implements Serializable {
    private static final long serialVersionUID = 2215875464623718996L;


    private String whName;    //仓库名称
    private String whCode;    //仓库编号
    private String comName;   //原材料名称/半成品名称/菜品名称
    private String oneclass;  //一级分类
    private String twoclass;  //二级分类
    private String threeclass;  //三级分类
    private String comSpec;  //规格
    private String comUnit;  //单位
    private String dishSpec;  //销售规格（菜品才有）
    private String sellModel;  //经营方式
    private BigDecimal startCount; //期初库存
    private BigDecimal startTaxCost;//期初含税成本
    private BigDecimal startNoTaxCost;//期初未税成本

    private BigDecimal sellCount;  //' 本期销售总数'
    private BigDecimal sellTaxCost; //本期销售含税成本'
    private BigDecimal sellNoTaxCost;//本期销售未税成本'

    private BigDecimal inCount;   //' 本期进货总数'
    private BigDecimal inTaxCost;//' 本期进货含税成本'
    private BigDecimal inNoTaxCost;//' 本期进货未税成本'

    private BigDecimal qINCount;   //' 本期退货总数'
    private BigDecimal qINTaxCost;//' 本期退货含税成本'
    private BigDecimal qINNoTaxCost;//' 本期退货未税成本'

    private BigDecimal lossCount; //' 本期消耗总数'
    private BigDecimal lossTaxCost;//' 本期消耗含税成本'
    private BigDecimal lossNoTaxCost;//' 本期消耗未税成本'

    private BigDecimal allotOutCount;  //' 本期调出总数'
    private BigDecimal allotOutTaxCost;//' 本期调出含税成本'
    private BigDecimal allotOutNoTaxCost;//' 本期调出未税成本'

    private BigDecimal allotInCount;  //' 本期调入总数'
    private BigDecimal allotInTaxCost;//' 本期调入含税成本'
    private BigDecimal allotInNoTaxCost;//' 本期调入未税成本'

    private BigDecimal recCount;  //' 本期领用总数'
    private BigDecimal recTaxCost;//' 本期领用含税成本
    private BigDecimal recNoTaxCost;//' 本期领用未税成本

    private BigDecimal returnCount;//' 本期归还总数'
    private BigDecimal returnTaxCost;//' 本期归还含税成本'
    private BigDecimal returnNoTaxCost;//' 本期归还未税成本'

    private BigDecimal breakCount;//' 本期报损总数'
    private BigDecimal breakTaxCost;//' 本期销售含税总数'
    private BigDecimal breakNoTaxCost;//' 本期销售未税总数'

    private BigDecimal flowCount;//' ' 本期报溢总数''
    private BigDecimal flowTaxCost;//' ' 本期报溢含税成本''
    private BigDecimal flowNoTaxCost;//' ' 本期报溢未税成本''

    private BigDecimal ivbreakCount;//' ' 本期盘盈总数''
    private BigDecimal ivbreakTaxCost;//' ' 本期盘盈含税成本''
    private BigDecimal ivbreakNoTaxCost;//' ' 本期盘盈未税成本''

    private BigDecimal ivflowCount;//' ' 本期盘亏总数''
    private BigDecimal ivflowTaxCost;//' ' 本期盘亏含税成本''
    private BigDecimal ivflowNoTaxCost;//' ' 本期盘亏未税成本''

    private BigDecimal tranCount;//' ' 本期转换总数''
    private BigDecimal tranTaxCost;//' ' 本期转换含税成本''
    private BigDecimal tranNoTaxCost;//' ' 本期转换未税成本''

    private BigDecimal proccCount;//' ' 本期加工总数''
    private BigDecimal proccTaxCost;//' ' 本期加工含税成本''
    private BigDecimal proccNoTaxCost;//' ' 本期加工未税成本''

    private BigDecimal endCount;//' ' 期末库存''
    private BigDecimal endTaxCost;//' ' 期末含税成本''
    private BigDecimal endNoTaxCost;//' ' 期末未税成本''


    private Integer totalCount;  //总数量

    public String getSellModel() {
        return sellModel;
    }

    public void setSellModel(String sellModel) {
        this.sellModel = sellModel;
    }

    public String getDishSpec() {
        return dishSpec;
    }

    public void setDishSpec(String dishSpec) {
        this.dishSpec = dishSpec;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public String getWhName() {
        return whName;
    }

    public void setWhName(String whName) {
        this.whName = whName;
    }

    public String getWhCode() {
        return whCode;
    }

    public void setWhCode(String whCode) {
        this.whCode = whCode;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getOneclass() {
        return oneclass;
    }

    public void setOneclass(String oneclass) {
        this.oneclass = oneclass;
    }

    public String getTwoclass() {
        return twoclass;
    }

    public void setTwoclass(String twoclass) {
        this.twoclass = twoclass;
    }

    public String getThreeclass() {
        return threeclass;
    }

    public void setThreeclass(String threeclass) {
        this.threeclass = threeclass;
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

    public BigDecimal getInCount() {
        return inCount;
    }

    public void setInCount(BigDecimal inCount) {
        this.inCount = inCount;
    }

    public BigDecimal getInTaxCost() {
        return inTaxCost;
    }

    public void setInTaxCost(BigDecimal inTaxCost) {
        this.inTaxCost = inTaxCost;
    }

    public BigDecimal getInNoTaxCost() {
        return inNoTaxCost;
    }

    public void setInNoTaxCost(BigDecimal inNoTaxCost) {
        this.inNoTaxCost = inNoTaxCost;
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

    public BigDecimal getTranCount() {
        return tranCount;
    }

    public void setTranCount(BigDecimal tranCount) {
        this.tranCount = tranCount;
    }

    public BigDecimal getTranTaxCost() {
        return tranTaxCost;
    }

    public void setTranTaxCost(BigDecimal tranTaxCost) {
        this.tranTaxCost = tranTaxCost;
    }

    public BigDecimal getTranNoTaxCost() {
        return tranNoTaxCost;
    }

    public void setTranNoTaxCost(BigDecimal tranNoTaxCost) {
        this.tranNoTaxCost = tranNoTaxCost;
    }

    public BigDecimal getProccCount() {
        return proccCount;
    }

    public void setProccCount(BigDecimal proccCount) {
        this.proccCount = proccCount;
    }

    public BigDecimal getProccTaxCost() {
        return proccTaxCost;
    }

    public void setProccTaxCost(BigDecimal proccTaxCost) {
        this.proccTaxCost = proccTaxCost;
    }

    public BigDecimal getProccNoTaxCost() {
        return proccNoTaxCost;
    }

    public void setProccNoTaxCost(BigDecimal proccNoTaxCost) {
        this.proccNoTaxCost = proccNoTaxCost;
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
