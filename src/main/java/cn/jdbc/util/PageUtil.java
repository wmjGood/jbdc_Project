package cn.jdbc.util;

public class PageUtil {
    //当前页
    private  int pageindex;
    //页大小
    private  int  pageSize=5;
    //总页数    一共有多少页数据
    private  int pageCount;
    //总记录数    一共有多少条数据
    private  int tatolCount;

    public PageUtil() {
    }

    public PageUtil(int pageindex, int pageSize, int pageCount, int tatolCount) {
        this.pageindex = pageindex;
        this.pageSize = pageSize;
        this.pageCount = pageCount;
        this.tatolCount = tatolCount;
    }

    public int getPageindex() {
        return pageindex;
    }

    public void setPageindex(int pageindex) {
        this.pageindex = pageindex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getTatolCount() {
        return tatolCount;
    }


    //知道总记录数 和页大小 求总页数
     //如果总记录数取余页大小==0的话，就等于总记录数除页大小
    //如果总记录数取余页大小！=0的话，就等于总记录数除页大小+1
    public void setTatolCount(int tatolCount) {
        if (tatolCount>0){
            this.tatolCount = tatolCount;
            this.pageCount=(tatolCount%pageSize==0)?(tatolCount/pageSize):((tatolCount/pageSize)+1);
        }

    }

    @Override
    public String toString() {
        return "PageUtil{" +
                "pageindex=" + pageindex +
                ", pageSize=" + pageSize +
                ", pageCount=" + pageCount +
                ", tatolCount=" + tatolCount +
                '}';
    }
}
