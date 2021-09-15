package modelpojo;

import java.util.*;

/**
 *
 * @author LK
 */
public enum FlagTypeEnum {

	/**
	 * 新增
	 */
	add("add","新增"),
	/**
	 * 修改
	 */
	update("update","修改"),
	/**
	 * 删除
	 */
	del("del","删除"),

	/**
	 *
	 */
	no("no","无");



	private String name;
	private String desc;


	public static List<FlagTypeEnum> getAllItems() {
		return Arrays.asList(FlagTypeEnum.values());
	}

	public static List<Map<String, String>> getAllForMap(){
		List<Map<String, String>> list = new ArrayList<Map<String,String>>();
		for(FlagTypeEnum edu: FlagTypeEnum.values()) {
			Map<String, String> map = new HashMap<>();
			map.put("name", edu.getName());
			map.put("desc", edu.getDesc());
			list.add(map);
		}
		return list;
	}

	private FlagTypeEnum(String name, String desc) {
		this.name = name;
		this.desc = desc;
	}

	public static String getNameByDesc(String desc){
		List<FlagTypeEnum> allItems = getAllItems();
		for(FlagTypeEnum item : allItems){
			if (item.getDesc().equals(desc)){
				return item.getName();
			}
		}
		return "";
	}

	public static String getDescByName(String name){
		List<FlagTypeEnum> allItems = getAllItems();
		for(FlagTypeEnum item : allItems){
			if (item.getName().equals(name)){
				return item.getDesc();
			}
		}
		return "";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public static Map<String, String> getMap() {
		Map<String, String> map = new LinkedHashMap<>();
		for (FlagTypeEnum edu : FlagTypeEnum.values()) {
			map.put(edu.getName(), edu.getDesc());
		}
		return map;
	}

}
