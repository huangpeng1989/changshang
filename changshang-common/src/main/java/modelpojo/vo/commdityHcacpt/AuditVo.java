package modelpojo.vo.commdityHcacpt;

import java.io.Serializable;
import java.util.List;

public class AuditVo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3560875875859019588L;

	private Boolean status;
	
	List<CanHcVo> failedList;

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public List<CanHcVo> getFailedList() {
		return failedList;
	}

	public void setFailedList(List<CanHcVo> failedList) {
		this.failedList = failedList;
	}
	
}
