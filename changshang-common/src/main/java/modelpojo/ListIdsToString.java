package modelpojo;

import java.util.List;

/**
 * 集合ID转String
 * @author lixiang
 * @data 2019-09-11
 */
public class ListIdsToString {

    public static String getIds (List<Integer> idList) {
        String ids = "";
        if (null != idList && idList.size() > 0) {
            for (int k = 0; k < idList.size(); k++) {
                if ((k + 1) == idList.size()) {
                    ids += "'" + idList.get(k) + "'";
                } else {
                    ids += "'" + idList.get(k) + "',";
                }
            }
        }
        return ids;
    }

    public static String toIds (List<String> idList) {
        String ids = "";
        if (null != idList && idList.size() > 0) {
            for (int k = 0; k < idList.size(); k++) {
                if ((k + 1) == idList.size()) {
                    ids += "'" + idList.get(k) + "'";
                } else {
                    ids += "'" + idList.get(k) + "',";
                }
            }
        }
        return ids;
    }
}
