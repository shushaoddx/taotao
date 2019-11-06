package ss.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ss.dataModel.DatagridModel;
import ss.dataModel.TreeModel;
import ss.mapper.TbItemCatMapper;
import ss.mapper.TbItemMapper;
import ss.model.TbItem;
import ss.model.TbItemCat;
import ss.service.ItemService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private TbItemMapper tm;
    @Autowired
    private TbItemCatMapper tbItemCatMapper;

    public TbItem getItemById(long itemId) {
        return tm.selectByPrimaryKey(itemId);
    }

    public DatagridModel showAllItems(Integer page, Integer rows) {
        //调用分页插件
        PageHelper.startPage(page, rows);
        //查询数据到分页插件里面去
        List Items = tm.queryAllItems();
        //查询总条数
        PageInfo pageInfo = new PageInfo(Items);
        //声明EasyUI的DatGrid数据类
        DatagridModel dm = new DatagridModel(pageInfo.getTotal(), Items);
        return dm;
    }

    public List<TreeModel> getItemTypeZtree(Long parentid) {

        //根据parentid查询出该父节点下所有子节点
        List<TbItemCat> tbItemCats = tbItemCatMapper.queryAllTbItemCatByParentid(parentid);

        List<TreeModel> treeModels = new ArrayList<TreeModel>();

        for (TbItemCat tic : tbItemCats) {
            TreeModel tm = new TreeModel(tic.getId(), tic.getName(), tic.getIsParent() ? "closed" : "open");
            //System.out.println(tic.getIsParent());
            treeModels.add(tm);
        }
        //System.out.println(treeModels);
        return treeModels;
    }
}
