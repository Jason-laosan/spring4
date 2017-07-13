package com.base;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by jinkai on 12/07/2017.
 */
public class CommonJsonResult {
    private static final long serialVersionUID = -8832372194080675679L;
    protected static final String FLAG = "flag";
    protected static final String REASON = "reason";
    public static final String TOTAL_RECORDS = "totalRecords";
    public static final String PAGE_SIZE = "pageSize";
    public static final String NEXT_PAGE = "nextPage";
    public static final String HAS_NEXT_PAGE = "hasNextPage";
    private Map<String, Object> infoMap = new HashMap();
    private List<Object> resultList = new LinkedList();

    public CommonJsonResult(int code, String message) {
        this.setInfoMap("flag", "" + code);
        this.setInfoMap("reason", message);
    }

    public CommonJsonResult(String message) {
        this.setInfoMap("flag", "0");
        this.setInfoMap("reason", message);
    }

    public CommonJsonResult() {
        this.setSuccess();
    }

    public void setInfoMap(String key, Object value) {
        this.infoMap.put(key, value);
    }

    public void setInfoMap(Map<String, Object> infoMap) {
        this.infoMap.putAll(infoMap);
    }

    public void addResultList(Object obj) {
        if(this.resultList == null) {
            this.resultList = new LinkedList();
        }

        this.resultList.add(obj);
    }

    public void setResultList(List<? extends Object> list) {
        if(this.resultList == null) {
            this.resultList = new LinkedList();
        }

        this.resultList.addAll(list);
    }

    public void setSuccess(String reason) {
        this.setInfoMap("flag", "1");
        this.setInfoMap("reason", reason);
    }

    public void setSuccess() {
        this.setSuccess("successes");
    }

    public void setFailure(String reason) {
        this.setInfoMap("flag", "0");
        this.setInfoMap("reason", reason);
    }

    public void setFailure() {
        this.setFailure("fail");
    }

    public void setPaging(long totalRecords, int pageSize, int nextPage) {
        this.setInfoMap("totalRecords", Long.valueOf(totalRecords));
        this.setInfoMap("pageSize", Integer.valueOf(pageSize));
        this.setInfoMap("nextPage", Integer.valueOf(nextPage));
        this.setInfoMap("hasNextPage", Boolean.valueOf(nextPage > 0));
    }

    public void setPaging(long totalRecords, int pageSize, int nextPage, boolean hasNextPage) {
        this.setInfoMap("totalRecords", Long.valueOf(totalRecords));
        this.setInfoMap("pageSize", Integer.valueOf(pageSize));
        this.setInfoMap("nextPage", Integer.valueOf(nextPage));
        this.setInfoMap("hasNextPage", Boolean.valueOf(hasNextPage));
    }

    public Map<String, Object> getInfoMap() {
        return this.infoMap;
    }

    public List<Object> getResultList() {
        return this.resultList;
    }

    public void setPage(Page<?> page) {
        this.setInfoMap("totalRecords", Long.valueOf(page.getTotal()));
        this.setInfoMap("pageSize", Long.valueOf(page.getLength()));
        boolean hasNextPage = (long)page.getPage_num() * page.getLength() < page.getTotal();
        if(hasNextPage) {
            this.setInfoMap("nextPage", Integer.valueOf(page.getPage_num() + 1));
        }

        this.setInfoMap("hasNextPage", Boolean.valueOf(hasNextPage));
    }
}
