package ss.test.pageHelper;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import ss.mapper.TbItemMapper;
import ss.model.TbItem;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class SpringTestPageHelper {
    @Resource
    private TbItemMapper tbItemMapper;

    @Test
    public void m2() {
        System.out.println(222);
        //初始化Spring容器
        //ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring.xml");
        //得到需要的代理mapper对象
        //TbItemMapper tm = ac.getBean(TbItemMapper.class);

        //System.out.println(tbItemMapper.queryAllItems());
        //调用分页插件
        PageHelper.startPage(1, 30);

        /*查询出需要的某页的数据（因为在mybatis也有过滤器的概念，在执行sql语句之前先进行过滤，
         此时过滤就要通过分页插件的允许，以至于只能查出某页数据，很好用）*/
        List<TbItem> tbItems = tbItemMapper.queryAllItems();

        for (TbItem t : tbItems) {
            System.out.println(t);
        }
        //得到分页某些信息
        //例如得到总条数,需要用到的类是PageInfo(第三方插件的类)
        PageInfo pi = new PageInfo(tbItems);

        System.out.println(pi.getTotal());


    }
}
