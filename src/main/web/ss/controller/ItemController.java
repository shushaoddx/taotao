package ss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ss.dataModel.DatagridModel;
import ss.dataModel.TreeModel;
import ss.model.TbItem;
import ss.service.ItemService;

import java.util.List;

@Controller
//equestMapping("itemController")
public class ItemController {

    @Autowired
    private ItemService itemService;

    /**
     * 测试框架整合
     */
    @RequestMapping(value = "/getItemById/{itemId}", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String getitem(@PathVariable Long itemId) {
        TbItem ti = itemService.getItemById(itemId);
        return ti.toString();
    }

    /**
     * 显示首页
     */
    @RequestMapping("/")
    public String showIndex() {
        return "index";
    }
    /*显示其他页面*/

    @RequestMapping("/{page}")
    public String index(@PathVariable String page) {
        return page;
    }


    @RequestMapping("/item/list")
    @ResponseBody
    public DatagridModel showAllItems(Integer page, Integer rows) {

        return itemService.showAllItems(page, rows);
    }

    @RequestMapping("/item/cat/list")
    @ResponseBody
    public List<TreeModel> getItemTypeZtree(@RequestParam(value = "id", defaultValue = "0") Long parentid) {
        List<TreeModel> treeModels = itemService.getItemTypeZtree(parentid);
        return treeModels;
    }

}
