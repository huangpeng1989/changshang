package entity;

import modelpojo.model.CateringTccDishesClassModel;
import modelpojo.model.CateringTccRawmaterClass;
import modelpojo.model.CommodityTccSuppclassModel;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 树形结构生成
 * @author lixiang
 * @data 2019.08.24
 */
public class TreeRecursion {
    /**
     * 递归处理   数据库树结构数据->树形json（不同表，通过level参数判断）
     * @param curCommodityTccSuppClass 当前最大父节点
     * @param nodes 所有的集合
     * @author lixiang
     * @return
     */
    public static void getNodeJson(CommodityTccSuppclassModel curCommodityTccSuppClass, List<CommodityTccSuppclassModel> nodes){
        //当前层级当前点下的所有子节点
        List<CommodityTccSuppclassModel> childList = nodes.stream().filter(a -> {
            return curCommodityTccSuppClass.getSuppId().equals(a.getUsuppId());
        }).collect(Collectors.toList());
        curCommodityTccSuppClass.setChildren(childList);

        if (childList != null && childList.size() > 0) {
            childList.forEach(a -> {
                getNodeJson(a, nodes);
            });
        }
    }

    /**
     * 递归处理   数据库树结构数据->树形json（不 同表，通过level参数判断）
     * @param rawmaterClass 当前最大父节点
     * @param nodes 所有的集合
     * @author lixiang
     * @return
     */
    public static void getNodeJson(CateringTccRawmaterClass rawmaterClass, List<CateringTccRawmaterClass> nodes){
        //当前层级当前点下的所有子节点
        List<CateringTccRawmaterClass> childList = nodes.stream().filter(a -> {
            return rawmaterClass.getRmcId().equals(a.getUrmcId());
        }).collect(Collectors.toList());
        rawmaterClass.setChildren(childList);

        if (childList != null && childList.size() > 0) {
            childList.forEach(a -> {
                getNodeJson(a, nodes);
            });
        }
    }

    /**
     * 菜品分类递归处理   数据库树结构数据->树形json（不同表，通过level参数判断）
     * @param dishesClassModel 当前最大父节点
     * @param nodes 所有的集合
     * @author lixiang
     * @return
     */
    public static void getDishesClassJson(CateringTccDishesClassModel dishesClassModel, List<CateringTccDishesClassModel> nodes){
        //当前层级当前点下的所有子节点
        List<CateringTccDishesClassModel> childList = nodes.stream().filter(a -> {
            return dishesClassModel.getDishId().intValue()  == a.getUdishId().intValue();
        }).collect(Collectors.toList());
        dishesClassModel.setChildren(childList);

        if (childList != null && childList.size() > 0) {
            childList.forEach(a -> {
                getDishesClassJson(a, nodes);
            });
        }
    }


}
