package modelpojo.vo.cateringcheck;

import java.io.Serializable;
import java.util.List;

public class AuditVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5202197843724711528L;
	List<AuditMOrSfVo> listAuditMVo;
	List<AuditMOrSfVo> listAuditSfVo;

	Integer  isEstimate;
	AuditMOrSfVo auditMCountVo;
	AuditMOrSfVo auditSfCountVo;

	public Integer getIsEstimate() {
		return isEstimate;
	}

	public void setIsEstimate(Integer isEstimate) {
		this.isEstimate = isEstimate;
	}

	public List<AuditMOrSfVo> getListAuditMVo() {
		return listAuditMVo;
	}
	public void setListAuditMVo(List<AuditMOrSfVo> listAuditMVo) {
		this.listAuditMVo = listAuditMVo;
	}
	public List<AuditMOrSfVo> getListAuditSfVo() {
		return listAuditSfVo;
	}
	public void setListAuditSfVo(List<AuditMOrSfVo> listAuditSfVo) {
		this.listAuditSfVo = listAuditSfVo;
	}
	public AuditMOrSfVo getAuditMCountVo() {
		return auditMCountVo;
	}
	public void setAuditMCountVo(AuditMOrSfVo auditMCountVo) {
		this.auditMCountVo = auditMCountVo;
	}
	public AuditMOrSfVo getAuditSfCountVo() {
		return auditSfCountVo;
	}
	public void setAuditSfCountVo(AuditMOrSfVo auditSfCountVo) {
		this.auditSfCountVo = auditSfCountVo;
	}
	
}
