package com.yzeng.entity;

/**
 * 菜单实体，对应数据库w_menu表
 * @author  yzblog.xyz
 * @version  [1.0, 2018年11月19日]
 * @Email yzengchn@163.com
 * @since  [产品/模块版本]
 */
public class MenuVo {
	private String id;
    
    private String name;
    
    private String type;
    
    private String key;
    
    private String url;
    
    private String status;
    
    private String pId;
    
    private int isParent;
    
    private int needAuth;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public int getIsParent() {
		return isParent;
	}

	public void setIsParent(int isParent) {
		this.isParent = isParent;
	}

	public int getNeedAuth() {
		return needAuth;
	}

	public void setNeedAuth(int needAuth) {
		this.needAuth = needAuth;
	}
    
}
