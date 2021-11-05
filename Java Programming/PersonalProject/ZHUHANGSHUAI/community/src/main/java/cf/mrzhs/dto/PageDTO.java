package cf.mrzhs.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Data
public class PageDTO {
    private List<QuestionDTO> questions;
//    上一页
    private boolean showPrevious;
//    第一页
    private boolean showFirst;
//    下一页
    private boolean showNext;
//    最后一页
    private boolean showEnd;
//    当前页
    private Integer page;
//    全部页码
    private List<Integer> pages = new ArrayList<>();;


    public void setPagination(Integer totalCount, Integer page, Integer size) {
        
        Integer totalPage;
        if (totalCount % size == 0){
            totalPage = totalCount / size;
        }else{
            totalPage = totalCount /size +1;
        }
        if (page < 1){
            page = 1;
        }
        if (page > totalPage){
            page = totalPage;
        }
        this.page = page;
        pages.add(page);//1 2 3 4
        for (int i =1; i<=3; i++){
            if (page - i > 0){
                pages.add(0, page - i);
            }
            if (page+ i <= totalPage){
                pages.add(page+i);
            }
        }
        
//       如果页码等于第一页,不显示上一页的标签
        if (page == 1){
            showPrevious = false;
        }else{
            showPrevious=true;
        }
//        如果页码等于最后一页,不显示下一页的标签
        if (page== totalPage){
            showNext=false;
        }else {
            showNext=true;
        }
        
        if (pages.contains(1)){
            showFirst = false;
        }else {
            showFirst = true;
        }
        
        if (pages.contains(totalPage)){
            showEnd=false;
        }else {
            showEnd=true;
        }
    }
}
