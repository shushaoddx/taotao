package ss.service;

import ss.dataModel.DatagridModel;
import ss.dataModel.TreeModel;
import ss.model.TbItem;

import java.util.List;

public interface ItemService {
    TbItem getItemById(long itemId);

    DatagridModel showAllItems(Integer page, Integer rows);

    List<TreeModel> getItemTypeZtree(Long parentid);
}
