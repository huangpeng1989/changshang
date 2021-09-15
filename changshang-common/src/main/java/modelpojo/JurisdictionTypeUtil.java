package modelpojo;

import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.TreeMap;

public class JurisdictionTypeUtil<E>{

    public void getjurisdictionType(List<E> list, String whIds){
        try {
            String[] strs = {};
            if(StringUtils.isNotEmpty(whIds)) {                 
                strs = whIds.split(",");
            }
            if(strs.length == 0){
                for (E item: list){
                    Field field1 = item.getClass().getDeclaredField("jurisdictionType");
                    field1.setAccessible(true);
                    field1.set(item, 1);
                }
            }else {
                for (E item: list){
                    Field field = null;
                    Class className = item.getClass();
                    for(; className != Object.class ; className = className.getSuperclass()) {//获取本身和父级对象
                        Field[] fields = className.getDeclaredFields();//获取所有私有字段
                        for (Field field1 : fields) {
                            field1.setAccessible(true);
                            if("whId".equals(field1.getName())){
                                field = field1;
                                break;
                            }
                        }
                    }
                    for (String str: strs) {
                        field.setAccessible(true);
                        if(field.get(item) != null && str.equals(field.get(item).toString())){
                            Field field1 = item.getClass().getDeclaredField("jurisdictionType");
                            field1.setAccessible(true);
                            field1.set(item, 1);
                        }
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static  void getjurisdictionMapType(List<TreeMap> list, String whIds){
        try {
            String[] strs = {};
            if(StringUtils.isNotEmpty(whIds)) {
                strs = whIds.split(",");
            }
            if(strs.length == 0){
                for (TreeMap item: list){
                    item.put("jurisdictionType",1);
                }
            }else {
                for (TreeMap item: list){
                    Integer shu = 0;
                    for (String str: strs) {
                        if(str.equals(String.valueOf(item.get("whId")))){
                            item.put("jurisdictionType",1);
                            shu++;
                        }
                    }
                    if(shu == 0){
                        item.put("jurisdictionType",0);
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
